package com.tobeto.rentacar.dtos.responses.insurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInsuranceListResponse {

    private int id;

    private String companyName;
    private String coverage;
    private double dailyPrice;
    private boolean isActive;

}
