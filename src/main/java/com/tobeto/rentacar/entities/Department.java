package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "departments")
@Entity
public class Department
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
