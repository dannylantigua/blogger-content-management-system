/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author kmlnd
 */
public class Posts {
    private String postTitle;
    private String postBody;
    private Date dateTime;
    private int likes;
    private boolean isRejected;
    private boolean isApproved;
    private boolean isPending;
    private Date expireDate;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isIsRejected() {
        return isRejected;
    }

    public void setIsRejected(boolean isRejected) {
        this.isRejected = isRejected;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public boolean isIsPending() {
        return isPending;
    }

    public void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.postTitle);
        hash = 89 * hash + Objects.hashCode(this.postBody);
        hash = 89 * hash + Objects.hashCode(this.dateTime);
        hash = 89 * hash + this.likes;
        hash = 89 * hash + (this.isRejected ? 1 : 0);
        hash = 89 * hash + (this.isApproved ? 1 : 0);
        hash = 89 * hash + (this.isPending ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.expireDate);
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
        final Posts other = (Posts) obj;
        if (this.likes != other.likes) {
            return false;
        }
        if (this.isRejected != other.isRejected) {
            return false;
        }
        if (this.isApproved != other.isApproved) {
            return false;
        }
        if (this.isPending != other.isPending) {
            return false;
        }
        if (!Objects.equals(this.postTitle, other.postTitle)) {
            return false;
        }
        if (!Objects.equals(this.postBody, other.postBody)) {
            return false;
        }
        if (!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }
        if (!Objects.equals(this.expireDate, other.expireDate)) {
            return false;
        }
        return true;
    }
    
    
    
}
