<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="main-bg">
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
            </div>
        </nav>

        <div class="container mt-5">
            <div class="row">
                <div class="col-md-3">
                    <div class="card card-profile">
                        <div class="card-avatar">
                            <a href="#pablo">
                                <img class="img" src="${pageContext.request.contextPath}/images/faces/marc.jpg" />
                            </a>
                        </div>
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

                        <a class="btn btn-primary" data-toggle="modal" data-target="#categoryModal" href="${pageContext.request.contextPath}/"role="button">Add Category</a>

                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/createNewStaticPage"role="button">Add Static Page</a>

                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/adminSettings"role="button">Admin Settings</a>
                        </sec:authorize>



                    </div>


                    <!-- DASHBOARD ELEMENTS -->


                    <div class="row">

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






                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                        <!-- recent posts -->
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-header card-header-warning card-header-icon">
                                    <div class="card-icon">
                                        <i class="material-icons">content_copy</i>
                                    </div>
                                    <p class="card-category">Recent Posts</p>
                                    <h3 class="card-title">12 Posts
                                    </h3>
                                </div>
                                <div class="card-footer">
                                </div>
                            </div>
                        </div>



                        <!-- categories -->
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
                                                        <a href="${pageContext.request.contextPath}/#" class="pr-3">Delete</a>
                                                        <a href="${pageContext.request.contextPath}/#">Edit</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                        <!-- Static Pages -->
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
                                                        <a href="${pageContext.request.contextPath}/#" class="pr-3">Delete</a>
                                                        <a href="${pageContext.request.contextPath}/#">Edit</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </div>


                </div>


                <!-- Modal -->

                <div class="modal fade" id="categoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">New Category</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label class="bmd-label-floating" for="username">Category: </label>
                                        <input type="text" class="form-control" id="category" name="category" required>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary pr-3" data-dismiss="modal">Close</button>
                                
                                <button type="button" class="btn btn-primary pl-2">SAVE</button>
                            </div>
                        </div>
                    </div>
                </div>



            </div>




            <!--
            <sec:authorize access="hasRole('ROLE_USER')">
                <p> Hi im a thing that can only be seen by users </p>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <p>Hi i can only be seen by admins</p>
            </sec:authorize> -->



        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <!--        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
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

