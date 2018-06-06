/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.service;

import com.sg.blogcms.model.Posts;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kmlnd
 */
public class PostsServiceTest {
    
    PostsService postService;
    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
    
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
        
        postService = ctx.getBean("postsService" , PostsService.class);
        
        List<Posts> posts = postService.getAllPosts();
        
        for(Posts currentPost : posts){
            postService.removePostsById(currentPost.getRecordId());
        }
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllPosts method, of class PostsService.
     */
    @Test
    public void testGetAllPosts() {
    }
    
   

    
}
