/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author kmlnd
 */
public class Posts {
    private int postId;
    private int recordId;
    private String postTitle;
    private String postBody;
    private Date dateTime;
    private int likes;
    private boolean isRejected;
    private boolean isApproved;
    private boolean isPending;
    private Date expireDate;
    private List<postsTags> postTags;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

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

    public List<postsTags> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<postsTags> postTags) {
        this.postTags = postTags;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.postId;
        hash = 29 * hash + this.recordId;
        hash = 29 * hash + Objects.hashCode(this.postTitle);
        hash = 29 * hash + Objects.hashCode(this.postBody);
        hash = 29 * hash + Objects.hashCode(this.dateTime);
        hash = 29 * hash + this.likes;
        hash = 29 * hash + (this.isRejected ? 1 : 0);
        hash = 29 * hash + (this.isApproved ? 1 : 0);
        hash = 29 * hash + (this.isPending ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.expireDate);
        hash = 29 * hash + Objects.hashCode(this.postTags);
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
        if (this.postId != other.postId) {
            return false;
        }
        if (this.recordId != other.recordId) {
            return false;
        }
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
        if (!Objects.equals(this.postTags, other.postTags)) {
            return false;
        }
        return true;
    }

    
    
}
