/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogcms.serviceImpl;

import com.sg.blogcms.dao.StaticPagesDao;
import com.sg.blogcms.model.StaticPages;
import com.sg.blogcms.service.StaticPagesService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dannylantigua
 */
public class StaticPagesServiceImpl implements StaticPagesService {

    StaticPagesDao dao;

    public StaticPagesServiceImpl(StaticPagesDao dao) {
        this.dao = dao;
    }

    @Override
    public StaticPages addNewStaticPage(StaticPages page, String path) {
        dao.addNewStaticPage(page);
//        try {
//            createNewFileForPages(page, path);
//        } catch (IOException ex) {
//            Logger.getLogger(StaticPagesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return page;
    }

    @Override
    public void updateStaticPage(StaticPages page) {
        dao.updateStaticPage(page);
    }

    @Override
    public void removeStaticPage(int pageId) {
        dao.removeStaticPage(pageId);
    }

    @Override
    public StaticPages getStaticPageById(int pageId) {
        return dao.getStaticPageById(pageId);
    }

    @Override
    public List<StaticPages> getAllStaticPages() {
        return dao.getAllStaticPages();
    }

//    private void createNewFileForPages(StaticPages page, String path)
//            throws FileNotFoundException, IOException {
//
//        String data = "<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>\n"
//                + "<%@ taglib prefix=\"s\" uri=\"http://www.springframework.org/tags\"%>\n"
//                + "<%@ taglib prefix=\"fmt\" uri=\"http://java.sun.com/jsp/jstl/fmt\"%>\n"
//                + "<%@ taglib prefix=\"sec\" uri=\"http://www.springframework.org/security/tags\" %>\n"
//                + "<%@page contentType=\"text/html\" pageEncoding=\"windows-1252\"%>\n"
//                + "<!DOCTYPE html>\n"
//                + "<html>\n"
//                + "    <head>\n"
//                + "        <title>Index Page</title>\n"
//                + "        <!-- CSS Libraries -->\n"
//                + "        <jsp:include page=\"${request.contextPath}/jsp/csslibraries.jsp\"></jsp:include>"
//                + "    </head>\n"
//                + "    <body>\n"
//                + ""
//                + ""
//                + ""
//                + "<!--  NAVVVV -->"
//                + "<!-- Nav Bar -->\n"
//                + "<jsp:include page=\"${request.contextPath}/jsp/navigationBar2.jsp\"></jsp:include>"
//                + ""
//                + ""
//                + "<div class=\"container\">"
//                + ""
//                + "<div style=\"margin-top: 100px;\">\n"
//                + "                <h1>${currentPage.pageTitle} </h1>\n"
//                + "                <hr>\n"
//                + "\n"
//                + "                ${currentPage.content}"
//                + ""
//                + "</div>"
//                + ""
//                + "<!-- JavaScript Libraries -->\n"
//                + "<jsp:include page=\"${request.contextPath}/jsp/jslibraries.jsp\"></jsp:include>"
//                + "    </body>\n"
//                + "</html>\n"
//                + "";
//
//        FileOutputStream out = new FileOutputStream(path + "//" + page.getPageName() + ".jsp");
//        out.write(data.getBytes());
//        out.close();
//    }

}
