/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.StaticPages;
import com.sg.blogcms.serviceImpl.StaticPagesServiceImpl;
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
public class StaticPagesController {

    StaticPagesServiceImpl service;

    public StaticPagesController(StaticPagesServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/getAllStaticPages1", method = RequestMethod.GET)
    public String getAllStaticPages(Model model) {
        // get a list from the service with all pages
        List<StaticPages> pages = service.getAllStaticPages();
        // add it to the model
        model.addAttribute("pagesList", pages);
        // go back to the page
        return "";
    }
    
    @RequestMapping(value = "/addNewPage", method = RequestMethod.POST)
    public String addNewPage(HttpServletRequest request) {
        // create the object
        StaticPages page = new StaticPages();
        page.setPageName(request.getParameter("pageName"));
        page.setContent(request.getParameter("pageContent"));
        
        // send it to the service
        service.addNewStaticPage(page);
        
        return "";
    }
    
   @RequestMapping(value = "/getPageById", method = RequestMethod.GET)
    public String getPageById(HttpServletRequest request, Model model) {
        // get the variable
        String pageId = request.getParameter("pageId");
        StaticPages page = service.getStaticPageById(parseInt(pageId));
        model.addAttribute("staticPage", page);

        return "";
    }
    
    @RequestMapping(value = "/deletePage", method = RequestMethod.GET)
    public String deletePage(HttpServletRequest request) {
        // get variable
        String pageId = request.getParameter("pageId");
        // send it to the service to delete
        service.removeStaticPage(parseInt(pageId));
        return "";
    }
    

}
