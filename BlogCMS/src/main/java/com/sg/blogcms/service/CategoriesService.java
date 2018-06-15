/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.service;

import com.sg.blogcms.model.Category;
import java.util.List;

/**
 *
 * @author dannylantigua
 */
public interface CategoriesService {
    
    Category addNewCategory(Category category);
    
    void updateCategory(Category category);
    
    void removeCategory(int categoryId);
    
    Category getCategoryById(int catId);
    
    List<Category> getAllCategories();
    
}
