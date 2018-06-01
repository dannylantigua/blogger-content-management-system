/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.model;

import java.util.Objects;

/**
 *
 * @author kmlnd
 */
public class Categories {
    
    private int CategoryId;
    private String CategoryName;

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.CategoryId;
        hash = 53 * hash + Objects.hashCode(this.CategoryName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categories other = (Categories) obj;
        if (this.CategoryId != other.CategoryId) {
            return false;
        }
        if (!Objects.equals(this.CategoryName, other.CategoryName)) {
            return false;
        }
        return true;
    }
    
}
