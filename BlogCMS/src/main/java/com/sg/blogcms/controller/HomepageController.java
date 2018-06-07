/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.service.PostsService;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kmlnd
 */
@Controller
public class HomepageController {

    PostsService postsService;

    @Inject
    public HomepageController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String homepage(Model model) {

        model.addAttribute("latestPosts", postsService.getLatestPosts());
        
        return "homepage";
    }
}
