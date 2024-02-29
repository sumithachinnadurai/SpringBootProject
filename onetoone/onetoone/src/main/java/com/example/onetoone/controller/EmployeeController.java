package com.example.onetoone.controller;



import com.example.onetoone.model.Employee;

import com.example.onetoone.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;

    @PostMapping("/insertdata")
    public Employee insert(@RequestBody Employee e) {
        return employeeservice.createemployee(e);
    }

    @GetMapping("/getdata")
    public List<Employee> get() {
        return employeeservice.getemployee();
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable int empid) {
        return employeeservice.findemployee(empid);
    }

    @PutMapping("/updatedata/{id}")
    public Employee update(@PathVariable int empid, @RequestBody Employee e) {
        return employeeservice.updateemployee(empid, e);
    }

    @DeleteMapping("/deletedata{id}")
    public void delete(@PathVariable int empid) {
        employeeservice.deleteemployee(empid);
    }

}