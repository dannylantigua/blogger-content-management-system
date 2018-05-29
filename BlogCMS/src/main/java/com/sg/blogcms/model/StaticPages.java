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
public class StaticPages {

    private String pageName;
    private String url;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.pageName);
        hash = 97 * hash + Objects.hashCode(this.url);
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
        final StaticPages other = (StaticPages) obj;
        if (!Objects.equals(this.pageName, other.pageName)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        return true;
    }
    
    
}
