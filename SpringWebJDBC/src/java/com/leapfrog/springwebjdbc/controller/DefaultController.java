/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springwebjdbc.controller;

import com.leapfrog.springwebjdbc.dao.ProductDAO;
import com.leapfrog.springwebjdbc.dao.impl.ProductDAOImpl;
import com.leapfrog.springwebjdbc.entity.Product;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author zak
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            model.addAttribute("products", productDAO.getAll());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("product") Product product) {
        try {
            if (product.getId() == 0) {
                productDAO.insert(product);
            } else {
                productDAO.update(product);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        try {
            model.addAttribute("product", productDAO.getById(id));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/edit";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        try {
            productDAO.delete(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/";
    }
    
    @RequestMapping(value = "/?search={name}", method = RequestMethod.GET)
    public String search(Model model, @PathVariable("name") String name){
        try {
            model.addAttribute("products", productDAO.search(name));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "search";
    }
}
