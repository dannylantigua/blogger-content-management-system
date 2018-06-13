<%-- 
    Document   : createStaticPage
    Created on : Jun 9, 2018, 9:26:04 AM
    Author     : dannylantigua
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Static Page</title>
        <!-- CSS Libraries -->
        <jsp:include page="${request.contextPath}/jsp/csslibraries.jsp"></jsp:include>

        </head>
        <body>

            <!-- Nav Bar -->
        <jsp:include page="${request.contextPath}/jsp/navigationBar.jsp"></jsp:include>

            <div class="container m">
                <div class="row">
                    <div class="col-md-10">
                        <div class="card">
                            <div class="card-header card-header-primary">
                                <h4 class="card-title">Edit Static Page</h4>
                            </div>
                            <div class="card-body">
                            <sf:form class="form-horizontal" role="form" modelAttribute="staticpage"
                                     action="updateStaticPage" method="POST">

                                <div class="form-group">
                                    <div class="col-md-12 p-0">
                                        <label for="pname" class="col-md-4 control-label">Page Name: </label>
                                    </div>
                                    <div class="col-md-8">
                                        <sf:input type="text" class="form-control" id="pname"
                                                  path="pageName"/>
                                        <sf:errors path="pageName" cssclass="error"></sf:errors>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-12 p-0">
                                            <label for="ptitle" class="col-md-4 control-label">Page Title: </label>
                                        </div>
                                        <div class="col-md-8">
                                        <sf:input type="text" class="form-control" id="ptitle"
                                                  path="pageTitle"/>
                                        <sf:errors path="pageTitle" cssclass="error"></sf:errors>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-12 p-0">
                                            <label for="pcontent" class="col-md-4 control-label">Content </label>
                                        </div>
                                        <div class="col-md-12">
                                        <sf:textarea class="form-control" id="pcontent"
                                                     path="content"></sf:textarea>
                                        <sf:errors path="content" cssclass="error"></sf:errors>
                                        <sf:hidden path="recordId"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <input type="submit" class="btn btn-primary" value="UPDATE STATIC PAGE"/>
                                    </div>
                                </div>


                            </sf:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>         

        <script src='https://cloud.tinymce.com/stable/tinymce.min.js?apiKey=scmd53yww1lj74aj6vs54kvv2d5zj06bxs2snlu2l51l0835'></script>
        <script>tinymce.init({selector: "textarea",
                    themes: "modern"});</script>
        
        <!-- JavaScript Libraries -->
        <jsp:include page="${request.contextPath}/jsp/jslibraries.jsp"></jsp:include>

    </body>
</html>
