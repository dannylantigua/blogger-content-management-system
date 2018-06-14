/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.service;

import com.sg.blogcms.dao.CategoriesDao;
import com.sg.blogcms.model.Category;
import com.sg.blogcms.model.Posts;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Categories;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kmlnd
 */
public class PostsServiceTest {

    PostsService postService;
    CategoriesDao CatDao;

    public PostsServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        postService = ctx.getBean("postsService", PostsService.class);

        List<Posts> posts = postService.getAllPosts();

        for (Posts currentPost : posts) {
            postService.removePostsById(currentPost.getRecordId());
        }

        CatDao = ctx.getBean("categoriesDao", CategoriesDao.class);
//        List<Category> categories = CatDao.getAllCategories();
//
//        for (Category currentCat : categories) {
//            CatDao.removeCategory(currentCat.getRecordId());
//        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllPosts method, of class PostsService.
     */
    @Test
    public void testGetAllPosts() {

        Posts post = dummyPost();
        Posts post2 = dummyPost2();
        postService.createPost(post);
        postService.createPost(post2);

        List<Posts> posts = postService.getAllPosts();
        assertEquals(posts.size(), 2);

    }

    @Test
    public void testaddPostsGetPost() {
        Category c = new Category();
        c.setRecordId(5);
        c.setCategoryDesc("Food");
        CatDao.addNewCategory(c);

        Posts p = postService.createPost(dummyPost());
        assertEquals(postService.getPostsById(p.getRecordId()).getPostTitle(), "Cooking with Danny");
    }

    @Test
    public void updatePost() {
        Posts dPost = dummyPost();
        postService.createPost(dPost);

        Posts updatedPost = postService.getPostsById(dPost.getRecordId());
        updatedPost.setPostTitle("I hate cooking");
        postService.updatePost(updatedPost);

        
        assertEquals(updatedPost.getPostTitle(),postService.getPostsById(updatedPost.getRecordId()).getPostTitle());
    }

    public Posts dummyPost() {

        Posts post = new Posts();
        Date date = new Date();
        post.setPostTitle("Cooking with Danny");
        post.setPostDate(date);
        post.setPostBody(" Well.... cooking with this guy has been such an amazing expereince WOW. I learned so much blah blah blah....");
        post.setPostDate(date);
        post.setExpireDate(date);
        post.setLikes(20);
        post.setIsPending(false);
        post.setIsApproved(true);
        post.setIsRejected(false);
        post.setUserId(1);
        return post;
    }

    public Posts dummyPost2() {

        Posts post = new Posts();
        Date date = new Date();
        post.setPostTitle("Cooking with Kenny");
        post.setPostDate(date);
        post.setPostBody(" Kenny cant cook . but Well.... cooking with this guy Danny has been such an amazing expereince WOW. I learned so much blah blah blah....");
        post.setPostDate(date);
        post.setExpireDate(date);
        post.setLikes(45);
        post.setIsPending(false);
        post.setIsApproved(true);
        post.setIsRejected(false);
        post.setUserId(1);
        return post;
    }

}
