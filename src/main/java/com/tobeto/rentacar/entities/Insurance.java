package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.sql.Date;


@Table(name = "insurances")
@Entity
public class Insurance
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "insurance_company")
    private String insuranceCompany;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "price")
    private double price;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "coverage_id")
    private InsuranceCoverage insuranceCoverage;

}
