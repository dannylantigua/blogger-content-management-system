/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import com.sg.blogcms.model.postsTags;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static junit.framework.Assert.assertEquals;
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
 * @author dannylantigua
 */
public class TagsDaoTest {
    
    TagsDao dao;
    
    public TagsDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("TagsDao", TagsDao.class);
        
        // remove all of the Contacts
        List<postsTags> tags = dao.getAllTagsByPosts(1);
        for (postsTags currentTag : tags) {
            dao.removeTag(currentTag);
        }
    }
    
    @After
    public void tearDown() {
    }

    // ERROR PRONE PLS FIX
    
    /**
     * Test of savePostTags method, of class TagsDao.
     */
    @Test
    public void testSaveGetAllRemovePostTags() {      
        postsTags tag1 = new postsTags();
        tag1.setPostId(1);
        tag1.setTag("tech");
        
        postsTags tag2 = new postsTags();
        tag2.setPostId(1);
        tag2.setTag("GoogleIO");
        
        postsTags tag3 = new postsTags();
        tag3.setPostId(1);
        tag3.setTag("phone");
        
        List<postsTags> myList = 
                new ArrayList<>(Arrays.asList(tag1, tag2, tag3));
        // Save
        dao.savePostTags(myList);
        
        // Get the list from DAO
        List<postsTags> fromDao = dao.getAllTagsByPosts(1);
        // Save functionality
        assertEquals(fromDao.indexOf(1), myList.indexOf(1));
        // Get functionality
        assertEquals(fromDao.size(), 3);  
        // Remove functionality
        dao.removeTag(tag1);
        fromDao = dao.getAllTagsByPosts(1);
        assertEquals(fromDao.size(), 2);  
    }

}
