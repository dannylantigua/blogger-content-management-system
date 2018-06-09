/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.service;

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

        postService = ctx.getBean("postsService", PostsService.class);

        List<Posts> posts = postService.getAllPosts();

        for (Posts currentPost : posts) {
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

        Posts post = dummyPost();
        Posts post2 = dummyPost2();
        postService.createPost(post);
        postService.createPost(post2);

        List<Posts> posts = postService.getAllPosts();
        assertEquals(posts.size(), 2);

    }

    @Test
    public void testaddPostsGetPost() {
    Posts p = postService.createPost(dummyPost());
        assertEquals(postService.getPostsById(p.getRecordId()).getPostTitle(),"Cooking with Danny");
    }
    
    @Test
    public void updatePost(){
        Posts post = postService.createPost(dummyPost());
        
        post.setPostTitle("no more cooking");
        postService.updatePost(post);
        assertEquals(post.getPostTitle(),postService.getPostsById(post.getRecordId()).getPostTitle());
        
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
        return post;
    }

}
