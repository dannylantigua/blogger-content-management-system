/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.dao.EntityDao;
import com.sg.blogcms.model.Entity;
import com.sg.blogcms.service.EntityService;
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

    EntityService ServiceDao;
    private PasswordEncoder encoder;

    @Inject
    public AccountController(EntityService ServiceDao, PasswordEncoder encoder) {
        this.ServiceDao = ServiceDao;
        this.encoder = encoder;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {

        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(HttpServletRequest request) {

//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        if (ServiceDao.getEntityByEmail(email) != null && ServiceDao.getEntityByPassword(password) != null) {
//            return "dashboard";
//        } else {
        return "dashboard";
//        }
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

        ServiceDao.addEntity(currentEntity);
        return "redirect:login";

//        if (ServiceDao.getEntityByEmail(currentEntity.getEmail()) != null) {
//            return "redirect:signUp";
//        } else {
//            ServiceDao.addEntity(currentEntity);
//            return "dashboard";
//        }
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public String editProfile() {
        return "editProfile";
    }
    
    @RequestMapping(value="/deleteUser" , method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request){
        String userName = request.getRemoteUser();
        Entity entity = ServiceDao.getEntityByUserName(userName);
        ServiceDao.removeEntityById(entity.getRecordId());
        return "redirect:login";
    }
    
    @RequestMapping(value="/adminSettings", method=RequestMethod.GET)
    public String adminSettings(Model model){
        
        List<Entity> listOfEntities = ServiceDao.getAllEntities();
        model.addAttribute("listOfEntities", listOfEntities);
        
        return "adminSettings";
    }
    
    @RequestMapping(value="/deleteUserAsAdmin", method=RequestMethod.GET)
    public String makeAdmin(Model model,HttpServletRequest request){
        String currentUserName = request.getRemoteUser();
        Entity currentUser = ServiceDao.getEntityByUserName(currentUserName);
        String id = request.getParameter("userId");
        
        if(currentUser.getRecordId() != Integer.parseInt(id)){
            ServiceDao.removeEntityById(Integer.parseInt(id));
        }
        
        return "redirect:adminSettings";
    }
    

}
