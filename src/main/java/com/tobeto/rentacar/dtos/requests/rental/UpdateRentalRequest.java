package com.tobeto.rentacar.dtos.requests.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
    private int carId;
    private int customerId;
    private int employeeId;
    private int insuranceId;
    private int startKilometer;
    private double totalPrice;
    private double discount;
    private LocalDate startDate;
    private LocalDate endDate;
}
