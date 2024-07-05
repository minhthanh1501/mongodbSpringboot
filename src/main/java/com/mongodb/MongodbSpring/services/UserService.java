package com.mongodb.MongodbSpring.services;

import com.mongodb.MongodbSpring.dto.request.UserRequest;
import com.mongodb.MongodbSpring.dto.response.UserResponse;
import com.mongodb.MongodbSpring.enums.Role;
import com.mongodb.MongodbSpring.exceptions.AppException;
import com.mongodb.MongodbSpring.exceptions.ErrorCode;
import com.mongodb.MongodbSpring.mappers.UserMapper;
import com.mongodb.MongodbSpring.models.User;
import com.mongodb.MongodbSpring.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse addUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);

       return userMapper.toUserResponse(userRepository.save(user));
    }


    public UserResponse getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        return userMapper.toUserResponse(user);
    }

    public List<UserResponse> getUserByEmailRegex(String character){
        String regex = ".*" + character + ".*";
        List<User> list = userRepository.SearchByEmailRegex(regex);
//        System.out.println("list"+list);
        return list.stream().map(userMapper::toUserResponse).toList();
    }
}
