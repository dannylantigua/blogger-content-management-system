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
        <!--<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">-->  

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

        <div class="container">

            <!--            <div style="display:flex;">
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

</div>-->

            <hr>

            <!DOCTYPE html>

            <script src='https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=scmd53yww1lj74aj6vs54kvv2d5zj06bxs2snlu2l51l0835'></script>
            <script>tinymce.init({selector: 'textarea'});</script>

            <form>

                <div class="row">

                    <div class="col-md-12">
                        <div class="form-group">
                            <textarea class="form-control">Input your post here!</textarea>
                            
                        </div>
                    </div>

                </div>

            </form>


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
