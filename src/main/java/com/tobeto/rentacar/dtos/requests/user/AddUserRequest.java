package com.tobeto.rentacar.dtos.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String nationalityNumber;
    private String address;
    private LocalDate birthDate;
}
