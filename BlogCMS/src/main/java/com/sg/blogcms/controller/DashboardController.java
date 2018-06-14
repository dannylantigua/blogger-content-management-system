/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.controller;

import com.sg.blogcms.dao.EntityDao;
import com.sg.blogcms.model.Category;
import com.sg.blogcms.model.Entity;
import com.sg.blogcms.model.Posts;
import com.sg.blogcms.model.StaticPages;
import com.sg.blogcms.model.postsTags;
import com.sg.blogcms.service.CategoriesService;
import com.sg.blogcms.service.EntityService;
import com.sg.blogcms.service.PostsService;
import com.sg.blogcms.service.StaticPagesService;
import com.sg.blogcms.service.TagsService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
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
public class DashboardController {

    EntityService ServiceDao;
    CategoriesService serviceCat;
    StaticPagesService servicePage;
    TagsService serviceTag;
    PostsService servicePost;
    Category cat;

    @Inject
    public DashboardController(EntityService ServiceDao, CategoriesService serviceCat,
            StaticPagesService servicePage, TagsService serivceTag, PostsService servicePost) {
        this.ServiceDao = ServiceDao;
        this.serviceCat = serviceCat;
        this.servicePage = servicePage;
        this.serviceTag = serivceTag;
        this.servicePost = servicePost;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(HttpServletRequest request, Model model) {

        String username = request.getRemoteUser();
        if (username != null) {
            Entity currentEntity = ServiceDao.getEntityByUserName(username);
            model.addAttribute("username", username);
            model.addAttribute("firstname", currentEntity.getFirstName());
            model.addAttribute("lastname", currentEntity.getLastName());
            model.addAttribute("email", currentEntity.getEmail());
            model.addAttribute("aboutme", currentEntity.getAboutMe());

            //For post count
            int count = servicePost.getPostCount(currentEntity.getRecordId());
            model.addAttribute("postCount", count);
        }

        // For Categories
        List<Category> categories = serviceCat.getAllCategories();
        // add it to the model
        model.addAttribute("catList", categories);
        // initialize the class
        cat = new Category();
        model.addAttribute("cat", cat);

        // get a list from the service with all pages
        List<StaticPages> pages = servicePage.getAllStaticPages();
        // add it to the model
        model.addAttribute("pagesList", pages);

        //get a lit of the last 10 tags
        List<postsTags> tags = serviceTag.getLast10Tags();
        // add it to the model
        model.addAttribute("tagList", tags);

        return "dashboard";
    }

    @RequestMapping(value = "/createPost", method = RequestMethod.GET)
    public String createPost(HttpServletRequest request, Model model) {
//        if (request.getRemoteUser() != null) {
//            String username = request.getRemoteUser();
//            Entity currentEntity = ServiceDao.getEntityByUserName(username);
//            model.addAttribute("firstname", currentEntity.getFirstName());
//            model.addAttribute("lastname", currentEntity.getLastName());
//            model.addAttribute("email", currentEntity.getEmail());
//        }

        List<Category> cList = serviceCat.getAllCategories();
        model.addAttribute("cList", cList);
        return "createPost";
    }

    @RequestMapping(value = "submitPost", method = RequestMethod.POST)
    public String submitPost(HttpServletRequest request) {

        Posts post = new Posts();
        post.setPostTitle(request.getParameter("postTitle"));
        post.setPostBody(request.getParameter("postBody"));

        Date date = new Date();
        post.setPostDate(date);

//        try {
            String id = request.getParameter("chooseCategory");
            //get category by id
          
          
            Category c = serviceCat.getCategoryById(Integer.parseInt(id));
         
            // this references categories (is category id)
            post.setUserId(c.getRecordId());
//        } catch (NumberFormatException ex) {
//        }

        servicePost.createPost(post);
        return "redirect:allBlogs";
    }

}
