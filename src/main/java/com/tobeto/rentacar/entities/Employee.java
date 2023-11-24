package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "employees")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "tc_no")
    private String tcNo;

    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Reservation> reservations;

}
