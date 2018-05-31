/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.dao.EntityDao;
import com.sg.blogcms.model.Entity;
import javax.inject.Inject;
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
    
    EntityDao entityDao;
    
    @Inject
    public DashboardController (EntityDao entityDao){
        this.entityDao = entityDao;
    }
    
    
    @RequestMapping(value="/dashboard", method=RequestMethod.GET)
    public String dashboard(HttpServletRequest request){
        
        
        
        return "dashboard";
    }
    

    

  
}
