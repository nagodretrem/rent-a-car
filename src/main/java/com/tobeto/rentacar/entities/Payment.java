package com.tobeto.rentacar.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Table(name = "payments")
@Entity
public class Payment
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "date")
    private Date date;


    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

}
