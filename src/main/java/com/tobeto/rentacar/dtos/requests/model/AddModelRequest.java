package com.tobeto.rentacar.dtos.requests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    private String name;
    private int brandId;
}
