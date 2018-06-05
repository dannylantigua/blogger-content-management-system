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
public class AccountController {

    EntityService ServiceDao;

    @Inject
    public AccountController(EntityService ServiceDao) {
        this.ServiceDao = ServiceDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (ServiceDao.getEntityByEmail(email) != null && ServiceDao.getEntityByPassword(password) != null) {
            return "dashboard";
        } else {
            return "redirect:login";
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp() {
        return "signUp";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createNewEntity(HttpServletRequest request, Model model) {
//        Entity currentEntity = new Entity();
//        currentEntity.setEmail(request.getParameter("email"));
//        currentEntity.setFirstName(request.getParameter("firstname"));
//        currentEntity.setLastName(request.getParameter("lastname"));
//        currentEntity.setIsAdmin(false);
//        currentEntity.setPassword(request.getParameter("password"));
//        currentEntity.setPhoneNumber(request.getParameter("phone"));
//        currentEntity.setUserName(request.getParameter("username"));
//
//        ServiceDao.addEntity(currentEntity);
            return "dashboard";
        
//        if (ServiceDao.getEntityByEmail(currentEntity.getEmail()) != null) {
//            return "redirect:signUp";
//        } else {
//            ServiceDao.addEntity(currentEntity);
//            return "dashboard";
//        }
    }
}
