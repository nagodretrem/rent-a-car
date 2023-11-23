package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "payment_methods")
@Entity
public class PaymentMethod
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "method")
    private String method;


    @OneToMany(mappedBy = "paymentMethod")
    private List<Payment> payments;
}
