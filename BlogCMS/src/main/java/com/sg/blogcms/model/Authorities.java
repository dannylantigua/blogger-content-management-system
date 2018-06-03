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
public class Authorities {
    private String userName;
    private String authority;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.userName);
        hash = 41 * hash + Objects.hashCode(this.authority);
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
        final Authorities other = (Authorities) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.authority, other.authority)) {
            return false;
        }
        return true;
    }
    
    
}
