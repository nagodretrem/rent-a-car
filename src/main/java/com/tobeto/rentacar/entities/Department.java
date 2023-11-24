package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "departments")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;
}
