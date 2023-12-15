package com.tobeto.rentacar.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    private String plateNumber;
    private int kilometer;
    private double dailyPrice;
    private int modelId;
    private int colorId;
    private boolean isActive;


}
