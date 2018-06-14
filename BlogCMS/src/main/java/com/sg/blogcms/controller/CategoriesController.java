/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.Category;
import com.sg.blogcms.model.StaticPages;
import com.sg.blogcms.model.postsTags;
import com.sg.blogcms.service.CategoriesService;
import com.sg.blogcms.service.StaticPagesService;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dannylantigua
 */
@Controller
public class CategoriesController {

    CategoriesService service;
    Category cat;
    StaticPagesService servicePage;

    public CategoriesController(CategoriesService service, StaticPagesService servicePage) {
        this.service = service;
        this.servicePage = this.servicePage;
    }

    @RequestMapping(value = "/addNewCategory", method = RequestMethod.POST)
    public String addNewcategory(HttpServletRequest request) {
        // create a new object
        Category cat2 = new Category();
        cat2.setCategoryDesc(request.getParameter("categoryName"));
        // send it to the service to save
        service.addNewCategory(cat2);
        return "redirect:dashboard";
    }

    @RequestMapping(value = "/displayEditCategory", method = RequestMethod.GET)
    public String displayEditCategory(HttpServletRequest request, Model model) {
        String catIdParameter = request.getParameter("catId");
        int catId = parseInt(catIdParameter);
        Category category = service.getCategoryById(catId);
        model.addAttribute("category", category);
        
//        // get a list from the service with all pages
//        List<StaticPages> pages = servicePage.getAllStaticPages();
//        // add it to the model
//        model.addAttribute("pagesList", pages);

        return "editCategoryForm";
    }

    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("category") Category caty) {
        // send the object to the service layer
        service.updateCategory(caty);
        return "redirect:dashboard";
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
    public String deleteCategory(HttpServletRequest request) {
        // get variables
        String catId = request.getParameter("catId");
        // send them to the service to delete
        service.removeCategory(parseInt(catId));
        return "redirect:dashboard";
    }
}
