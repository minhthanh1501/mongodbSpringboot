package com.mongodb.MongodbSpring.controllers;

import com.mongodb.MongodbSpring.dto.request.UserRequest;
import com.mongodb.MongodbSpring.dto.response.ApiResponse;
import com.mongodb.MongodbSpring.dto.response.UserResponse;


import com.mongodb.MongodbSpring.services.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @PostMapping()
    ApiResponse<UserResponse> addUser(@RequestBody @Valid UserRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.addUser(request));
        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getUserByEmailRegex(@RequestParam(value = "search") String character) {
        ApiResponse<List<UserResponse>> apiResponse = new ApiResponse<>();
        System.out.println("ôkk");
        apiResponse.setResult(userService.getUserByEmailRegex(character));

        return apiResponse;
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUserById(@PathVariable("userId") String id) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.getUserById(id));
        return apiResponse;
    }
}
