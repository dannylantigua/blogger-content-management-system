<%-- 
    Document   : homepage
    Created on : May 31, 2018, 8:41:32 AM
    Author     : kmlnd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- CSS Libraries -->
        <jsp:include page="${request.contextPath}/jsp/csslibraries.jsp"></jsp:include>
        </head>
        <body>

           <!-- Nav Bar -->
        <jsp:include page="${request.contextPath}/jsp/NavBarTop.jsp"></jsp:include>
        <c:forEach var="currentPageN" items="${pagesList}">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/displayStaticPage?pageId=${currentPageN.recordId}">
                ${currentPageN.pageTitle}</a>
        </li>
        </c:forEach>
        <jsp:include page="${request.contextPath}/jsp/NavBarBottom.jsp"></jsp:include>

            <main role="main">

                <!-- Main jumbotron for a primary marketing message or call to action -->
                <div class="jumbotron">
                    <div class="container">
                        <!--category-->
                        <span class="badge badge-dark" style="margin-bottom:20px;">${mainCategory.categoryDesc}</span>

                    <h1 class="display-3">${latestPost.postTitle}</h1>
                    <p>${latestPost.postBody}</p>
                    <p><a class="btn btn-dark btn-lg" href="${pageContext.request.contextPath}/displayChosenBlogPost?currentPostId=${latestPost.recordId}" role="button">Learn more &raquo;</a></p>
                </div>
            </div>

            <div class="container">
                <!-- Example row of columns -->
                <div class="row">

                    <c:forEach var="post" items="${posts}">





                        <div class="col-md-4">
                            <c:forEach var="cat" items="${categories}">
                                <!--category-->
                                <c:if test="${post.categoryId == cat.recordId}">


                                    <span class="badge badge-dark" style="margin-bottom:20px;"><c:out value="${cat.categoryDesc}"/></span>
                                </c:if>
                            </c:forEach>
                            <h2><c:out value="${post.postTitle}"></c:out></h2>
                            <p>${post.postBody}</p>
                            <p><a class="btn btn-secondary" href="${pageContext.request.contextPath}/displayChosenBlogPost?currentPostId=${post.recordId}" role="button">View details &raquo;</a></p>
                        </div>

                    </c:forEach>

                </div>

                <hr>

            </div> <!-- /container -->

        </main>

        <footer class="container">
            <p>&copy; Company 2017-2018</p>
        </footer>

        <!-- JavaScript Libraries -->
        <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>
    </body>
</html>
