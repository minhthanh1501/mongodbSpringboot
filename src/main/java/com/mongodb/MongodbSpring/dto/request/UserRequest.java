package com.mongodb.MongodbSpring.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    @Size(min = 4, message = "USERNAME_INVALID")
    String username;
    String email;
    @Size(min = 6, message = "PASSWORD_INVALID")
    String password;
    LocalDate dob;
}
