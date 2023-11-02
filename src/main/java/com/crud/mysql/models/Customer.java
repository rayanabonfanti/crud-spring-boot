package com.crud.mysql.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_full_name", nullable = false)
    private String customerFullName;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "customer_username", nullable = false)
    private String customerUserName;

    @Column(name = "customer_password", nullable = false)
    private String customerPassword;
}
