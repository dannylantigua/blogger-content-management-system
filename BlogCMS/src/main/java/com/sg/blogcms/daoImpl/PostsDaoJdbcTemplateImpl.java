/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.daoImpl;

import com.sg.blogcms.dao.PostsDao;
import com.sg.blogcms.mappers.Mappers.PostsMapper;
import com.sg.blogcms.model.Posts;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author kmlnd
 */
public class PostsDaoJdbcTemplateImpl implements PostsDao {

    JdbcTemplate jdbcTemplate;

    //PREPARE STATMENTS
    private static final String SQL_ADD_POST = " "
            + " INSERT INTO Posts (postTitle, postBody, postDate, expireDate,likes,isPending , isApproved, isRejected , userId)"
            + " VALUES (?,?,?,?,?,?,?,?,?) ";

    private static final String SQL_GET_ALL_POSTS = " SELECT * FROM POSTS ";

    private static final String SQL_GET_POST_BY_ID = " SELECT * FROM Posts WHERE recordId = ? ";

    private static final String SQL_REMOVE_POST_BY_ID = " DELETE FROM Posts WHERE recordId = ? ";

    private static final String SQL_GET_POSTS_BY_CATEGORY = " SELECT * FROM Posts WHERE userId = ? ";
    
    private static final String SQL_INSERT_CATEGORY_AND_POST = " INSERT INTO Categories ( recordId , CategoryName ) VALUES (?,?) ";

    //SETTER INJECTION
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //METHODS
    @Override
    public List<Posts> getAllPosts() {

        try {
            return jdbcTemplate.query(SQL_GET_ALL_POSTS, new PostsMapper());
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Posts getPostsById(int id) {
        return jdbcTemplate.queryForObject(SQL_GET_POST_BY_ID, new PostsMapper(), id);
    }

    @Override
    public void removePostsById(int id) {
        jdbcTemplate.update(SQL_REMOVE_POST_BY_ID, id);
    }

    ///jonathan's work//
    @Override
    public Posts createPost(Posts currentPosts) {
        //WILL CHANGE
        jdbcTemplate.update(SQL_INSERT_CATEGORY_AND_POST,currentPosts.getUserId() );
        
        jdbcTemplate.update(SQL_ADD_POST,
                currentPosts.getPostTitle(),
                currentPosts.getPostBody(),
                currentPosts.getPostDate(),
                currentPosts.getExpireDate(),
                currentPosts.getLikes(),
                currentPosts.isIsPending(),
                currentPosts.isIsApproved(),
                currentPosts.isIsRejected(),
                currentPosts.getUserId());

        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        currentPosts.setRecordId(newId);
        return currentPosts;
    }

    @Override
    public List<Posts> getPostsByCategory(int theCategoryId) {
        return jdbcTemplate.query(SQL_GET_POSTS_BY_CATEGORY, new PostsMapper(), theCategoryId);
    }
}
