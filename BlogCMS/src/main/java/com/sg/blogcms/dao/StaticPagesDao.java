/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import com.sg.blogcms.model.StaticPages;
import java.util.List;

/**
 *
 * @author dannylantigua
 */
public interface StaticPagesDao {
    
    StaticPages addNewStaticPage(StaticPages page);
    
    void updateStaticPage(StaticPages page);
    
    void removeStaticPage(int pageId);
    
    StaticPages getStaticPageById(int pageId);
    
    List<StaticPages> getAllStaticPages();
}
