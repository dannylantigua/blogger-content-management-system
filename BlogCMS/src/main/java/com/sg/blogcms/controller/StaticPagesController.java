/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.StaticPages;
import com.sg.blogcms.service.StaticPagesService;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dannylantigua
 */
@Controller
public class StaticPagesController {

    StaticPagesService service;

    public StaticPagesController(StaticPagesService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/saveNewPage", method = RequestMethod.POST)
    public String saveNewPage(HttpServletRequest request) {
        // create the object
        StaticPages page = new StaticPages();
        page.setPageName(request.getParameter("pageName"));
        page.setPageTitle(request.getParameter("pageTitle"));
        page.setContent(request.getParameter("content"));
        
        String path = request.getParameter("path");
        System.out.println(path);
        
        // send it to the service
        service.addNewStaticPage(page, path);
        // go back to dashboard
        return "redirect:dashboard";
    }
    
   @RequestMapping(value = "/displayEditPage", method = RequestMethod.GET)
    public String displayEditPage(HttpServletRequest request, Model model) {
        String pageIdParameter = request.getParameter("pageId");
        int pageId = parseInt(pageIdParameter);
        StaticPages page = service.getStaticPageById(pageId);
        model.addAttribute("staticpage", page);
        return "editStaticPageForm";
    }
    
    @RequestMapping(value = "/updateStaticPage", method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("staticpage") StaticPages page) {
        // send the object to the service layer
        service.updateStaticPage(page);
        return "redirect:dashboard";
    }
    
    @RequestMapping(value = "/deletePage", method = RequestMethod.GET)
    public String deletePage(HttpServletRequest request) {
        // get variable
        String pageId = request.getParameter("pageId");
        // send it to the service to delete
        service.removeStaticPage(parseInt(pageId));
        return "redirect:dashboard";
    }
    

}
