/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.daoImpl;

import com.sg.blogcms.dao.StaticPagesDao;
import com.sg.blogcms.mappers.Mappers.StaticPagesMapper;
import com.sg.blogcms.model.StaticPages;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author dannylantigua
 */
public class StaticPagesDaoDbImpl implements StaticPagesDao {

    // creating jdbc template and storing it
    JdbcTemplate jdbcTemplate;

    //using setter injection to set the template
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_PAGE
            = "insert into StaticPages (PageName, pageTitle, Content) "
            + "values (?, ?, ?)";
    private static final String SQL_DELETE_PAGE
            = "delete from StaticPages where recordId = ?";
    private static final String SQL_SELECT_PAGE_BY_ID
            = "select * from StaticPages where recordId = ?";
    private static final String SQL_UPDATE_PAGE
            = "update StaticPages set "
            + "PageName = ?, pageTitle = ?, Content = ? "
            + "where recordId = ?";
    private static final String SQL_SELECT_ALL_PAGES
            = "select * from StaticPages";

    @Override
    public StaticPages addNewStaticPage(StaticPages page) {
        jdbcTemplate.update(SQL_INSERT_PAGE,
                page.getPageName(),
                page.getPageTitle(),
                page.getContent());

        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        page.setRecordId(newId);
        return page;
    }

    @Override
    public void updateStaticPage(StaticPages page) {
        jdbcTemplate.update(SQL_UPDATE_PAGE,
                page.getPageName(),
                page.getPageTitle(),
                page.getContent(),
                page.getRecordId());
    }

    @Override
    public void removeStaticPage(int pageId) {
        jdbcTemplate.update(SQL_DELETE_PAGE, pageId);
    }

    @Override
    public StaticPages getStaticPageById(int pageId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PAGE_BY_ID,
                    new StaticPagesMapper(), pageId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<StaticPages> getAllStaticPages() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PAGES, new StaticPagesMapper());
    }

}
