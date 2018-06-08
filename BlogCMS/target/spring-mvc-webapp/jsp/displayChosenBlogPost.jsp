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
        <!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">-->

        <!-- For the Template 
        ////////////////////////////////////////////////////////////////
        -->
        <!--     Fonts and icons     -->
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/templatecss/material-dashboard.css?v=2.0.0">
        <!-- Documentation extras -->
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="${pageContext.request.contextPath}/assets-for-demo/demo.css" rel="stylesheet" />
        <!-- iframe removal -->



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
                </ul>
                <span class="navbar-text pr-5">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-primary text-light" role="button" aria-pressed="true">Dashboard</a>
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
        <!--
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>-->



        <script src="${pageContext.request.contextPath}/js/templatejs/core/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/templatejs/core/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/templatejs/bootstrap-material-design.js"></script>
        <script src="${pageContext.request.contextPath}/js/templatejs/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!--  Charts Plugin, full documentation here: https://gionkunz.github.io/chartist-js/ -->
        <script src="${pageContext.request.contextPath}/js/templatejs/plugins/chartist.min.js"></script>
        <!-- Library for adding dinamically elements -->
        <script src="${pageContext.request.contextPath}/js/templatejs/plugins/arrive.min.js" type="text/javascript"></script>
        <!--  Notifications Plugin, full documentation here: http://bootstrap-notify.remabledesigns.com/    -->
        <script src="${pageContext.request.contextPath}/js/templatejs/plugins/bootstrap-notify.js"></script>
        <!-- Material Dashboard Core initialisations of plugins and Bootstrap Material Design Library -->
        <script src="${pageContext.request.contextPath}/js/templatejs/material-dashboard.js?v=2.0.0"></script>
        <!-- demo init -->
        <script src="${pageContext.request.contextPath}/js/templatejs/plugins/demo.js"></script>





    </body>
</html>
