<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
<!--        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  -->

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
                <span class="navbar-text pr-5">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <a class="btn btn-primary text-light" href="${pageContext.request.contextPath}/dashboard"role="button">Back to dashboard</a>
                    </c:if>
                </span>
            </div>
        </nav>
                    

        <div class="container mt-5">

            <h3 class="pl-5">
                Admin Settings
            </h3>



            <hr>


            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header card-header-success">
                        <h4 class="card-title">Admins</h4>
                    </div>
                    <div class="card-body table-responsive">
                        <table class="table table-hover">
                            <thead class="text-success">
                            <th>UserName</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Remove Account</th>
                            </thead>
                            <tbody>
                                <c:forEach var="currentEntity" items="${listOfEntities}">

                                    <tr>
                                        <td><c:out value="${currentEntity.userName}"/></td>
                                        <td><c:out value="${currentEntity.firstName}"/></td>
                                        <td><c:out value="${currentEntity.lastName}"/></td>
                                        <td>
                                            <c:if test="${pageContext.request.userPrincipal.name != currentEntity.userName}">
                                                <a href="deleteUserAsAdmin?userId=${currentEntity.recordId}"> delete </a>

                                            </c:if>
                                            <c:if test="${pageContext.request.userPrincipal.name == currentEntity.userName}">
                                                <b>Current User</b>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${pageContext.request.userPrincipal.name != currentEntity.userName}">
                                                <a href="removeAdminRole?userId=${currentEntity.recordId}"> Remove Admin Role </a>
                                            </c:if>
                                        </td>


                                    </tr>


                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>


            <br>

            <hr>

            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header card-header-info">
                        <h4 class="card-title">Users</h4>
                    </div>
                    <div class="card-body table-responsive">
                        <table class="table table-hover">
                            <thead class="text-info">
                            <th>UserName</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Remove Account</th>
                            </thead>
                            <tbody>
                                <c:forEach var="currentUser" items="${users}">

                                    <tr>
                                        <td><c:out value="${currentUser.userName}"/></td>
                                        <td><c:out value="${currentUser.firstName}"/></td>
                                        <td><c:out value="${currentUser.lastName}"/></td>
                                        <td>
                                            <c:if test="${pageContext.request.userPrincipal.name != currentUser.userName}">
                                                <a href="deleteUserAsAdmin?userId=${currentUser.recordId}"> delete </a>
                                            </c:if>
                                            <c:if test="${pageContext.request.userPrincipal.name == currentUser.userName}">
                                                <b>Current User</b>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${pageContext.request.userPrincipal.name != currentUser.userName}">
                                                <a href="promoteUserRole?userId=${currentUser.recordId}"> Promote Role To Admin </a>
                                            </c:if>
                                        </td>


                                    </tr>


                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>




            Company Settings
        </h1>

        <p>form and add logo for company goes here</p>















        <div class="col-md-8">
            <div class="card">
                <div class="card-header card-header-primary">
                    <h4 class="card-title">Sign Up A User</h4>
                </div>
                <div class="card-body">
                    <form role="form" method="POST" action="createUser">
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
<!--                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating" for="retypePassword">Retype Password</label>
                                    <input type="password" class="form-control" id="retypePassword" name="password-repeat" required>
                                </div>
                            </div>-->
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating" for="phone">Phone Number : ( ${user.lastName} )</label>
                                    <input type="tel" class="form-control" id="phone" name="phone" required>
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary pull-right">Save</button>

                        <div class="clearfix"></div>
                    </form>
                </div>
            </div>
        </div>











        <hr>

<!--        <h1>Sign Up a User</h1>-->
<!--
        <form role="form" method="POST" action="createUser">
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email" placeholder="Enter email">
            </div>
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
            </div>
            <div class="form-group">
                <label for="first">First Name</label>
                <input type="text" class="form-control" id="first" name="firstname" placeholder="First Name" required>
            </div>
            <div class="form-group">
                <label for="last">Last Name</label>
                <input type="text" class="form-control" id="last" name="lastname" placeholder="Last Name" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
            </div>
                            <div class="form-group">
                                <label for="retypePassword">Retype Password</label>
                                <input type="password" class="form-control" id="retypePassword" name="password-repeat" placeholder="Password" required>
                            </div>
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone Number" required>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>-->

       

        
    </div>


    <!-- Placed at the end of the document so the pages load faster -->
<!--    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
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
