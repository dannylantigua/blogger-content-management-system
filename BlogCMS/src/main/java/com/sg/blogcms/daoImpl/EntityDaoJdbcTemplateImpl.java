/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.daoImpl;

import com.sg.blogcms.dao.EntityDao;
import com.sg.blogcms.model.Entity;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kmlnd
 */
public class EntityDaoJdbcTemplateImpl implements EntityDao {

    // creating jdbc template and storing it
    JdbcTemplate jdbcTemplate;
    
    //using setter injection to set the template
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final String SQL_INSERT_ENTITY = 
            " INSERT INTO Entity (FirstName, LastName, EMAIL , PhoneNumber,AboutMe,UserName,passwd,isAdmin) "
            + " VALUES ( ? , ? , ? , ? , ? , ? , ?, ?)";
    
    @Override
    public Entity getEntityById(int entityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeEntityById(int entityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity updateEntityById(int entityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity editEntity(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entity> getAllEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Entity addEntity(Entity entity) {
        jdbcTemplate.update(SQL_INSERT_ENTITY,
                entity.getAboutMe(),
                entity.getEmail(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPassword(),
                entity.getPhoneNumber(),
                entity.getUserName());
        
        int entityId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        entity.setEntityId(entityId);
        
        return null;
    }
    
    
}
