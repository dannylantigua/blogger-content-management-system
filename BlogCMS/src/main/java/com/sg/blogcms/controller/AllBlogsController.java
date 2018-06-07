/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.Posts;
import com.sg.blogcms.service.PostsService;
import java.util.List;
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
public class AllBlogsController {

    PostsService postsService;

    @Inject
    public AllBlogsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "/allBlogs", method = RequestMethod.GET)
    public String allBlogs(Model model) {

        List<Posts> posts = postsService.getAllPosts();
        model.addAttribute("posts", posts);

        return "allBlogs";
    }

    @RequestMapping(value = "/displayChosenBlogPost", method = RequestMethod.GET)
    public String displayChosenBlogPost(HttpServletRequest request, Model model) {
        String currentIdForPost = request.getParameter("currentPostId");
        if ("".equals(currentIdForPost) || "0".equals(currentIdForPost)) {
            return "redirect:homepage";
        } else {
            Posts currentPost = postsService.getPostsById(Integer.parseInt(currentIdForPost));

            model.addAttribute("currentPost", currentPost);
            return "displayChosenBlogPost";
        }
    }
    @RequestMapping(value="/deletePost", method=RequestMethod.GET)
    public String deletePost(HttpServletRequest request){
        String id = request.getParameter("currentPost");
        postsService.removePostsById(Integer.parseInt(id));
        
        
        
        return "dashboard";
    }
}
