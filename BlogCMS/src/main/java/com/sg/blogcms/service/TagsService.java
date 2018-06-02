/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.service;

import com.sg.blogcms.model.postsTags;
import java.util.List;

/**
 *
 * @author dannylantigua
 */
public interface TagsService {
    
    List<postsTags> getAllTagsByPosts(int postId);
    
    void savePostTags(List<postsTags> tags);
    
    void removeTag(postsTags tag);

}
