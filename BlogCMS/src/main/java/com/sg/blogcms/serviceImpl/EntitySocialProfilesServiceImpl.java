/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.serviceImpl;

import com.sg.blogcms.dao.EntitySocialProfilesDao;
import com.sg.blogcms.model.EntitySocialProfiles;
import com.sg.blogcms.service.EntitySocialProfilesService;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class EntitySocialProfilesServiceImpl implements EntitySocialProfilesService{

    EntitySocialProfilesDao esp;
    
    public EntitySocialProfilesServiceImpl(EntitySocialProfilesDao esp){
        this.esp = esp;
    }
    
    @Override
    public EntitySocialProfiles addEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles) {
       return esp.addEntitySocialProfiles(entitySocialProfiles);
    }

    @Override
    public void deleteEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles) {
        esp.deleteEntitySocialProfiles(entitySocialProfiles);
    }

    @Override
    public void updateEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles) {
        esp.updateEntitySocialProfiles(entitySocialProfiles);
    }

    @Override
    public EntitySocialProfiles getEntitySocialProfilesById(int id) {
      return  esp.getEntitySocialProfilesById(id);
    }

    @Override
    public List<EntitySocialProfiles> getAllEntitySocialProfiles() {
        return esp.getAllEntitySocialProfiles();
    }
    
}
