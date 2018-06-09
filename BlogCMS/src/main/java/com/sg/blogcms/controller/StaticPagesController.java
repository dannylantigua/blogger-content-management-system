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
    
    @RequestMapping(value = "/createNewStaticPage", method = RequestMethod.POST)
    public String createNewStaticPage(HttpServletRequest request) {
        return "createStaticPage";
    }
    
    @RequestMapping(value = "/SaveNewPage", method = RequestMethod.POST)
    public String saveNewPage(HttpServletRequest request) {
        // create the object
        StaticPages page = new StaticPages();
        page.setPageName(request.getParameter("pageName"));
        page.setContent(request.getParameter("pageContent"));
        
        // send it to the service
        service.addNewStaticPage(page);
        // go back to dashboard
        return "dashboard";
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
        return "dashboard";
    }
    

}
