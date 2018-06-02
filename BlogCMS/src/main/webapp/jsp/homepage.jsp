<%-- 
    Document   : homepage
    Created on : May 31, 2018, 8:41:32 AM
    Author     : kmlnd
--%>
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
        <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">    
    </head>
    <body>

        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/homepage">Brand</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Link</a></li>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Dashboard</a></li>
                         </c:if>

                    </ul>
                    <form class="navbar-form navbar-right">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>


        <!--content-->

        <div class="container">

            <div class="main-content">
                <div class="left-main-content">
                    <div class="container">
                        <p>Category here (will fix structure and design later)</p>
                        <h1>Kennys Blog example heading</h1>
                        <p>O.O fjsdfhsdjhfkjshkfjhsjkfhjshfjhdjhsfj</p>
                    </div>

                </div>
                <div class="right-main-content">
                    <div class="top-content">
                        <div class="container">
                        <p>Category here (will fix structure and design later)</p>
                        <h1>Kennys Blog example heading</h1>
                        <p>O.O fjsdfhsdjhfkjshkfjhsjkfhjshfjhdjhsfj</p>
                    </div>
                    </div>
                    <div class="bottom-content">
                        <div class="container">
                        <p>Category here (will fix structure and design later)</p>
                        <h1>Kennys Blog example heading</h1>
                        <p>O.O fjsdfhsdjhfkjshkfjhsjkfhjshfjhdjhsfj</p>
                    </div>
                    </div>
                </div>




            </div>


            <div class="group-cards">


                <div class="card" style="width: 18rem;">
                    <img class="card-img-top card-img-size" src="https://cdn.gamerant.com/wp-content/uploads/pokemon-sun-moon-ash-pikachu.jpg.optimal.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Blog num</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>

                <div class="card" style="width: 18rem;">
                    <img class="card-img-top card-img-size" src="https://cdn.gamerant.com/wp-content/uploads/pokemon-sun-moon-ash-pikachu.jpg.optimal.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Blog num</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>

                <div class="card" style="width: 18rem;">
                    <img class="card-img-top card-img-size" src="https://cdn.gamerant.com/wp-content/uploads/pokemon-sun-moon-ash-pikachu.jpg.optimal.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Blog num</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>

                <div class="card" style="width: 18rem;">
                    <img class="card-img-top card-img-size" src="https://cdn.gamerant.com/wp-content/uploads/pokemon-sun-moon-ash-pikachu.jpg.optimal.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Blog num</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div>


        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
