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
<!--content-->

<div class="container">

    <c:forEach var="post" items="${postsByTag}">
        <br>
        <div class="card" >
            <div class="card-body" >



                <a href="${pageContext.request.contextPath}/displayChosenBlogPost?currentPostId=${post.recordId}" style="color:black; text-decoration:none;">
                    <div class="post">



                        <span class="add-overflow"><h1> <c:out value="${post.postTitle}"></c:out></h1></span>
                        <span class="add-overflow">${post.postBody}</span>
                    </div> 
                </a>
            </div>
        </div>
        <br>
    </c:forEach>

</div>


<!-- JavaScript Libraries -->
<jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>
</body>
</html>
