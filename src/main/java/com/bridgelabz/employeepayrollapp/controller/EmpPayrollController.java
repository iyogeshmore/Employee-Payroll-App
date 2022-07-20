package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.iEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class  EmpPayrollController {
    @Autowired
    iEmployeeService service;
    List <Employee> empDatalist = new ArrayList<>();

    @RequestMapping(value = {"","/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        empDatalist = service.getEmployeeData();
        ResponseDTO respOTO = new ResponseDTO("Get Call Successful", empDatalist);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empID) {
        Employee empData = service.getEmployeePayrollDataById(empID);
        ResponseDTO respDTO= new ResponseDTO("Get Call For ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(
            @Valid @RequestBody EmployeeDTO empPayrollDTO) {
        Employee empData = service.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respOTO= new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empID}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empID") int empID, @RequestBody EmployeeDTO employeeDTO) {
        Employee empData = service.updateEmployeePayrollData(empID,employeeDTO);
        ResponseDTO respDTO= new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity <ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity <ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        service.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO= new ResponseDTO("Deleted Successfully", "Deleted id: "+empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}