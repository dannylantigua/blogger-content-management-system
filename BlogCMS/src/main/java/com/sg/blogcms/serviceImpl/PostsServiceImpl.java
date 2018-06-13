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
    public Posts createPost(Posts currentPosts) {
        return postsDao.createPost(currentPosts);
    }

    @Override
    public List<Posts> getPostsByCategory(int theCategoryId) {
        return postsDao.getPostsByCategory(theCategoryId);
    }

    @Override
    public List<Posts> getLatestPosts() {
        //getting the list of posts
        List<Posts> posts = postsDao.getLatestPosts();
        
//        //the amount of posts you expect
//        int postCount = 4;
//        
//        // scanning and filling the posts were expecting if they return null
//        // as a blank object to display to the user that the main page is empty
//        for (int x = 0; x < postCount; x++) {
//            try {
//                posts.get(x);
//            } catch(IndexOutOfBoundsException ex){
//                posts.add(emptyPosts());
//            }
//        }
        return posts;
    }

    // creating an emtpy post object incase the posts are empty 
    // and to avoid null pointer exception 
    // and to display empty current posts to the user if there are no latest posts
    public Posts emptyPosts() {
        Posts post = new Posts();
        post.setPostTitle("No current Post");
//        post.setP
        return post;
    }

    @Override
    public void updatePost(Posts post) {
        postsDao.updatePost(post);
    }

    @Override
    public int getPostCount(int userId) {
        return postsDao.getPostCount(userId);
    }

}
