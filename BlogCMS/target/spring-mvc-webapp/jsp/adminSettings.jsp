<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Settings</title>
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


        <div class="col-lg-6 col-md-12">
            <div class="card">
                <div class="card-header card-header-warning">
                    <h4 class="card-title">Social Media</h4>
                </div>
                <div class="card-body table-responsive">
                    <table>
                        <thead class="text-warning">
                        <th>Social Media Name</th>
                        <th> URL </th>
                        </thead>
                        <tbody>
                            <c:forEach var="currentS" items="${socials}">
                                <tr>

                                    <td><c:out value="${currentS.websiteName}"/></td>
                                    <td><a href="${currentS.webSite}"><c:out value="${currentS.webSite}"/></a></td>
                                    <!--<td>-->  


                                </tr>
                             
                            </c:forEach>
                                
                                <!--WORK IN PROGRESS-->
                                
<!--                                   <tr>
                                    <td>
                                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/removeSocial" role="button">Remove All Social Media By Current User</a>
                                    </td>
                                </tr>-->
                        </tbody>

                        <hr>
                        <form role="form" method="POST" action="createSocialMedia" >
                            <tr>




                                <td>
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="socialName" name="socialName" placeholder="Add Social Media Name" required>
                                    </div>
                                </td>
                                <td>

                                    <div class="col-sm-12">
                                        <input type="text" class="form-control" id="socialURL" name="socialURL" placeholder="Add URL" required>
                                    </div>

                                </td>



                                <td>
                                    <button type="submit" class="btn btn-primary pull-right">Save</button>
                                </td>


                            </tr>
                        </form>



                </div>
            </div>
        </div>
    </table>
</div>

<!-- JavaScript Libraries -->
        <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>

</body>
</html>
