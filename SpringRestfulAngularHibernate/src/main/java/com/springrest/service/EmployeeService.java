/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springrest.service;

import com.springrest.domain.Employee;

/**
 *
 * @author ashok
 */
public interface EmployeeService extends AbstractService<Employee> {
    public Employee getDummyEmployee();
}
