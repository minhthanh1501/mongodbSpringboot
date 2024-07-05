package com.mongodb.MongodbSpring.mappers;


import com.mongodb.MongodbSpring.dto.request.UserRequest;
import com.mongodb.MongodbSpring.dto.response.UserResponse;
import com.mongodb.MongodbSpring.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest request);

    UserResponse toUserResponse(User user);
}
