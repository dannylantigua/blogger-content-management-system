/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import com.sg.blogcms.model.Entity;
import com.sg.blogcms.model.EntitySocialProfiles;
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
public class EntitySocialProfilesDaoTest {

    EntitySocialProfilesDao espDao;
    EntityDao eDao;

    public EntitySocialProfilesDaoTest() {
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
        espDao = ctx.getBean("entitySocialProfiles", EntitySocialProfilesDao.class);

        for (EntitySocialProfiles esp : espDao.getAllEntitySocialProfiles()) {
            espDao.deleteEntitySocialProfiles(esp);
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
     * Test of addEntitySocialProfiles method, of class EntitySocialProfilesDao.
     */
    @Test
    public void testAddEntitySocialProfiles() {
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
        
        EntitySocialProfiles facebook = new EntitySocialProfiles();
        facebook.setEntityId(e.getRecordId());
        facebook.setWebSite("https://www.spongebob.com/");
        facebook.setWebsiteName("Facebook");
        espDao.addEntitySocialProfiles(facebook);

        EntitySocialProfiles currentESP = espDao.getEntitySocialProfilesById(facebook.getEntityId());
        assertEquals(currentESP.getWebSite(), facebook.getWebSite());
    }

    /**
     * Test of deleteEntitySocialProfiles method, of class
     * EntitySocialProfilesDao.
     */
    @Test
    public void testDeleteEntitySocialProfiles() {
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
        
        EntitySocialProfiles facebook = new EntitySocialProfiles();
        facebook.setEntityId(e.getRecordId());
        facebook.setWebSite("https://www.spongebob.com/");
        facebook.setWebsiteName("Facebook");
        espDao.addEntitySocialProfiles(facebook);
        
        espDao.deleteEntitySocialProfiles(facebook);
        
        assertNull(espDao.getEntitySocialProfilesById(facebook.getEntityId()));
    }

    /**
     * Test of updateEntitySocialProfiles method, of class
     * EntitySocialProfilesDao.
     */
    @Test
    public void testUpdateEntitySocialProfiles() {
        
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
        
        EntitySocialProfiles facebook = new EntitySocialProfiles();
        facebook.setEntityId(e.getRecordId());
        facebook.setWebSite("https://www.spongebob.com/");
        facebook.setWebsiteName("Facebook");
        espDao.addEntitySocialProfiles(facebook);
        
        EntitySocialProfiles facebookupdated = new EntitySocialProfiles();
        facebookupdated.setEntityId(e.getRecordId());
        facebookupdated.setWebSite("https://www.spongebob.com/");
        facebookupdated.setWebsiteName("Bookface");
        espDao.updateEntitySocialProfiles(facebookupdated);
        
        assertEquals(facebookupdated.getWebsiteName(),espDao.getEntitySocialProfilesById(facebookupdated.getEntityId()).getWebsiteName());
        
    }

  
    /**
     * Test of getAllEntitySocialProfiles method, of class
     * EntitySocialProfilesDao.
     */
    @Test
    public void testGetAllEntitySocialProfiles() {
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
        assertEquals(eDao.getAllEntities().size(),1);
    }

}
