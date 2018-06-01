/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import com.sg.blogcms.model.Categories;
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
        List<Categories> categories = CatDao.getAllCategories();
        
        for (Categories currentCat : categories) {
            CatDao.removeCategory(currentCat.getCategoryId());
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
        Categories ct = new Categories();
        ct.setCategoryId(1);
        ct.setCategoryName("Technology");
        CatDao.addNewCategory(ct);
        
        Categories fromDb = CatDao.getCategoryById(ct.getCategoryId());
        assertEquals(fromDb, ct);
        
        CatDao.removeCategory(ct.getCategoryId());
        assertNull(CatDao.getCategoryById(ct.getCategoryId()));
    }

    /**
     * Test of updateCategory method, of class CategoriesDao.
     */
    @Test
    public void testUpdateCategory() {
        Categories ct2 = new Categories();
        ct2.setCategoryId(2);
        ct2.setCategoryName("Health");
        CatDao.addNewCategory(ct2);
        
        ct2.setCategoryName("Health & Fitness");
        CatDao.updateCategory(ct2);
        
        Categories fromDb = CatDao.getCategoryById(ct2.getCategoryId());
        assertEquals(fromDb, ct2);
    }

    /**
     * Test of getAllCategories method, of class CategoriesDao.
     */
    @Test
    public void testGetAllCategories() {
        Categories ct = new Categories();
        ct.setCategoryId(1);
        ct.setCategoryName("Technology");
        CatDao.addNewCategory(ct);
        
        Categories ct2 = new Categories();
        ct2.setCategoryId(2);
        ct2.setCategoryName("Health");
        CatDao.addNewCategory(ct2);
        
        List<Categories> cats = CatDao.getAllCategories();
        assertEquals(cats.size(), 2);
    }
    
}
