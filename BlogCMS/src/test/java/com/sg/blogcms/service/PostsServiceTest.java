/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.service;

import com.sg.blogcms.dao.CategoriesDao;
import com.sg.blogcms.dao.EntityDao;
import com.sg.blogcms.model.Category;
import com.sg.blogcms.model.Entity;
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
    EntityDao eDao;

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
        List<Category> categories = CatDao.getAllCategories();

        for (Category currentCat : categories) {
            CatDao.removeCategory(currentCat.getRecordId());
        }

        eDao = ctx.getBean("entityDao", EntityDao.class);
        List<Entity> entities = eDao.getAllEntities();

        for (Entity currentEntity : entities) {
            eDao.removeEntityById(currentEntity.getRecordId());
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
        Entity user = dummyEntity();
        Category category = dummyCategory();

        System.out.println(user.getRecordId());
        
        
        eDao.addEntity(user);
        CatDao.addNewCategory(category);
        CatDao.getCategoryById(category.getRecordId());
        System.out.println(eDao.getEntityById(user.getRecordId()).getRecordId());
 
        Posts post = dummyPost(eDao.getEntityById(user.getRecordId()).getRecordId() , CatDao.getCategoryById(category.getRecordId()).getRecordId());
        Posts post2 = dummyPost2(eDao.getEntityById(user.getRecordId()).getRecordId() , CatDao.getCategoryById(category.getRecordId()).getRecordId());
        postService.createPost(post);
        postService.createPost(post2);

        List<Posts> posts = postService.getAllPosts();
        assertEquals(posts.size(), 2);

    }

    @Test
    public void testaddPostsGetPost() {
           Entity user = dummyEntity();
        Category category = dummyCategory();

        System.out.println(user.getRecordId());
        
        
        eDao.addEntity(user);
        CatDao.addNewCategory(category);
        CatDao.getCategoryById(category.getRecordId());
        System.out.println(eDao.getEntityById(user.getRecordId()).getRecordId());
 
        Posts post = dummyPost(eDao.getEntityById(user.getRecordId()).getRecordId() , CatDao.getCategoryById(category.getRecordId()).getRecordId());
        Posts post2 = dummyPost2(eDao.getEntityById(user.getRecordId()).getRecordId() , CatDao.getCategoryById(category.getRecordId()).getRecordId());
        postService.createPost(post);
        postService.createPost(post2);
        
        assertEquals(postService.getPostsById(post.getRecordId()).getPostTitle(), "Cooking with Danny");
    }

    @Test
    public void updatePost() {
           Entity user = dummyEntity();
        Category category = dummyCategory();

        System.out.println(user.getRecordId());
        
        
        eDao.addEntity(user);
        CatDao.addNewCategory(category);
        CatDao.getCategoryById(category.getRecordId());
        System.out.println(eDao.getEntityById(user.getRecordId()).getRecordId());
 
        Posts post = dummyPost(eDao.getEntityById(user.getRecordId()).getRecordId() , CatDao.getCategoryById(category.getRecordId()).getRecordId());
        Posts post2 = dummyPost2(eDao.getEntityById(user.getRecordId()).getRecordId() , CatDao.getCategoryById(category.getRecordId()).getRecordId());
        postService.createPost(post);
        postService.createPost(post2);

        Posts currentPost = postService.getPostsById(post2.getRecordId());
        System.out.println(currentPost.getPostTitle());
        
        assertEquals(currentPost.getRecordId(),post2.getRecordId());
        assertEquals(currentPost.getPostTitle(),post2.getPostTitle());
        currentPost.setPostTitle("test");
        postService.updatePost(currentPost);
        
        assertEquals(postService.getPostsById(currentPost.getRecordId()).getPostTitle(),"test");
     
    }

    public Posts dummyPost(int userId, int categoryId) {

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
        post.setUserId(userId);
        post.setCategoryId(categoryId);
        return post;
    }

    public Posts dummyPost2(int userId, int categoryId) {

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
        post.setUserId(userId);
        post.setCategoryId(categoryId);
        return post;
    }

    public Entity dummyEntity() {
        Entity currentEntity = new Entity();
        currentEntity.setUserName("kenny");
        currentEntity.setFirstName("Kenneth");
        currentEntity.setLastName("Melendez");
        currentEntity.setPassword("password");
        return currentEntity;
    }

    public Category dummyCategory() {
        Category c = new Category();
        c.setRecordId(0);
        c.setCategoryDesc("Health");
        return c;
    }

}
