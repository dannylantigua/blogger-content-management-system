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
        <!-- CSS Libraries -->
        <jsp:include page="${request.contextPath}/jsp/csslibraries.jsp"></jsp:include>
        </head>
        <body>

            <!-- Nav Bar -->
        <jsp:include page="${request.contextPath}/jsp/navigationBar.jsp"></jsp:include>

            <div class="container m">
                <div class="row">



                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header card-header-primary">
                                <h4 class="card-title">Edit Profile</h4>
                                <p class="card-category">Complete your profile</p>
                            </div>
                            <div class="card-body">
                                <form role="form" action="updateUser" method="POST">
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
                                            <label class="bmd-label-floating" for="aboutme">About Me</label>
                                            <input type="text" class="form-control" id="aboutme" name="aboutme" required>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="bmd-label-floating" for="phone">Phone Number : ( ${user.lastName} )</label>
                                            <input type="tel" class="form-control" id="phone" name="phone" required>
                                        </div>
                                    </div>
                                </div>

                                <!--<a class="btn btn-primary" href="${pageContext.request.contextPath}/dashboard"role="button">Back to dashboard</a>-->
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
           <!-- JavaScript Libraries -->
        <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>
    </body>
</html>
