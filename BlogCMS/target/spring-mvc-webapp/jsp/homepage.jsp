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

        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/homepage">Company Logo</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li <!--class="active"--><a href="${pageContext.request.contextPath}/allBlogs">All Blogs <span class="sr-only">(current)</span></a></li>
                        <li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>


                    </ul>
                    <form class="navbar-form navbar-right">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Dashboard</a>
                        </c:if>
                    </form>


                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>


        <!--content-->

        <div class="container">

            <div class="main-content">
                <div class="left-main-content">
                    <a href="${pageContext.request.contextPath}/displayChosenBlogPost?currentPostId=${latestPosts.get(0).recordId}">
                        <div class="container add-margin-padding-main">
                            <h1><span class="add-overflow-main">${latestPosts.get(0).postTitle}</span></h1>
                            <h4><span class="add-overflow-main">${latestPosts.get(0).postBody}</span></h4>
                        </div>
                    </a>

                </div>
                <div class="right-main-content">

                    <a href="${pageContext.request.contextPath}/displayChosenBlogPost?currentPostId=${latestPosts.get(1).recordId}">    
                        <div class="top-content add-padding-side-content">



                            <h4><span class="add-overflow-main2">${latestPosts.get(1).postTitle}</span></h4>
                            <h6><span class="add-overflow-main2">${latestPosts.get(1).postBody}</span></h6>

                        </div>

                    </a>
                    <a href="${pageContext.request.contextPath}/displayChosenBlogPost?currentPostId=${latestPosts.get(2).postTitle}">  

                        <div class="bottom-content">


                            <h4><span class="add-overflow-main2">${latestPosts.get(2).postTitle}</span></h4>
                            <h6><span class="add-overflow-main2">${latestPosts.get(2).postBody}</span></h6>



                        </div>

                    </a>


                </div>
                <div class="profile">

                    <div style="display:block; margin: 50px 32%;" >
                        <div style="padding:50px;border-radius:400px;background:grey;width:1%;"></div>
                    </div>
                    <div class="social-media-links ">
                        <p>Facebook</p>

                        <p>twitter</p>

                        <p>whateevr</p>
                    </div>


                </div>




            </div>
        </div>






        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
