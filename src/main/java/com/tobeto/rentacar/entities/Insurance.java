package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Table(name = "insurances")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "coverage_id")
    private InsuranceCoverage insuranceCoverage;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

}
