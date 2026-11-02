package com.contractor.cms.dto;

import jakarta.validation.constraints.*;

public class EmployeeRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message="Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Department is required")
    private String department;

    @NotNull(message ="Salary is required")
    @Positive(message = "Salary must be greater than zero")
    private double salary;

    @NotBlank(message = "Employee type is required")
    @Pattern(
            regexp = "(?i)PERMANENT|CONTRACTOR",
            message = "Employee type must be PERMANENT or CONTRACTOR"
    )
    private String employeeType;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail(){return email;}
    public void setEmail(String email){ this.email =email;}
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
}
