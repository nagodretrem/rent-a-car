package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

@Table(name = "customers")
@Entity
public class Customer
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

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "licence_number")
    private String licenceNumber;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


}
