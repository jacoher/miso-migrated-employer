package com.jobpay.employer.services;

import com.jobpay.employer.models.Employer;
import com.jobpay.employer.payload.request.EmployerRequest;
import com.jobpay.employer.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Employer save(EmployerRequest employerRequest){
        if (employerRepository.existsByIdentification(employerRequest.getIdentification())) {
            throw new RuntimeException("Error: Employer exist!");
        }

        // Create new employer
        Employer employer = Employer.builder()
                .name(employerRequest.getName())
                .lastName(employerRequest.getLastName())
                .identification(employerRequest.getIdentification())
                .telephone(employerRequest.getTelephone())
                .description(employerRequest.getDescription())
                .build();
        return employerRepository.save(employer);
    }

    public List<Employer> getAllEmployer(){
        return employerRepository.findAll();
    }

    public Optional<Employer> getFindByIdentification(Integer identification){
        return employerRepository.findByIdentification(identification);
    }
}
