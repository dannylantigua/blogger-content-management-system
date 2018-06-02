/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import com.sg.blogcms.model.Categories;
import com.sg.blogcms.model.StaticPages;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
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
public class StaticPagesDaoTest {
    
    StaticPagesDao stDao;
    
    public StaticPagesDaoTest() {
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
        stDao = ctx.getBean("StaticPagesDao", StaticPagesDao.class);
        List<StaticPages> pages = stDao.getAllStaticPages();
        
        for (StaticPages currentPage : pages) {
            stDao.removeStaticPage(currentPage.getRecordId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addNewStaticPage method, of class StaticPagesDao.
     */
    @Test
    public void testAddGetDeleteStaticPage() {
        StaticPages page = new StaticPages();
        page.setRecordId(1);
        page.setPageName("About");
        page.setContent("Content for About page...");
        stDao.addNewStaticPage(page);
        
        StaticPages fromDao = stDao.getStaticPageById(page.getRecordId());
        assertEquals(fromDao, page);
        
        stDao.removeStaticPage(page.getRecordId());
        assertNull(stDao.getStaticPageById(page.getRecordId()));
    }

    /**
     * Test of updateStaticPage method, of class StaticPagesDao.
     */
    @Test
    public void testUpdateStaticPage() {
        StaticPages page = new StaticPages();
        page.setRecordId(2);
        page.setPageName("Contact Us");
        page.setContent("Content for Contact Us page...");
        stDao.addNewStaticPage(page);
        
        page.setPageName("Contact");
        stDao.updateStaticPage(page);
        StaticPages fromDao = stDao.getStaticPageById(page.getRecordId());
        assertEquals(fromDao, page);
    }

    /**
     * Test of getAllStaticPages method, of class StaticPagesDao.
     */
    @Test
    public void testGetAllStaticPages() {
        StaticPages page = new StaticPages();
        page.setRecordId(1);
        page.setPageName("About");
        page.setContent("Content for About page...");
        stDao.addNewStaticPage(page);
        
        StaticPages page2 = new StaticPages();
        page2.setRecordId(2);
        page2.setPageName("Contact Us");
        page2.setContent("Content for Contact Us page...");
        stDao.addNewStaticPage(page2);
        
        List<StaticPages> pages = stDao.getAllStaticPages();
        assertEquals(pages.size(), 2);
    }
    
}
