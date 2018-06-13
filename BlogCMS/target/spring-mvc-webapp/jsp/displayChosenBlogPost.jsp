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
        <title>Current Post</title>
        <!-- CSS Libraries -->
        <jsp:include page="${request.contextPath}/jsp/csslibraries.jsp"></jsp:include>
        </head>
        <body>

            <!-- Nav Bar -->
            <jsp:include page="${request.contextPath}/jsp/navigationBar2.jsp"></jsp:include>

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

                    <!--update button-->

                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/updatePost?currentId=${currentPost.recordId}" role="button">Update</a>


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
        <!-- JavaScript Libraries -->
        <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>
    </body>
</html>
