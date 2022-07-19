package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z\\s]{2,}$" , message = "Employee Name is Incorrect")
    public String name;
    @NotEmpty(message = "Gender Cannot be empty")
    public String gender;
    @NotEmpty(message = "Department Cannot be empty")
    public String department;
    @Min(value = 500,message = "Salary Should be minimum 500")
    public long salary;
}