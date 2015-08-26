/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springrest.service;

import com.springrest.domain.Employee;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ashok
 */
public class EmployeeServiceTest extends BaseTest {
    
    @Autowired
    private EmployeeService employeeService;   
    
    private final String firstName = "Ashok";
    private final String lastName = "Kafle";
    private final String email = "ashok@gmail.com";
    private final String telephone = "641-451-0619";
    private final String address = "Irving, Texas";
    
    public EmployeeServiceTest() {
    }

    /**
     * Test of getDummyEmployee method, of class EmployeeService.
     */
    @Test
    public void testGetDummyEmployee() {
        System.out.println("Test case for getDummyEmployee"); 
        
        String expResult = "John";
        Employee result = employeeService.getDummyEmployee();
        
        assertNotNull(result);
        assertEquals(expResult, result.getFirstName());
    }
    
    /**
     * Test of getByID method, of class EmployeeService.
     */
    @Test
    public void testGetByID() {
        System.out.println("Test case for getByID"); 
        
        Employee expectedResult = employeeService.getDummyEmployee();        
        Employee result = employeeService.getByID(expectedResult.getId());
        
        assertNotNull(result);        
        assertEquals(expectedResult, result);
    }
    
    /**
     * Test of getAll method, of class EmployeeService.
     */
    @Test
    public void testGetAll() {
        System.out.println("Test case for getAll");                
       
        Employee expectedEmp = employeeService.getDummyEmployee();                            
        List<Employee> result = employeeService.getAll();
        
        assertNotNull(result);
        assertEquals(expectedEmp, result.get(result.size()-1));//checking with last persisted data        
    }
    
    /**
     * Test of delete method, of class EmployeeService.
     */
    @Test
    public void testDelete() {
        System.out.println("Test case for delete");
        
        Employee expectedResult = employeeService.getDummyEmployee();
        Employee result = employeeService.delete(expectedResult.getId());
        
        assertNotNull(result);
        assertEquals(expectedResult, result);
    }
    
    /**
     * Test of create method, of class EmployeeService.
     */
    @Test
    public void testCreate() {
        System.out.println("Test case for create");
        
        Employee expectedResult = new Employee();        
        
        expectedResult.setAddress(address);
        expectedResult.setEmail(email);
        expectedResult.setTelephone(telephone);
        expectedResult.setFirstName(firstName);
        expectedResult.setLastName(lastName);
        
        Employee result = employeeService.create(expectedResult);
        
        assertNotNull(result);
        assertEquals(expectedResult, result);
    }
}