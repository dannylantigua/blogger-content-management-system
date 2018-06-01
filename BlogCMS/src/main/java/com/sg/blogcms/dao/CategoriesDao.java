/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.dao;

import com.sg.blogcms.model.Categories;
import java.util.List;



/**
 *
 * @author dannylantigua
 */
public interface CategoriesDao {
    
    Categories addNewCategory(Categories category);
    
    void updateCategory(Categories category);
    
    void removeCategory(int categoryId);
    
    Categories getCategoryById(int catId);
    
    List<Categories> getAllCategories();
}
