/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.mappers;

import com.sg.blogcms.model.Authorities;
import com.sg.blogcms.model.Categories;
import com.sg.blogcms.model.Entity;
import com.sg.blogcms.model.Posts;
import com.sg.blogcms.model.StaticPages;
import com.sg.blogcms.model.postsTags;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author kmlnd
 */
public class Mappers {

    /*==========================================================

        This class holds all of the mappers for the objects.
        
    ==========================================================*/
    public static final class EntityMapper implements RowMapper<Entity> {

        @Override
        public Entity mapRow(ResultSet rs, int i) throws SQLException {
            //converting entity from rows of database into an object
            Entity currentEntityFromRow = new Entity();
            currentEntityFromRow.setRecordId(rs.getInt("recordId"));
            currentEntityFromRow.setFirstName(rs.getString("FirstName"));
            currentEntityFromRow.setLastName(rs.getString("LastName"));
            currentEntityFromRow.setEmail(rs.getString("EMAIL"));
            currentEntityFromRow.setPhoneNumber(rs.getString("PhoneNumber"));
            currentEntityFromRow.setUserName(rs.getString("UserName"));
            currentEntityFromRow.setPassword(rs.getString("passwd"));
            currentEntityFromRow.setIsAdmin(rs.getBoolean("isAdmin"));
            currentEntityFromRow.setAboutMe(rs.getString("AboutMe"));
            return currentEntityFromRow;
        }

    }
    
    //authorities mapper
    public static final class AuthoritiesMapper implements RowMapper<Authorities> {

        @Override
        public Authorities mapRow(ResultSet rs, int i) throws SQLException {
            Authorities au = new Authorities();
            au.setUserName(rs.getString("UserName"));
            au.setAuthority(rs.getString("authority"));
            return au;
        }
        
    }
    
    // TAGS MAPPER
    public static final class TagsMapper implements RowMapper<postsTags> {

        @Override
        public postsTags mapRow(ResultSet rs, int i) throws SQLException {
            //converting entity from rows of database into an object
            
            postsTags currentTag = new postsTags();
            currentTag.setPostId(rs.getInt("postId"));
            currentTag.setTag(rs.getString("Tag"));
            return currentTag;
        }
    }
    
    // CATEGORIES MAPPER
    public static final class CategoriesMapper implements RowMapper<Categories> {

        @Override
        public Categories mapRow(ResultSet rs, int i) throws SQLException {
            //converting entity from rows of database into an object
            
            Categories currentCategory = new Categories();
            currentCategory.setRecordId(rs.getInt("recordId"));
            currentCategory.setCategoryName(rs.getString("CategoryName"));
            return currentCategory;
        }
    }
    
    // STATIC PAGES MAPPER
    public static final class StaticPagesMapper implements RowMapper<StaticPages> {

        @Override
        public StaticPages mapRow(ResultSet rs, int i) throws SQLException {
            //converting entity from rows of database into an object
            
            StaticPages page = new StaticPages();
            page.setRecordId(rs.getInt("recordId"));
            page.setPageName(rs.getString("PageName"));
            page.setContent(rs.getString("Content"));
            return page;
        }
    }
    
    // POSTS MAPPER
    public static final class PostsMapper implements RowMapper<Posts>  {

        @Override
        public Posts mapRow(ResultSet rs, int i) throws SQLException {
            
          Posts currentPost = new Posts();
          
          currentPost.setRecordId(rs.getInt("recordId"));
          
          currentPost.setPostTitle(rs.getString("postTitle"));
          
          currentPost.setPostBody(rs.getString("postBody"));
          
          currentPost.setUserId(rs.getInt("userId"));
          
          currentPost.setPostDate(rs.getDate("postDate"));
          
          currentPost.setExpireDate(rs.getDate("expireDate"));
          
          currentPost.setLikes(rs.getInt("likes"));
          
          currentPost.setIsPending(rs.getBoolean("isPending"));
          
          currentPost.setIsPending(rs.getBoolean("isPending"));
          
          currentPost.setIsApproved(rs.getBoolean("isApproved"));
          
          currentPost.setIsRejected(rs.getBoolean("isRejected"));
          
          return currentPost;
        }
        
    }
    
}
