package com.bridgelabz.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
    String name;
    String department;
    String gender;
    String salary;
    int id;

    public String getName() {
        return name;
    }
    @Id
    @GeneratedValue

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Employee(String name, String department, String gender, String salary, int id) {
        this.name = name;
        this.department = department;
        this.gender = gender;
        this.salary = salary;
        this.id = id;
    }
    public Employee(){
    }
}
