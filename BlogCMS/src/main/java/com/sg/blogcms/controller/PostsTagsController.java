/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.postsTags;
import com.sg.blogcms.service.StaticPagesService;
import com.sg.blogcms.serviceImpl.TagsServiceImpl;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dannylantigua
 */
@Controller
public class PostsTagsController {
    
    TagsServiceImpl service;
    List<postsTags> postTagsForSaving;
    StaticPagesService servicePage;

    public PostsTagsController(TagsServiceImpl service, StaticPagesService servicePage) {
        this.service = service;
        this.servicePage = servicePage;
    }
    
    @RequestMapping(value = "/getAllTagsByPost", method = RequestMethod.GET)
    public String getTagsByPosts(HttpServletRequest request, Model model) {
        // retrieve the variable
        String postIdParam = request.getParameter("postId");
        // Getting the list from the service
        List<postsTags> tags = service.getAllTagsByPosts(parseInt(postIdParam));
        // add it to the model
        model.addAttribute("tagsList", tags);
        // return to the page
        return "";
    }
    
    @RequestMapping(value = "/addTagsToList", method = RequestMethod.GET)
    public String addTagsToList(HttpServletRequest request) {
        // create the object
        postsTags tag = new postsTags();
        tag.setPostId(parseInt(request.getParameter("postId")));
        tag.setTag(request.getParameter("tag"));
        // add the tag to the list
        postTagsForSaving.add(tag);
        
        return "";
    }
    
    @RequestMapping(value = "/savePostTags", method = RequestMethod.POST)
    public String saveTags(HttpServletRequest request) {
        // send the list to the service
        service.savePostTags(postTagsForSaving);
        
        return "";
    }
    
    @RequestMapping(value = "/deleteTag", method = RequestMethod.GET)
    public String deleteTag(HttpServletRequest request) {
        // get variables
        String postId = request.getParameter("postId");
        String tagName = request.getParameter("tagName");
        // create the object
        postsTags tag = new postsTags(parseInt(postId), tagName);
        // send them to the service to delete
        service.removeTag(tag);
        
        return "";
    }
    
    
}
