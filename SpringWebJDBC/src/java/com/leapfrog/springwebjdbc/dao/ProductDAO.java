/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springwebjdbc.dao;

import com.leapfrog.springwebjdbc.entity.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zak
 */
public interface ProductDAO {

    List<Product> getAll() throws ClassNotFoundException, SQLException;

    int insert(Product product) throws ClassNotFoundException, SQLException;

    Product getById(int id) throws ClassNotFoundException, SQLException;

    int update(Product product) throws ClassNotFoundException, SQLException;

    int delete(int id) throws ClassNotFoundException, SQLException;
    
    List<Product> search(String param) throws ClassNotFoundException, SQLException;

}
