/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import java.util.List;

/**
 *
 * @author Kenny
 */
public interface EntitySocialProfiles {
   
    EntitySocialProfiles addEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles);
   
    void deleteEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles);
    
    void editEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles);
    
    void updateEntitySocialProfiles(EntitySocialProfiles entitySocialProfiles);
    
    List<EntitySocialProfiles> getAllEntitySocialProfiles();
    
}
