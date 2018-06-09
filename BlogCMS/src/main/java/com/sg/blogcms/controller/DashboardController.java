/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.dao.EntityDao;
import com.sg.blogcms.model.Entity;
import com.sg.blogcms.service.EntityService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kmlnd
 */
@Controller
public class DashboardController {

    EntityService ServiceDao;

    @Inject
    public DashboardController(EntityService ServiceDao) {
        this.ServiceDao = ServiceDao;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(HttpServletRequest request, Model model) {

        String username = request.getRemoteUser();
        
        if (username != null) {

            Entity currentEntity = ServiceDao.getEntityByUserName(username);

            model.addAttribute("username", username);
            
            model.addAttribute("firstname", currentEntity.getFirstName());

            model.addAttribute("lastname", currentEntity.getLastName());

            model.addAttribute("email", currentEntity.getEmail());

            model.addAttribute("aboutme", currentEntity.getAboutMe());
            
        }

        return "dashboard";
    }

    @RequestMapping(value = "/createPost", method = RequestMethod.GET)
    public String createPost(HttpServletRequest request, Model model) {
        if (request.getRemoteUser() != null) {
            String username = request.getRemoteUser();
            Entity currentEntity = ServiceDao.getEntityByUserName(username);
            model.addAttribute("firstname", currentEntity.getFirstName());
            model.addAttribute("lastname", currentEntity.getLastName());
            model.addAttribute("email", currentEntity.getEmail());
        }
        return "createPost";
    }

}
