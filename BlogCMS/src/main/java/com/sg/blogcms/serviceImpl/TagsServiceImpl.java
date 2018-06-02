/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.serviceImpl;

import com.sg.blogcms.dao.TagsDao;
import com.sg.blogcms.model.postsTags;
import com.sg.blogcms.service.TagsService;
import java.util.List;

/**
 *
 * @author dannylantigua
 */
public class TagsServiceImpl implements TagsService {
    
    TagsDao tagDao;
    
    public TagsServiceImpl (TagsDao dao){
        this.tagDao = dao;
    }

    @Override
    public List<postsTags> getAllTagsByPosts(int postId) {
        return tagDao.getAllTagsByPosts(postId);
    }

    @Override
    public void savePostTags(List<postsTags> tags) {
        tagDao.savePostTags(tags);
    }

    @Override
    public void removeTag(postsTags tag) {
        tagDao.removeTag(tag);
    }
    
}
