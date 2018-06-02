/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import com.sg.blogcms.model.Entity;
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
public class EntityDaoTest {

    EntityDao eDao;

    public EntityDaoTest() {
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
        eDao = ctx.getBean("entityDao", EntityDao.class);
        List<Entity> entities = eDao.getAllEntities();

        for (Entity currentEntity : entities) {
            eDao.removeEntityById(currentEntity.getEntityId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addEntity method, of class EntityDao.
     */
    @Test
    public void testAddEntityAndGet() {
        Entity e = new Entity();
        e.setAboutMe("I enjoy coding.");
        e.setEmail("Danny@gmail.com");
        e.setFirstName("Son");
        e.setLastName("Danny");
        e.setIsAdmin(false);
        e.setPassword("theCakeIsALie94");
        e.setPhoneNumber("2342423");
        e.setUserName("Kaniki");
        eDao.addEntity(e);
        Entity eFromDatabase = eDao.getEntityById(e.getEntityId());
        assertEquals(eFromDatabase.getFirstName(), e.getFirstName());
    }

    /**
     * Test of removeEntityById method, of class EntityDao.
     */
    @Test
    public void testRemoveEntityById() {
    }

    /**
     * Test of updateEntityById method, of class EntityDao.
     */
    @Test
    public void testUpdateEntityById() {
    }

    /**
     * Test of editEntity method, of class EntityDao.
     */
    @Test
    public void testEditEntity() {
    }

    /**
     * Test of getAllEntities method, of class EntityDao.
     */
    @Test
    public void testGetAllEntities() {
        Entity e = new Entity();
        e.setAboutMe("I enjoy coding.");
        e.setEmail("Danny@gmail.com");
        e.setFirstName("Son");
        e.setLastName("Danny");
        e.setIsAdmin(false);
        e.setPassword("theCakeIsALie94");
        e.setPhoneNumber("2342423");
        e.setUserName("Kaniki");
        eDao.addEntity(e);
        
        Entity e2 = new Entity();
        e2.setAboutMe("I enjoy coding a lot.");
        e2.setEmail("vegito@gmail.com");
        e2.setFirstName("Vegito");
        e2.setLastName("Vegito");
        e2.setIsAdmin(false);
        e2.setPassword("theCakeIsALie94");
        e2.setPhoneNumber("2342423");
        e2.setUserName("TrunksFan");
        eDao.addEntity(e2);
        
        assertEquals(eDao.getAllEntities().size(),2);
    }

    
  
}
