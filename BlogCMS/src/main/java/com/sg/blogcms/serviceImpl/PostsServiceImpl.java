/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.serviceImpl;

import com.sg.blogcms.dao.PostsDao;
import com.sg.blogcms.model.Posts;
import com.sg.blogcms.service.PostsService;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class PostsServiceImpl implements PostsService {

    PostsDao postsDao;

    public PostsServiceImpl(PostsDao postsDao) {
        this.postsDao = postsDao;
    }

    @Override
    public List<Posts> getAllPosts() {
        return postsDao.getAllPosts();
    }

    @Override
    public Posts getPostsById(int id) {
        return postsDao.getPostsById(id);
    }

    @Override
    public void removePostsById(int id) {
        postsDao.removePostsById(id);
    }

    @Override
    public void createPost(Posts currentPosts) {
        postsDao.createPost(currentPosts);
    }

}
