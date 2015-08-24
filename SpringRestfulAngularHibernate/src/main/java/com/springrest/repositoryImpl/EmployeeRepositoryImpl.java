/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springrest.repositoryImpl;

import com.springrest.domain.Employee;
import com.springrest.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


/**
 *
 * @author ashok
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    
    private Map<Integer, Employee> empDatabase;
    
    @Override
    public Employee getDummyEmployee() {
        Employee emp = new Employee();
        emp.setId(9999);
        emp.setFirstName("John");
        emp.setLastName("Doe");
        emp.setEmail("john.doe@gmail.com");
        emp.setTelephone("632-231-6634");
        emp.setAddress("1000 N 4TH ST, Fairfield, Iowa");        
        emp.setCreatedDate(new Date());
        empDatabase.put(9999, emp);
        return emp;
    }
    
    public EmployeeRepositoryImpl() {
        this.empDatabase = new HashMap<>();
    }

    @Override
    public Employee getByID(int id) {
        return empDatabase.get(id);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> temp = new ArrayList<>(empDatabase.values());
        return temp;
    }

    @Override
    public Employee update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee delete(int id) {
        return empDatabase.remove(id);
    }

    @Override
    public Employee create(Employee t) {
        t.setCreatedDate(new Date());
        t.setId(empDatabase.size()+1);
        return empDatabase.put(t.getId(), t);
    }    

}
