/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.Category;
import com.sg.blogcms.model.Posts;
import com.sg.blogcms.model.StaticPages;
import com.sg.blogcms.service.CategoriesService;
import com.sg.blogcms.service.PostsService;
import com.sg.blogcms.service.StaticPagesService;
import java.util.ArrayList;
import java.util.List;
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
    CategoriesService serviceCat;
    StaticPagesService servicePage;

    @Inject
    public HomepageController(PostsService postsService, CategoriesService serviceCat, StaticPagesService servicePage) {
        this.postsService = postsService;
        this.serviceCat = serviceCat;
        this.servicePage = servicePage;
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String homepage(Model model) {

        List<Posts> posts = postsService.getLatestPosts();
        List<Category> categories = serviceCat.getAllCategories();
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categories);

        // get a list from the service with all pages
        List<StaticPages> pages = servicePage.getAllStaticPages();
        // add it to the model
        model.addAttribute("pagesList", pages);

        if (!posts.isEmpty()) {
            model.addAttribute("latestPost", posts.get(0));
            Posts latestPost = posts.get(0);
            int id = latestPost.getCategoryId();
            Category c = serviceCat.getCategoryById(id);
            model.addAttribute("mainCategory", c);
        }

        return "homepage";
    }
}
