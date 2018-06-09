/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.Category;
import com.sg.blogcms.model.postsTags;
import com.sg.blogcms.service.CategoriesService;
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
    
    CategoriesService service;

    public CategoriesController(CategoriesService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/addNewCategory", method = RequestMethod.POST)
    public String addNewcategory(HttpServletRequest request) {
        // create the object
        Category cat = new Category();
        cat.setCategoryDesc(request.getParameter("categoryDesc"));
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
        
        return "dashboard";
    }
    
    
}
