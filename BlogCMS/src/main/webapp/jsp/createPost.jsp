<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Post</title>
        <!-- CSS Libraries -->
        <jsp:include page="${request.contextPath}/jsp/csslibraries.jsp"></jsp:include>

        </head>
        <body>

            <!-- Nav Bar -->
        <jsp:include page="${request.contextPath}/jsp/navigationBar.jsp"></jsp:include>

            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-primary">
                                <h4 class="card-title">Create New Post</h4>
                            </div>
                            <div class="card-body">


                                <div class="form-group">
                                    <textarea class="form-control tinymce">Input your post here!</textarea>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <script src='https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=scmd53yww1lj74aj6vs54kvv2d5zj06bxs2snlu2l51l0835'></script>
            <script>tinymce.init({selector: "textarea.tinymce",
                    themes: "modern"});</script>

            <!-- JavaScript Libraries -->
        <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>
    </body>
</html>
