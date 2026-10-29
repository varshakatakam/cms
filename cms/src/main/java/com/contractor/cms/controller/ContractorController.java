package com.contractor.cms.controller;

import com.contractor.cms.dto.EmployeeRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.contractor.cms.dto.EmployeeDTO;
import com.contractor.cms.service.ContractorService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/contractors")
public class ContractorController {

    private final ContractorService contractorService;
    public ContractorController(ContractorService contractorService){

        this.contractorService=contractorService;
    }
    @GetMapping
    public EmployeeDTO[]getAllEmployee(){
        return contractorService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public EmployeeDTO
        getEmployeeById(@PathVariable Long id){
        return contractorService.getEmployeeById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO createEmployee(
            @Valid @RequestBody EmployeeRequestDTO request){
        return contractorService.createEmployeeFromRequest(request);
    }
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id,@RequestBody EmployeeDTO employeeDTO){
        contractorService.updateEmployee(id,employeeDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id){
        contractorService.deleteEmployee(id);
    }
}
