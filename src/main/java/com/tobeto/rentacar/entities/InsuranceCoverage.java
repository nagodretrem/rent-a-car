package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "insurance_coverages")
@Entity
public class InsuranceCoverage
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "insuranceCoverage")
    private List<Insurance> insurances;
}
