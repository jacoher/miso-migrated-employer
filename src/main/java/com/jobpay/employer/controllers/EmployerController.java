package com.jobpay.employer.controllers;

import com.jobpay.employer.payload.request.EmployerRequest;
import com.jobpay.employer.payload.response.MessageResponse;
import com.jobpay.employer.services.EmployerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody EmployerRequest employerRequest) {
        try{
            var response = employerService.save(employerRequest);
            return ResponseEntity.ok(new MessageResponse("Employer registered successfully!"));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployers() {
        return ResponseEntity.ok(employerService.getAllEmployer());
    }

    @GetMapping("/search/{identification}")
    public ResponseEntity<?> getFindByIdentification(@Valid @PathVariable(name = "identification") Integer identification) {
        return ResponseEntity.ok(employerService.getFindByIdentification(identification));
    }
}
