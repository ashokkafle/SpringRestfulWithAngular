/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springrest.repositoryImpl;

import com.springrest.domain.Employee;
import com.springrest.repository.EmployeeRepository;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author ashok
 */
@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {
    
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);    
    
//    @Autowired
//    private SessionFactory sessionFactory;
    
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public Session getSession() throws HibernateException {
        Session sess = this.sessionFactory.getCurrentSession();
        if (sess == null) {
            sess = this.sessionFactory.openSession();
        }
        return sess;
    }
    
    @Override
    public Employee getDummyEmployee() {
        Employee emp = new Employee();
        
        emp.setFirstName("John");
        emp.setLastName("Doe");
        emp.setEmail("john.doe@gmail.com");
        emp.setTelephone("632-231-6634");
        emp.setAddress("1000 N 4TH ST, Fairfield, Iowa");        
        emp.setCreatedDate(new Date());
        return this.create(emp);
    }

    @Override
    public Employee getByID(int id) {
        Session session = getSession();        
        Employee e = (Employee) session.load(Employee.class, new Integer(id));        
        logger.info("Employee loaded successfully, Employee details = " + e);
        return e;
    }

    @Override
    public List<Employee> getAll() {
        Session session = getSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        for(Employee e : employeeList){
            logger.info("Employee List:: " + e);
        }
        return employeeList;
    }

    @Override
    public Employee update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee delete(int id) {
        Session session = getSession();
        Employee e = (Employee) session.load(Employee.class, new Integer(id));
        if(null != e){
            session.delete(e);
        }
        logger.info("Employee deleted successfully, Employee details = " + e);
        
        return e;
    }

    @Override
    public Employee create(Employee e) { 
        e.setCreatedDate(new Date());
        Session session = getSession();
        session.persist(e);        
        logger.info("Employee saved successfully, Employee Details = " + e);
        
        return e;
    }
}
