package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

@Table(name = "cars")
@Entity
public class Car
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "brand")
    private  String brand;

    @Column(name = "year")
    private int year;

    @Column(name = "color")
    private String color;

    @Column(name = "km")
    private int km;

    @Column(name = "status")
    private boolean status;

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "price")
    private double price;

    @OneToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
