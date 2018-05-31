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
public class EntitySocialProfiles {

    private String webSite;
    private String websiteName;
    private int EntityId;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int EntityId) {
        this.EntityId = EntityId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.webSite);
        hash = 47 * hash + Objects.hashCode(this.websiteName);
        hash = 47 * hash + this.EntityId;
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
        final EntitySocialProfiles other = (EntitySocialProfiles) obj;
        if (this.EntityId != other.EntityId) {
            return false;
        }
        if (!Objects.equals(this.webSite, other.webSite)) {
            return false;
        }
        if (!Objects.equals(this.websiteName, other.websiteName)) {
            return false;
        }
        return true;
    }
   
    
    
}
