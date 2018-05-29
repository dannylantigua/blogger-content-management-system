/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.mappers;

import com.sg.blogcms.model.Entity;
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
            currentEntityFromRow.setFirstName(rs.getString("FirstName"));
            currentEntityFromRow.setLastName(rs.getString("LastName"));
            currentEntityFromRow.setEmail(rs.getString("EMAIL"));
            currentEntityFromRow.setPhoneNumber(rs.getString("PhoneNumber"));
            currentEntityFromRow.setUserName(rs.getString("AboutMe"));
            currentEntityFromRow.setPassword(rs.getString("passwd"));
            currentEntityFromRow.setIsAdmin(rs.getBoolean("isAdmit"));
            return currentEntityFromRow;
        }

    }
}
