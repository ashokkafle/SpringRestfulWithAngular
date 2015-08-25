/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springrest.serviceImpl;

import com.springrest.domain.Employee;
import com.springrest.repository.EmployeeRepository;
import com.springrest.service.EmployeeService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ashok
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {    
    
//    @Autowired
//    private EmployeeRepository employeeRepository;
    private EmployeeRepository employeeRepository;
 
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public Employee getDummyEmployee() {
        return employeeRepository.getDummyEmployee();
    }
    
    @Override
    public Employee getByID(int id) {
        return employeeRepository.getByID(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    @Override
    public Employee update(int id) {
        return employeeRepository.update(id);
    }

    @Override
    public Employee delete(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public Employee create(Employee t) {
        return employeeRepository.create(t);
    }
}
