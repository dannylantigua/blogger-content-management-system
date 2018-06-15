/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.daoImpl;

import com.sg.blogcms.dao.CategoriesDao;
import com.sg.blogcms.mappers.Mappers.CategoriesMapper;
import com.sg.blogcms.model.Category;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author dannylantigua
 */
public class CategoriesDaoDbImpl implements CategoriesDao {

    // creating jdbc template and storing it
    JdbcTemplate jdbcTemplate;

    //using setter injection to set the template
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_CATEGORY
            = "insert into Categories (categoryDesc) "
            + "values (?)";
    private static final String SQL_DELETE_CATEGORY
            = "delete from Categories where recordId = ?";
    private static final String SQL_SELECT_CATEGORY_BY_ID
            = "select * from Categories where recordId = ?";
    private static final String SQL_UPDATE_CATEGORY
            = "update Categories set "
            + "categoryDesc = ? "
            + "where recordId = ?";
    private static final String SQL_SELECT_ALL_CATEGORIES
            = "select * from Categories";

    @Override
    public Category addNewCategory(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                category.getCategoryDesc());

        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        category.setRecordId(newId);
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                category.getCategoryDesc(),
                category.getRecordId());
    }

    @Override
    public void removeCategory(int categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

    @Override
    public Category getCategoryById(int catId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY_BY_ID,
                    new CategoriesMapper(), catId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CATEGORIES, new CategoriesMapper());
    }

}
