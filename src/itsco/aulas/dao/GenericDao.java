/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itsco.aulas.dao;

import java.util.ArrayList;

/**
 *
 * @author Samuel Gomez
 */
public interface GenericDao<T, K> {
    
    void insert(T elemento);
    void update(T elemento);
    void delete(T elemento);
    T select(K idElemento);
    ArrayList<T> selectAll();
}
