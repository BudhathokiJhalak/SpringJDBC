/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springwebjdbc.dao.impl;

import com.leapfrog.springwebjdbc.dao.ProductDAO;
import com.leapfrog.springwebjdbc.entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zak
 */
@Repository(value = "ProductDAO")
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setCostPrice(rs.getInt("cost_price"));
                product.setSellPrice(rs.getInt("selling_price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setStatus(rs.getBoolean("status"));
                return product;
            }
        });
    }

    @Override
    public int insert(Product product) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO products(product_name, description, cost_price, selling_price, quantity, status) VALUES(?,?,?,?,?,?)";;
        return jdbcTemplate.update(sql, new Object[]{product.getName(), product.getDescription(), product.getCostPrice(), product.getSellPrice(), product.getQuantity(), product.isStatus()});
    }

    @Override
    public Product getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM products WHERE product_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setCostPrice(rs.getInt("cost_price"));
                product.setSellPrice(rs.getInt("selling_price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setStatus(rs.getBoolean("status"));
                return product;
            }
        });
    }

    @Override
    public int update(Product product) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE products SET product_name=?, description=?, cost_price=?, selling_price=?, quantity=?, status=? WHERE product_id=?";
        return jdbcTemplate.update(sql, new Object[]{product.getName(), product.getDescription(), product.getCostPrice(), product.getSellPrice(), product.getQuantity(), product.isStatus(), product.getId()});
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM products WHERE product_id=?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public List<Product> search(String param) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM products WHERE product_name LIKE '%?%'";
        return jdbcTemplate.query(sql, new Object[]{param}, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setCostPrice(rs.getInt("cost_price"));
                product.setSellPrice(rs.getInt("selling_price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setStatus(rs.getBoolean("status"));
                return product;
            }
        });
    }
}
