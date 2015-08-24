/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springrest.service;

import java.util.List;

/**
 *
 * @author ashok
 */
public interface AbstractService<T> {
    
    public abstract T getByID(int id);
    
    public abstract List<T> getAll();
    
    public abstract T update(int id);
    
    public abstract T delete(int id);
    
    public abstract T create(T t);
}
