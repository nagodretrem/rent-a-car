package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "insurance_coverages")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceCoverage
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "insuranceCoverage")
    @JsonIgnore
    private List<Insurance> insurances;
}
