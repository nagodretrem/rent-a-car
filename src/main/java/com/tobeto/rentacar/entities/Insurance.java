package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "insurances")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "coverage")
    private String coverage;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "status")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private InsuranceCompany insuranceCompany;

    @OneToMany(mappedBy = "insurance")
    @JsonIgnore
    private List<Rental> rentals;
}
