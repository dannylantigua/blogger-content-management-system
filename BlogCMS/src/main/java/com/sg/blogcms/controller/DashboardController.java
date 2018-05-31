/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.Entity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kmlnd
 */
@Controller
public class DashboardController {
    @RequestMapping(value="/dashboard", method=RequestMethod.GET)
    public String dashboard(HttpServletRequest request){
        
        
        
        return "dashboard";
    }
    
    @RequestMapping(value="/createUser", method=RequestMethod.POST)
    public String createNewEntity(HttpServletRequest request){
        Entity currentEntity = new Entity();
        currentEntity.setEmail(request.getParameter("email"));
        currentEntity.setFirstName(request.getParameter("username"));
        currentEntity.setLastName(request.getParameter(""));
        currentEntity.setIsAdmin(false);
        currentEntity.setPassword(request.getParameter("password"));
        currentEntity.setPhoneNumber(request.getParameter("phone"));
        currentEntity.setUserName(request.getParameter("username"));
        
        return "dashboard";
    }
    

  
}
