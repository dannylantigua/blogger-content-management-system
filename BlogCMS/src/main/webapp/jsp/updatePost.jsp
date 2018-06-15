<%-- 
    Document   : homepage
    Created on : May 31, 2018, 8:41:32 AM
    Author     : kmlnd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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

        <!--content-->

        <div class="container">

            <!--            <div class="card">-->
            <div style="padding:100px;">
                <span class="badge badge-dark" style="margin-bottom: 20px;">${currentCategory.categoryDesc}</span>
            <h1>${post.postTitle} </h1>
            <h4>${post.postDate}</h4>
            <hr>

            ${post.postBody}
        </div>


        <!--
        
            REFERENCE FOR EDIT POST
        
            private int recordId;
            private String postTitle;
            private String postBody;
            private int userId;
            private Date postDate;
            private Date expireDate;
            private int likes;
            private boolean isRejected;
            private boolean isApproved;
            private boolean isPending;
            private List<postsTags> postTags;-->



        <div class="card">
            <div class="card-header card-header-primary">
                <h4 class="card-title">Edit ${post.postTitle} Post</h4>
            </div>
        </div>

        <sf:form role="form" method="POST" action="submitUpdatedPost" modelAttribute="post">

            <div class="form-group">



                <label class="bmd-label-floating" for="postTitle"> Title </label>
                <sf:input type="text" path="postTitle" class="form-control" id="postTitle" />
            </div>

            <!--
                            <div class="form-group">
                                <label for="exampleFormControlSelect1">Select a Category</label>
                                <select class="form-control" name="chooseCategory" id="exampleFormControlSelect1">
            <c:forEach var="category" items="${cList}">
                <option value="${category.recordId}"><c:out value="${category.categoryDesc}"/></option>
            </c:forEach>


        </select>
    </div>-->

            <div class="form-group">
                <label for="exampleFormControlSelect1">Select a Category</label>
                <select class="form-control" name="chooseCategory" id="exampleFormControlSelect1">
                    <c:forEach var="category" items="${cList}">
                        <option value="${category.recordId}"><c:out value="${category.categoryDesc}"/></option>
                    </c:forEach>


                </select>
            </div>

            <textarea name="postBody" class="form-control"></textarea>
            <script src='https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=scmd53yww1lj74aj6vs54kvv2d5zj06bxs2snlu2l51l0835'></script>
            <script>tinymce.init({selector: 'textarea'});</script>
            
            <!--Here is the code in order to display tags from the database-->

            <div class="form-group">
                <label for="exampleFormControlSelect2">Select Tags</label>
                <select multiple class="form-control"  name="chooseTags" id="exampleFormControlSelect2">
                    <c:forEach var="currentTag" items="${tagList}">
                        <option class="badge badge-dark" value="${currentTag.tag}"><c:out value="${currentTag.tag}"/></option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary pull-right">Save</button>

            <div class="clearfix"></div>
            <sf:hidden path="recordId"/>
        </sf:form>



    </div>
    <!-- JavaScript Libraries -->
    <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>
</body>
</html>
