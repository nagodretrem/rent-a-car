package com.tobeto.rentacar.dtos.responses.color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetColorListResponse {

    private int id;
    private String name;
}
