/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.serviceImpl;

import com.sg.blogcms.dao.EntityDao;
import com.sg.blogcms.model.Entity;
import com.sg.blogcms.service.EntityService;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class EntityServiceImpl implements EntityService {

    EntityDao entityDao;

    public EntityServiceImpl(EntityDao entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    public Entity addEntity(Entity entity) {
        return entityDao.addEntity(entity);
    }

    @Override
    public Entity getEntityById(int entityId) {
        return entityDao.getEntityById(entityId);
    }

    @Override
    public void removeEntityById(int entityId) {
        entityDao.removeEntityById(entityId);
    }

   

    @Override
    public Entity editEntity(Entity entity) {
        return entityDao.editEntity(entity);
    }

    @Override
    public List<Entity> getAllEntities() {
        return entityDao.getAllEntities();
    }

    @Override
    public Entity getEntityByEmail(String email) {
        return entityDao.getEntityByEmail(email);
    }

    @Override
    public Entity getEntityByPassword(String password) {
        return entityDao.getEntityByPassword(password);
    }

    @Override
    public Entity getEntityByUserName(String username) {
        return entityDao.getEntityByUserName(username);
    }

    @Override
    public void updateEntity(Entity e) {
        entityDao.updateEntity(e);
    }

}
