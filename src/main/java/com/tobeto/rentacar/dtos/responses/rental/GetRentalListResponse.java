package com.tobeto.rentacar.dtos.responses.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalListResponse {

    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String carModel;
    private String customerName;
    private String employeeName;
    private double totalPrice;


}
