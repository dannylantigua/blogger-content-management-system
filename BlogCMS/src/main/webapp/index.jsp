<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">    
        <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">    
    </head>
    <body class="index">
        <div class="bg-index">


            <div class="container">
                <div class="text-center" style="margin-top:160px;">
                    <div class="text-center title">
                        <h1 style="margin-bottom: 20px;">Content Managment System</h1>
                    </div>


                    <!--<a class="btn btn-primary" href="${pageContext.request.contextPath}/signUp" role="button">Sign Up</a>-->
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/login" role="button">Login</a>
                </div>

            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        </div>
    </body>
</html>

