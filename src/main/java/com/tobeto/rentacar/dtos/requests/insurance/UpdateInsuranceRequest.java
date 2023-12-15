package com.tobeto.rentacar.dtos.requests.insurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInsuranceRequest {
    private String coverage;
    private double dailyPrice;
    private int companyId;
    private boolean isActive;
}
