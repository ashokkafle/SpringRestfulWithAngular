/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springrest.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ashok
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
    "classpath:/servlet-test-context.xml"
})
public abstract class BaseTest {
    
}
