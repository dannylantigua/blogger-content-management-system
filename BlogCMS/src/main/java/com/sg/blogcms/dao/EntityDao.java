/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import com.sg.blogcms.model.Entity;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface EntityDao {
    
    Entity addEntity(Entity entity);
    
    Entity getEntityById(int entityId);
    
    void removeEntityById(int entityId);
    
    Entity updateEntityById(int entityId);
    
    Entity editEntity(Entity entity);
    
    List<Entity> getAllEntities();
}
