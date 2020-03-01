<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmx:setBundle basename="locale.usual.left_panel" var="leftPanelB"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><fmx:message bundle="${leftPanelB}" key="title"/></title>
</head>
<body>
<ul class="vertical-menu">
    <c:if test="${user.role == 'USER'}">
        <li>
            <form action="<c:url value="/command"/>">
                <input type="hidden" name="command" value="apply_to_faculty">
                <button type="submit">
                    <fmx:message bundle="${leftPanelB}" key="menu.button.create.statement"/>
                </button>
            </form>
            <br>
        </li>
        <li>
            <form action="<c:url value="/command"/>">
                <input type="hidden" name="command" value="look_statement">
                <button type="submit">
                    <fmx:message bundle="${leftPanelB}" key="menu.button.delete.statement"/>
                </button>
            </form>
        </li>
    </c:if>
    <li>
        <form action="<c:url value="/command"/>">
            <input type="hidden" name="command" value="enroll_applicants">
            <button type="submit">
                <fmx:message bundle="${leftPanelB}" key="menu.button.enrollment.applicants"/>
            </button>
        </form>
        <br>
    </li>
    <c:if test="${user.role == 'ADMIN'}">
        <li>
            <button type="submit"><fmx:message bundle="${leftPanelB}" key="menu.button.register.statements"/></button>
            <ul class="sub-menu">
                <li>
                    <form action="<c:url value="/command"/>">
                        <input type="hidden" name="command" value="register_or_deregister_statements">
                        <input type="hidden" name="registerOrDeregisterCommand" value="register">
                        <button type="submit">
                            <fmx:message bundle="${leftPanelB}"
                                         key="menu.button.register.or.deregister.statements.register"/>
                        </button>
                    </form>
                </li>
                <li>
                    <form action="<c:url value="/command"/>">
                        <input type="hidden" name="command" value="register_or_deregister_statements">
                        <input type="hidden" name="registerOrDeregisterCommand" value="deregister">
                        <button type="submit">
                            <fmx:message bundle="${leftPanelB}"
                                         key="menu.button.register.or.deregister.statements.deregister"/>
                        </button>
                    </form>
                </li>
            </ul>
        </li>
    </c:if>
</ul>
</body>
</html>