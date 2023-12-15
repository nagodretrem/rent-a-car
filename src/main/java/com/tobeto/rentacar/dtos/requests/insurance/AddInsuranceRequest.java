package com.tobeto.rentacar.dtos.requests.insurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInsuranceRequest {

    private String coverage;
    private double dailyPrice;
    private int companyId;
}
