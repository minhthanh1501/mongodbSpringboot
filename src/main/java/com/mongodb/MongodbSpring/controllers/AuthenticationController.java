package com.mongodb.MongodbSpring.controllers;

import com.mongodb.MongodbSpring.dto.request.AuthenticationRequest;
import com.mongodb.MongodbSpring.dto.request.IntrospectRequest;
import com.mongodb.MongodbSpring.dto.response.ApiResponse;
import com.mongodb.MongodbSpring.dto.response.AuthenticationResponse;
import com.mongodb.MongodbSpring.dto.response.IntrospectResponse;
import com.mongodb.MongodbSpring.dto.response.UserResponse;
import com.mongodb.MongodbSpring.services.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;


    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);

        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
