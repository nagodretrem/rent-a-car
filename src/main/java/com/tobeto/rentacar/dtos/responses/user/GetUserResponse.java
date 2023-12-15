package com.tobeto.rentacar.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {

    private String firstName;
    private String lastName;
    private String email;

}
