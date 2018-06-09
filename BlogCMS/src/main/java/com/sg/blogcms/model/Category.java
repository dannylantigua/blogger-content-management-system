/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.model;

import java.util.Objects;

/**
 *
 * @author dannylantigua
 */
public class Category {
    
    private int recordId;
    private String categoryDesc;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.recordId;
        hash = 29 * hash + Objects.hashCode(this.categoryDesc);
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
        final Category other = (Category) obj;
        if (this.recordId != other.recordId) {
            return false;
        }
        if (!Objects.equals(this.categoryDesc, other.categoryDesc)) {
            return false;
        }
        return true;
    }
}
