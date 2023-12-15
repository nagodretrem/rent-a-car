package com.tobeto.rentacar.dtos.requests.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {

    private String title;
    private double salary;
    private int userId;
    private boolean isActive;
}
