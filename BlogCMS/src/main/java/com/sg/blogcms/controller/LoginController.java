/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.dao.EntityDao;
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
public class LoginController {

    EntityDao entityDao;

    @Inject
    public LoginController(EntityDao entityDao) {
        this.entityDao = entityDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest request) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(entityDao.getEntityByEmail(email) != null && entityDao.getEntityByPassword(password) != null){
            return "dashboard";
        } else {
            return "redirect:login";
        }
    }
}
