/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.serviceImpl;

import com.sg.blogcms.dao.StaticPagesDao;
import com.sg.blogcms.model.StaticPages;
import com.sg.blogcms.service.StaticPagesService;
import java.util.List;

/**
 *
 * @author dannylantigua
 */
public class StaticPagesServiceImpl implements StaticPagesService {
    
    StaticPagesDao dao;
    
    public StaticPagesServiceImpl (StaticPagesDao dao){
        this.dao = dao;
    }

    @Override
    public StaticPages addNewStaticPage(StaticPages page) {
        return dao.addNewStaticPage(page);
    }

    @Override
    public void updateStaticPage(StaticPages page) {
        dao.updateStaticPage(page);
    }

    @Override
    public void removeStaticPage(int pageId) {
        dao.removeStaticPage(pageId);
    }

    @Override
    public StaticPages getStaticPageById(int pageId) {
        return dao.getStaticPageById(pageId);
    }

    @Override
    public List<StaticPages> getAllStaticPages() {
        return dao.getAllStaticPages();
    }
    
}
