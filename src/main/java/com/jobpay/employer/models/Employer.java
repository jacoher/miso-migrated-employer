package com.jobpay.employer.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private Integer identification;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String lastName;
    @Column(length = 20)
    private String telephone;
    @Column(length = 200)
    private String description;
}
