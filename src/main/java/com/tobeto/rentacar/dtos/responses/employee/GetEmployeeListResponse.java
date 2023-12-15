package com.tobeto.rentacar.dtos.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeListResponse {

    private int id;
    private String name;
    private String title;
    private boolean isActive;

}
