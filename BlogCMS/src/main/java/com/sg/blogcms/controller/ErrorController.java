/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kmlnd
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/error")
    public String customError(HttpServletRequest request,
            HttpServletResponse response,
            Model model) {
        return "customError";
    }
}
