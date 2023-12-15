package com.tobeto.rentacar.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListResponse {

    private int id;
    private String firstname;
    private String lastname;
    private String email;

}
