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

    private int recordId;
    private String postTitle;
    private String postBody;
    private String userId;
    private Date postTime;
    private int likes;
    private boolean isRejected;
    private boolean isApproved;
    private boolean isPending;
    private Date expireDate;
    private List<postsTags> postTags;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
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
        int hash = 7;
        hash = 53 * hash + this.recordId;
        hash = 53 * hash + Objects.hashCode(this.postTitle);
        hash = 53 * hash + Objects.hashCode(this.postBody);
        hash = 53 * hash + Objects.hashCode(this.userId);
        hash = 53 * hash + Objects.hashCode(this.postTime);
        hash = 53 * hash + this.likes;
        hash = 53 * hash + (this.isRejected ? 1 : 0);
        hash = 53 * hash + (this.isApproved ? 1 : 0);
        hash = 53 * hash + (this.isPending ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.expireDate);
        hash = 53 * hash + Objects.hashCode(this.postTags);
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
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.postTime, other.postTime)) {
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
