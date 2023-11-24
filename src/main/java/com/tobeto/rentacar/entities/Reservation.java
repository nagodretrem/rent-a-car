package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "reservations")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "price")
    private double price;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

}
