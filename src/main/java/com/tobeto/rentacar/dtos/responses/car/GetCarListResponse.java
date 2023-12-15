package com.tobeto.rentacar.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {

    private int id;
    private String plateNumber;
    private int kilometer;
    private double dailyPrice;
    private Boolean isActive;





}
