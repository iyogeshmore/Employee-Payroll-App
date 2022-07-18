package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class  EmpPayrollController {
    public static final String template = "Welcome To The Payroll App,%s";

@Autowired
    public EmployeeService service;
    @RequestMapping("/welcome")
    public String displayMessage(){
        return service.employeeMessage();
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity <ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        Employee empData = null;
        empData = new Employee(1, new EmployeeDTO("Yogesh", "Male", "HR", 45000));
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeeDTO empDTO) {
        Employee empData = null;
        empData = new Employee(1, empDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseDTO> editEmployeePayrollData(@RequestBody EmployeeDTO empDTO) {
        Employee empData = null;
        empData = new Employee(1, empDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respOTO= new ResponseDTO("Deleted Successfully", "Deleted id: "+empId);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

}
