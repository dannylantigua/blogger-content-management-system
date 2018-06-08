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
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">      
        <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">    
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light" >

            <a class="navbar-brand" href="${pageContext.request.contextPath}/homepage">Company Logo</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/allBlogs">All Blog Posts</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/contact">contact</a>
                    </li>
                </ul>
                <span class="navbar-text">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary" role="button" aria-pressed="true">Dashboard</a>
                    </c:if>
                </span>
            </div>
        </nav>

        <!--content-->

        <div class="container">

            <div style="margin-top: 100px;">
                <h1>${currentPost.postTitle} </h1>
                <h4>${currentPost.postDate}</h4>
                <hr>

                ${currentPost.postBody}


                <sec:authorize access="hasRole('ROLE_ADMIN')"> 
                    <hr>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                        Delete post
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Post deletion</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Are you sure you want to delete your post?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/deletePost?currentPost=${currentPost.recordId}" role="button">Delete Post</a>
                                </div>
                            </div>
                        </div>
                    </div>

                </sec:authorize>
            </div>

        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
