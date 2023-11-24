package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "cars")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "brand")
    private  String brand;

    @Column(name = "model")
    private  String model;

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

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Insurance> insurances;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Reservation> reservations;
}
