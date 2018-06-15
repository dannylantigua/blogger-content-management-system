<%-- 
    Document   : navigationBar
    Created on : Jun 13, 2018, 9:11:29 AM
    Author     : dannylantigua
--%>
        </ul>
        <span class="navbar-text pr-5">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a class="btn btn-primary text-light" href="${pageContext.request.contextPath}/dashboard"role="button">Dashboard</a>
            </c:if>
        </span>
    </div>
</nav>
