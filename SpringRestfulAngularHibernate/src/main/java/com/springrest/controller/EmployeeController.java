/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springrest.controller;

import com.springrest.domain.Employee;
import com.springrest.service.EmployeeService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ashok
 */
@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        logger.info("Home Page Loaded");
        return "index";
    }
    
    @RequestMapping(value = "/rest/emp/dummy", method = RequestMethod.GET)
    public @ResponseBody Employee getDummyEmployee() {
        logger.info("Start getDummyEmployee");
        return employeeService.getDummyEmployee();
    }
    
    @RequestMapping(value = "/rest/emp/{id}", method = RequestMethod.GET)
    public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
        logger.info("Start getEmployee. ID="+empId);        
        return employeeService.getByID(empId);        
    }
     
    @RequestMapping(value = "/rest/emps", method = RequestMethod.GET)
    public @ResponseBody List<Employee> getAllEmployees() {
        logger.info("Start getAllEmployees.");        
        return employeeService.getAll(); 
    }
     
    @RequestMapping(value = "/rest/emp/create", method = RequestMethod.POST)
    public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
        logger.info("Start createEmployee.");
        return employeeService.create(emp);        
    }
     
    @RequestMapping(value = "/rest/emp/delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
        logger.info("Start deleteEmployee.");
        return employeeService.delete(empId);         
    }   
    
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String getEmployees() {
        logger.info("Employee Data Loaded");
        return "employees";
    }
    
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders() {
        logger.info("All Orders are Loaded");
        return "orders";
    }
    
    @RequestMapping(value = "/ordersTable", method = RequestMethod.GET)
    public String getOrdersTable() {
        logger.info("Order Table Loaded");
        return "ordersTable";
    }    
    
    @RequestMapping(value = "/employeeOrders", method = RequestMethod.GET)
    public String getEmployeeOrders() {
        logger.info("Employee Order Data Loaded");
        return "employeeOrders";
    } 
}
