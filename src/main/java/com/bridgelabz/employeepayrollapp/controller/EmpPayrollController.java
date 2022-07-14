package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpPayrollController {
    public static final String template = "Welcome To The Payroll App,%s";

@Autowired
    public EmployeeService service;
    @RequestMapping("/welcome")
    public String displayMessage(){
        return service.employeeMessage();
    }

    //--------------- UC 2 ---------------//

        @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployees(employee);
    }
    @GetMapping("/employeeById/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return service.findEmployeeById(id);
    }
    @GetMapping("/allEmployees")
    public List<Employee> findAllEmployees() {
        return service.findEmployees();
    }
    @PutMapping("/editEmployee/{id}")
    public Employee editEmployee(@RequestBody Employee employee, @PathVariable Integer id){
        return service.editEmployee(employee, id);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        service.deleteEmployee(id);
        return "Data Deleted";
    }
}


