<%-- 
    Document   : navigationBar
    Created on : Jun 13, 2018, 9:11:29 AM
    Author     : dannylantigua
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
</ul>
<sec:authorize access="hasRole('ROLE_USER')">
    <span class="navbar-text pr-5">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a class="btn btn-primary text-light" href="${pageContext.request.contextPath}/dashboard"role="button">Dashboard</a>
        </c:if>
    </span>
</sec:authorize>
</div>
</nav>
