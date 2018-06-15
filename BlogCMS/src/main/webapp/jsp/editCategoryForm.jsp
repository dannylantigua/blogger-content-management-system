<%-- 
    Document   : editCategoryForm
    Created on : Jun 13, 2018, 9:36:09 AM
    Author     : dannylantigua
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Category</title>
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
        

            <div class="container m">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header card-header-primary">
                                <h4 class="card-title">Edit Category</h4>
                            </div>
                            <div class="card-body">
                            <sf:form class="form-horizontal" role="form" modelAttribute="category"
                                     action="updateCategory" method="POST">

                                <div class="form-group">
                                    <div class="col-md-12 p-0">
                                        <label for="cat" class="col-md-4 control-label">Category: </label>
                                    </div>
                                    <div class="col-md-8">
                                        <sf:input type="text" class="form-control" id="cat"
                                                  path="categoryDesc"/>
                                        <sf:errors path="categoryDesc" cssclass="error"></sf:errors>
                                        <sf:hidden path="recordId"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <input type="submit" class="btn btn-primary" value="UPDATE CATEGORY"/>
                                    </div>
                                </div>


                            </sf:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- JavaScript Libraries -->
        <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>
    </body>
</html>
