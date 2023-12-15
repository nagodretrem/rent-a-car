package com.tobeto.rentacar.dtos.requests.insurancecompany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInsuranceCompanyRequest {
    private String name;
}
