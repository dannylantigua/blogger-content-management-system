<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="main-bg">
    <head>
        <title>DASHBOARD</title>
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
                </ul>
            </div>
        </nav>
            <!-- end of Nav Bar -->

        <div class="container mt-5">
            <div class="row">
                <div class="col-md-3">
                    <div class="card card-profile">
<!--                        <div class="card-avatar">
                            <a href="#">
                                <img class="img" src="${pageContext.request.contextPath}/images/faces/marc.jpg" />
                            </a>
                        </div>-->
                        <div class="card-body">
                            <h6 class="card-category text-gray"> ${username }</h6>
                            <h4 class="card-title"> ${firstname} ${lastname}</h4>
                            <p class="card-description">
                                ${aboutme}
                            </p>

                            <a class="btn btn-primary btn-round" href="<c:url value="j_spring_security_logout" />" >Logout</a>

                        </div>
                    </div>
                </div>
                <div class="col-md-9">


                    <div class="btn-group btn-group-justified" role="group" aria-label="...">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/editProfile"role="button">Edit Profile</a>
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/createPost"role="button">Create Blog Post</a>

                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#categoryModal" role="button">Add Category</a>
                            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#staticPagesModal" role="button">Add Static Page</a>
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/adminSettings"role="button">Admin Settings</a>
                        </sec:authorize>
                    </div>


                    <!-- DASHBOARD ELEMENTS -->

                    <div class="row">

                        <!-- categories -->
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="col-lg-6 col-md-12">
                                <div class="card">
                                    <div class="card-header card-header-info">
                                        <h4 class="card-title">Categories</h4>
                                    </div>
                                    <div class="card-body table-responsive">
                                        <table class="table table-hover">
                                            <thead class="text-info">
                                            <th>ID</th>
                                            <th>Category</th>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="currentCat" items="${catList}">
                                                    <tr>
                                                        <td><c:out value="${currentCat.recordId}"/></td>
                                                        <td><c:out value="${currentCat.categoryDesc}"/></td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/deleteCategory?catId=${currentCat.recordId}" class="pr-3">Delete</a>
                                                            <a href="${pageContext.request.contextPath}/displayEditCategory?catId=${currentCat.recordId}">Edit</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                <tr>


                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                         
                        </sec:authorize>


                        <!-- recent posts -->
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-header card-header-warning card-header-icon">
                                    <div class="card-icon">
                                        <i class="material-icons">content_copy</i>
                                    </div>
                                    <p class="card-category">Posts By Me</p>
                                    <h3 class="card-title">${postCount} Post/s
                                    </h3>
                                </div>
                                <div class="card-footer">
                                </div>
                            </div>
                        </div>


                        <!-- Static Pages -->
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="col-lg-6 col-md-12">
                                <div class="card">
                                    <div class="card-header card-header-success">
                                        <h4 class="card-title">Static Pages</h4>
                                    </div>
                                    <div class="card-body table-responsive">
                                        <table class="table table-hover">
                                            <thead class="text-success">
                                            <th>ID</th>
                                            <th>Page Name</th>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="currentPage" items="${pagesList}">
                                                    <tr>
                                                        <td><c:out value="${currentPage.recordId}"/></td>
                                                        <td><c:out value="${currentPage.pageName}"/></td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/deletePage?pageId=${currentPage.recordId}" class="pr-3">Delete</a>
                                                            <a href="${pageContext.request.contextPath}/displayEditPage?pageId=${currentPage.recordId}">Edit</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </sec:authorize>


                        <!-- recent tags -->
                        <div class="col-lg-6 col-md-12">
                            <div class="card">
                                <div class="card-header card-header-warning">
                                    <h4 class="card-title">Recent Tags</h4>
                                </div>
                                <div class="card-body table-responsive">
                                    <table class="table table-hover">
                                        <thead class="text-warning">
                                        <th>PostID</th>
                                        <th>Tag</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="currenTag" items="${tagList}">
                                                <tr>
                                                    <td><c:out value="${currenTag.postId}"/></td>
                                                    <td><c:out value="${currenTag.tag}"/></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>


                <!-- Modal For Categories -->

                <div class="modal fade" id="categoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">New Category</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form class="form-horizontal" 
                                  role="form" method="POST" 
                                  action="addNewCategory">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="bmd-label-floating" for="username">Category: </label>
                                        <input type="text" class="form-control" id="categoryName" name="categoryName" 
                                               required>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary pr-3" data-dismiss="modal">Close</button>
                                    <input type="submit" class="btn btn-primary pl-2" value="SAVE"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <!-- Modal For Static Pages -->

                <div class="modal fade bd-example-modal-lg" id="staticPagesModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">New Static Page</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form class="form-horizontal" 
                                  role="form" method="POST" 
                                  action="saveNewPage">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="bmd-label-floating" for="pageName">Page Name: </label>
                                        <input type="text" class="form-control" id="pageName" name="pageName" 
                                               required>
                                    </div>

                                    <div class="form-group">
                                        <label class="bmd-label-floating" for="pageTitle">Page Title: </label>
                                        <input type="text" class="form-control" id="pageTitle" name="pageTitle" 
                                               required>
                                    </div>

                                    <div class="form-group">
                                        <label class="bmd-label-floating" for="content">Content: </label>
                                        <textarea id="content" name="content" required> </textarea>
                                        <input type="text" class="form-control" id="path" name="path" 
                                               hidden value="${pageContext.request.contextPath}"/>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary pr-3" data-dismiss="modal">Close</button>
                                    <input type="submit" class="btn btn-primary pl-2" value="SAVE"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <!-- end of row -->
            </div>
            <!-- end of container -->
        </div>

                                    <!--GETTING RID OF ANNOYING POPUPS FROM MCU-->
                                    <style>
                                        .mce-notification-inner {
                                            display:none;
                                        }
                                        
                                        #mceu_31 {
                                            display:none;
                                        }
                                    </style>
                                    
        <script src='https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=scmd53yww1lj74aj6vs54kvv2d5zj06bxs2snlu2l51l0835'></script>
        <script>tinymce.init({selector: "textarea",
                themes: "modern"});</script>
         <!--JavaScript Libraries--> 
        <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>
    </body>
</html>

