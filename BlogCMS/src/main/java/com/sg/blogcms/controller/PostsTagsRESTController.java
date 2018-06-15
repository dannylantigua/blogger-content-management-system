/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.model.postsTags;
import com.sg.blogcms.service.StaticPagesService;
import com.sg.blogcms.serviceImpl.TagsServiceImpl;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import static org.springframework.http.RequestEntity.method;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author kmlnd
 */
@CrossOrigin
@Controller
public class PostsTagsRESTController {

    TagsServiceImpl service;
    List<postsTags> postTagsForSaving;
    StaticPagesService servicePage;

    @Inject
    public PostsTagsRESTController(TagsServiceImpl service, StaticPagesService servicePage) {
        this.service = service;
        this.servicePage = servicePage;
    }
    
    @RequestMapping(value="/tags/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public List<postsTags> getAllTagsByPostsId(@PathVariable("id")int id) {
        return service.getAllTagsByPosts(id);
    }
    
    @RequestMapping(value="/tags" , method = RequestMethod.GET)
    @ResponseBody
    public List<postsTags> getLast10Tags() {
        return service.getLast10Tags();
    }
    
    @RequestMapping(value="/tags" , method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void savePostTags(@RequestBody List<postsTags> postTags) {
        service.savePostTags(postTags);
    }
    
    @RequestMapping(value="/tags/{postsTags}" , method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeTag(@PathVariable("postsTags") postsTags currentPostsTags){
        service.removeTag(currentPostsTags);
    }
    

}
