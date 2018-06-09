/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import com.sg.blogcms.model.Category;
import com.sg.blogcms.model.Entity;
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
public class CategoriesDaoTest {
    
    CategoriesDao CatDao;
    
    public CategoriesDaoTest() {
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
        CatDao = ctx.getBean("categoriesDao", CategoriesDao.class);
        List<Category> categories = CatDao.getAllCategories();
        
        for (Category currentCat : categories) {
            CatDao.removeCategory(currentCat.getRecordId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addNewCategory method, of class CategoriesDao.
     */
    @Test
    public void testAddGetDeleteCategory() {        
        Category ct = new Category();
        ct.setRecordId(1);
        ct.setCategoryDesc("Technology");
        CatDao.addNewCategory(ct);
        
        Category fromDb = CatDao.getCategoryById(ct.getRecordId());
        assertEquals(fromDb, ct);
        
        CatDao.removeCategory(ct.getRecordId());
        assertNull(CatDao.getCategoryById(ct.getRecordId()));
    }

    /**
     * Test of updateCategory method, of class CategoriesDao.
     */
    @Test
    public void testUpdateCategory() {
        Category ct2 = new Category();
        ct2.setRecordId(2);
        ct2.setCategoryDesc("Health");
        CatDao.addNewCategory(ct2);
        
        ct2.setCategoryDesc("Health & Fitness");
        CatDao.updateCategory(ct2);
        
        Category fromDb = CatDao.getCategoryById(ct2.getRecordId());
        assertEquals(fromDb, ct2);
    }

    /**
     * Test of getAllCategories method, of class CategoriesDao.
     */
    @Test
    public void testGetAllCategories() {
        Category ct = new Category();
        ct.setRecordId(1);
        ct.setCategoryDesc("Technology");
        CatDao.addNewCategory(ct);
        
        Category ct2 = new Category();
        ct2.setRecordId(2);
        ct2.setCategoryDesc("Health");
        CatDao.addNewCategory(ct2);
        
        List<Category> cats = CatDao.getAllCategories();
        assertEquals(cats.size(), 2);
    }
    
}
