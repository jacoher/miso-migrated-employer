package com.jobpay.employer.payload.request;

import lombok.Data;

@Data
public class EmployerRequest {
    private String name;
    private String lastName;
    private Integer identification;
    private String telephone;
    private String description;
}
