package com.tobeto.rentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "payment_methods")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "method")
    private String method;


    @OneToMany(mappedBy = "paymentMethod")
    @JsonIgnore
    private List<Payment> payments;
}
