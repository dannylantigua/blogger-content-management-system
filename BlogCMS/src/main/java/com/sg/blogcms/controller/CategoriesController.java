/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.Categories;
import com.sg.blogcms.model.postsTags;
import com.sg.blogcms.serviceImpl.CategoriesServiceImpl;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dannylantigua
 */
@Controller
public class CategoriesController {
    
    CategoriesServiceImpl service;

    public CategoriesController(CategoriesServiceImpl service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/getAllCategories", method = RequestMethod.GET)
    public String getAllCategories(Model model) {
        // Getting the list from the service
        List<Categories> categories = service.getAllCategories();
        // add it to the model
        model.addAttribute("tagsList", categories);
        // return to the page
        return "";
    }
    
    @RequestMapping(value = "/addNewCategory", method = RequestMethod.POST)
    public String addNewcategory(HttpServletRequest request) {
        // create the object
        Categories cat = new Categories();
        cat.setCategoryName(request.getParameter("categoryName"));
        // send it to the service to save
        service.addNewCategory(cat);
        
        return "";
    }
    
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
    public String deleteCategory(HttpServletRequest request) {
        // get variables
        String catId = request.getParameter("catId");
        // send them to the service to delete
        service.removeCategory(parseInt(catId));
        
        return "";
    }
    
    
}
