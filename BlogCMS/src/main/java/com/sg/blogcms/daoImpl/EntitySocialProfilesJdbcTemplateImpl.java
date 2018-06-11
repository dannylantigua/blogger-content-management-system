/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.daoImpl;

import com.sg.blogcms.dao.EntitySocialProfilesDao;
import com.sg.blogcms.mappers.Mappers.EntitySocialProfilesMapper;
import com.sg.blogcms.model.Entity;
import com.sg.blogcms.model.EntitySocialProfiles;
import static com.sun.jmx.snmp.SnmpStatusException.readOnly;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kmlnd
 */
public class EntitySocialProfilesJdbcTemplateImpl implements EntitySocialProfilesDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //prepared statements
    private static final String SQL_ADD_SEP = " INSERT (WebName , Website , EntityId) VALUES ( ? , ? , ?) ";

    private static final String SQL_REMOVE_SEP = " DELETE FROM  EntitySocialProfiles WHERE EntityId = ?";

    private static final String SQL_GET_SEP_BY_ID = " SELECT * FROM  EntitySocialProfiles WHERE EntityId = ? ";
    
    private static final String SQL_GET_ALL_SEP = " SELECT * FROM EntitySocialProfiles ";

    private static final String SQL_UPDATE_SEP = " UPDATE EntitySocialProfiles SET WebName = ? , Website = ? , EntityId = ? " ;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public EntitySocialProfiles addEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles) {

        jdbcTemplate.update(SQL_ADD_SEP, entitySocialProfiles.getWebsiteName(), entitySocialProfiles.getWebSite(), entitySocialProfiles.getEntityId());
        return null;
    }

    @Override
    public void deleteEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles) {
        jdbcTemplate.update(SQL_REMOVE_SEP, entitySocialProfiles.getEntityId());
    }

    @Override
    public List<EntitySocialProfiles> getAllEntitySocialProfiles() {
        return jdbcTemplate.query(SQL_GET_ALL_SEP, new EntitySocialProfilesMapper());
    }

    @Override
    public void updateEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles) {
      jdbcTemplate.update(SQL_UPDATE_SEP , entitySocialProfiles.getWebsiteName(), entitySocialProfiles.getWebSite(), entitySocialProfiles.getEntityId());
    }

    @Override
    public EntitySocialProfiles getEntitySocialProfilesById(EntitySocialProfiles entitySocialProfiles) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_SEP_BY_ID, new EntitySocialProfilesMapper(), entitySocialProfiles.getEntityId());
        } catch (DataAccessException ex) {
            return null;
        }
    }

}
