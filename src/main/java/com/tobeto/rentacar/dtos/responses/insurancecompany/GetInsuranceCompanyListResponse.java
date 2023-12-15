package com.tobeto.rentacar.dtos.responses.insurancecompany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInsuranceCompanyListResponse {
    private int id;
    private String name;
}
