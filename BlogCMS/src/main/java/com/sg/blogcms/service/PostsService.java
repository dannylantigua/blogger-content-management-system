/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.service;

import com.sg.blogcms.model.Posts;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface PostsService {

    Posts createPost(Posts currentPosts);

    List<Posts> getAllPosts();

    Posts getPostsById(int id);

    void removePostsById(int id);

    List<Posts> getPostsByCategory(int theCategoryId);
}
