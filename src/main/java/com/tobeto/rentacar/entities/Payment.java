package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "payments")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

}
