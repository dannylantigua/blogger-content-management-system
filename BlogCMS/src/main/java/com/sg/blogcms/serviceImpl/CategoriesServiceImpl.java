/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.serviceImpl;

import com.sg.blogcms.dao.CategoriesDao;
import com.sg.blogcms.model.Categories;
import com.sg.blogcms.service.CategoriesService;
import java.util.List;

/**
 *
 * @author dannylantigua
 */
public class CategoriesServiceImpl implements CategoriesService {
    
    CategoriesDao dao;
    
    public CategoriesServiceImpl (CategoriesDao dao){
        this.dao = dao;
    }

    @Override
    public Categories addNewCategory(Categories category) {
        return dao.addNewCategory(category);
    }

    @Override
    public void updateCategory(Categories category) {
        dao.updateCategory(category);
    }

    @Override
    public void removeCategory(int categoryId) {
        dao.removeCategory(categoryId);
    }

    @Override
    public Categories getCategoryById(int catId) {
        return dao.getCategoryById(catId);
    }

    @Override
    public List<Categories> getAllCategories() {
        return dao.getAllCategories();
    }
    
}
