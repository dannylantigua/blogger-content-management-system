/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.dao.EntityDao;
import com.sg.blogcms.model.Authorities;
import com.sg.blogcms.model.Entity;
import com.sg.blogcms.service.EntityService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.springframework.http.RequestEntity.method;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kmlnd
 */
@Controller
public class AccountController {

    EntityService EntityServiceDao;
    private PasswordEncoder encoder;

    @Inject
    public AccountController(EntityService EntityServiceDao, PasswordEncoder encoder) {
        this.EntityServiceDao = EntityServiceDao;
        this.encoder = encoder;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {

        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest request) {
        return "dashboard";

    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp() {
        return "signUp";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createNewEntity(HttpServletRequest request, Model model) {
        Entity currentEntity = new Entity();
        currentEntity.setEmail(request.getParameter("email"));
        currentEntity.setFirstName(request.getParameter("firstname"));
        currentEntity.setLastName(request.getParameter("lastname"));
        currentEntity.setIsAdmin(false);
        String clearPassword = request.getParameter("password");
        String hashedPassword = encoder.encode(clearPassword);
        currentEntity.setPassword(hashedPassword);
        currentEntity.setPhoneNumber(request.getParameter("phone"));
        currentEntity.setUserName(request.getParameter("username"));
        currentEntity.addAuthority("ROLE_USER");

        EntityServiceDao.addEntity(currentEntity);
        return "redirect:adminSettings";

    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String editProfile(Model model, HttpServletRequest request) {
        String userName = request.getRemoteUser();
        Entity currentEntity = EntityServiceDao.getEntityByUserName(userName);
        
        model.addAttribute("user", currentEntity);

        return "editProfile";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request) {
        String userName = request.getRemoteUser();
        Entity entity = EntityServiceDao.getEntityByUserName(userName);
        EntityServiceDao.removeEntityById(entity.getRecordId());
        return "redirect:login";
    }

    @RequestMapping(value = "/adminSettings", method = RequestMethod.GET)
    public String adminSettings(Model model, HttpServletRequest request) {

        List<Entity> listOfEntities = EntityServiceDao.getAllEntities();
        List<Entity> admins = new ArrayList<>();
        for (Entity e : listOfEntities) {
            List<String> au = e.getAuthorities();
            if (au.contains("ROLE_ADMIN")) {
                admins.add(e);
            }
        }
        model.addAttribute("listOfEntities", admins);

        List<Entity> users = new ArrayList<>();
        for (Entity e : listOfEntities) {
            List<String> au = e.getAuthorities();
            if (!au.contains("ROLE_ADMIN")) {
                users.add(e);
            }

        }

        model.addAttribute("users", users);

        return "adminSettings";
    }

    @RequestMapping(value = "/deleteUserAsAdmin", method = RequestMethod.GET)
    public String makeAdmin(Model model, HttpServletRequest request) {
        String currentUserName = request.getRemoteUser();
        Entity currentUser = EntityServiceDao.getEntityByUserName(currentUserName);
        String id = request.getParameter("userId");

        if (currentUser.getRecordId() != Integer.parseInt(id)) {
            EntityServiceDao.removeEntityById(Integer.parseInt(id));
        }

        return "redirect:adminSettings";
    }

    @RequestMapping(value = "/promoteUserRole", method = RequestMethod.GET)
    public String promoteUserRole(HttpServletRequest request, Model model) {

        String userId = request.getParameter("userId");
        Entity currentE = EntityServiceDao.getEntityById(Integer.parseInt(userId));
        //currentE.addAuthority("ROLE_USER");
        currentE.addAuthority("ROLE_ADMIN");
        EntityServiceDao.updateEntity(currentE);

        model.addAttribute("notice", currentE);
        return "redirect:adminSettings";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(HttpServletRequest request, Model model) {
        String currentUser = request.getRemoteUser();
        Entity currentEntity = EntityServiceDao.getEntityByUserName(currentUser);
        
    
        currentEntity.setEmail(request.getParameter("email"));
        currentEntity.setFirstName(request.getParameter("firstname"));
        currentEntity.setLastName(request.getParameter("lastname"));
        String clearPassword = request.getParameter("password");
        String hashedPassword = encoder.encode(clearPassword);
        currentEntity.setPassword(hashedPassword);
        currentEntity.setPhoneNumber(request.getParameter("phone"));
        currentEntity.setUserName(request.getParameter("username"));
        
    
        EntityServiceDao.updateEntity(currentEntity);

        return "redirect:login";
      
    }

    @RequestMapping(value = "/removeAdminRole", method = RequestMethod.GET)
    public String removeAdminRole(HttpServletRequest request) {
        String id = request.getParameter("userId");
        Entity currentEntity = EntityServiceDao.getEntityById(Integer.parseInt(id));
        currentEntity.clearAuthorities();
        currentEntity.addAuthority("ROLE_USER");
        
        EntityServiceDao.updateEntity(currentEntity);
        return "redirect:adminSettings";
    }

}
