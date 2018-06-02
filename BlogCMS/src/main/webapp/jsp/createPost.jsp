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

                <div class="container">

        <div style="display:flex;">
            <div style="padding:50px;border-radius:400px;background:grey;width:1%;"></div>
            <div style="padding-top:20px">
                <ul style="list-style:none;">
                    <li>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <p> Hello .. 
                                ${pageContext.request.userPrincipal.name}
                                <a href="<c:url value="j_spring_security_logout" />" >( Logout )</a>

                            </p>
                        </c:if>
                    </li>

                    <li>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <p>  ${firstname} ${lastname} </p>
                        </c:if>
                    </li>

                    <li>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <p>${email}</p>
                        </c:if>
                    </li>
                </ul>
            </div>

        </div>

        <hr>
        
        <!DOCTYPE html>

  <script src='https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=scmd53yww1lj74aj6vs54kvv2d5zj06bxs2snlu2l51l0835'></script>
  <script>tinymce.init({ selector:'textarea' });</script>

  <textarea>Input your post here!</textarea>


</div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
