<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
    </head>
    <body>

        <div class="container">

            <h1>
                Admin Settings
            </h1>



            <hr>


            <h2>Current Accounts</h2>
            <p>List is in no particular order</p>            
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>UserName</th>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Remove Account</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="currentEntity" items="${listOfEntities}">
                        <tr>
                            <td><c:out value="${currentEntity.userName}"/></td>
                            <td><c:out value="${currentEntity.firstName}"/></td>
                            <td><c:out value="${currentEntity.lastName}"/></td>
                            <td><a href="deleteUserAsAdmin?userId=${currentEntity.recordId}"> delete </a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


            Company Settings
        </h1>

        <p>form and add logo for company goes here</p>





        <hr>

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/dashboard"role="button">Back to dashboard</a>
    </div>


    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
