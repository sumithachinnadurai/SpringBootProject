package com.example.onetoone.service;



import com.example.onetoone.model.Employee;
import com.example.onetoone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // post the data
    public Employee createemployee(Employee e) {
        return employeeRepository.save(e);
    }

    // get data
    public List<Employee> getemployee() {
        return employeeRepository.findAll();
    }

    // update data
    public Employee updateemployee(int empid, Employee e) {
        Employee s1 = employeeRepository.findById(empid).orElse(null);
        if (s1 != null) {
            s1.setEmpName(e.getEmpName());
            s1.setEmpAge(e.getEmpAge());
            employeeRepository.save(s1);
            return s1;
        } else {
            return e;
        }
    }

    // getdata
    public Employee findemployee(int empid) {
        return employeeRepository.findById(empid).orElse(null);
    }

    // delete the data
    public void deleteemployee(int empid) {
        employeeRepository.deleteById(empid);
    }
}