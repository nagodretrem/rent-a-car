package com.tobeto.rentacar.dtos.requests.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {


    private int userId;
    private String title;
    private double salary;

}
