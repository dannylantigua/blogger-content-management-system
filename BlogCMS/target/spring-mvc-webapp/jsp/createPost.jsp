<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Post</title>
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

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header card-header-primary">
                            <h4 class="card-title">Create New Post</h4>
                        </div>
                        <div class="card-body">

                            <form role="form" action="submitPost" method="POST">

                                <div class="form-group">
                                    <label class="bmd-label-floating" for="postTitle"> Title </label>
                                    <input type="text" name="postTitle" class="form-control" id="postTitle" />
                                </div>

                                <div class="form-group">
                                    <textarea name="postBody" class="form-control tinymce">Input your post here!</textarea>
                                </div>

                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">Select a Category</label>
                                    <select class="form-control" name="chooseCategory" id="exampleFormControlSelect1">
                                    <c:forEach var="category" items="${cList}">
                                        <option value="${category.recordId}"><c:out value="${category.categoryDesc}"/></option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="exampleFormControlSelect2">Select Tags</label>
                                <select multiple class="form-control"  name="chooseTags" id="exampleFormControlSelect2">
                                <c:forEach var="currentTag" items="${tagList}">
                                    <option class="badge badge-dark" value="${currentTag.tag}"><c:out value="${currentTag.tag}"/></option>
                                </c:forEach>
                                </select>
                            </div>



                            <button type="submit" class="btn btn-primary pull-right">Save</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>







    </div>

    <!--JQUERY-->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>

    <!--SCRIPT FOR JAVASCRIPT FILE-->
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.12/jquery-ui.min.js" type="text/javascript" charset="utf-8"></script>




    <script src='https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=scmd53yww1lj74aj6vs54kvv2d5zj06bxs2snlu2l51l0835'></script>
    <script>tinymce.init({selector: "textarea.tinymce",
            themes: "modern"});</script>

    <!-- JavaScript Libraries -->
    <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>
</body>
</html>
