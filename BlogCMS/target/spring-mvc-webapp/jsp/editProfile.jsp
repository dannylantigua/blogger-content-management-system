<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
<!-- <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">    -->

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
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/contact">contact</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container m">
            <div class="row">



                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header card-header-primary">
                            <h4 class="card-title">Edit Profile</h4>
                            <p class="card-category">Complete your profile</p>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="bmd-label-floating" for="username">Username : ( ${user.userName} )</label>
                                            <input type="text" class="form-control" id="username" name="username" required>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="bmd-label-floating" for="email">Email address : ( ${user.email} )</label>
                                            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="bmd-label-floating" for="first">First Name : ( ${user.firstName} )</label>
                                            <input type="text" class="form-control" id="first" name="firstname" required>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="bmd-label-floating" for="last">Last Name : ( ${user.lastName} )</label>
                                            <input type="text" class="form-control" id="last" name="lastname" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Password</label>
                                            <input type="password" class="form-control" id="password" name="password" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="bmd-label-floating" for="retypePassword">Retype Password</label>
                                            <input type="password" class="form-control" id="retypePassword" name="password-repeat" required>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="bmd-label-floating" for="phone">Phone Number : ( ${user.lastName} )</label>
                                            <input type="tel" class="form-control" id="phone" name="phone" required>
                                        </div>
                                    </div>
                                </div>

                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/dashboard"role="button">Back to dashboard</a>
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                                    Delete your account
                                </button>

                                <button type="submit" class="btn btn-primary pull-right">Update Profile</button>

                                <div class="clearfix"></div>
                            </form>
                        </div>
                    </div>
                </div>


                <!--UPDATE ACCOUNT INFORMATION-->

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Account deletion</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Are you sure you want to delete your account?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteUser" role="button">Delete Account</a>
                            </div>
                        </div>
                    </div>
                </div>



            </div>
            <!-- Placed at the end of the document so the pages load faster -->
    <!--        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>-->


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
