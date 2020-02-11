<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmx:setBundle basename="locale.admin.register_or_deregister_statements" var="statementsMenuB"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><fmx:message bundle="${statementsMenuB}" key="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="<c:url value="/view/style/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="page-wrapper">
    <div class="menu-and-content-wrapper">
        <c:import url="/view/page/general/top_panel.jsp"/>
        <c:import url="/view/page/usual/left_panel.jsp"/>
        <div class="inner-content">
            <c:if test="${isRegisteredToFaculty eq false}">
                <h1><fmx:message bundle="${statementsMenuB}" key="head.registration"/></h1>
            </c:if>
            <c:if test="${isRegisteredToFaculty eq true}">
                <h1><fmx:message bundle="${statementsMenuB}" key="head.deregistration"/></h1>
            </c:if>


            <form method="get">
                <div class="table-actions">
                    <div class="rows">
                        <table>
                            <tr>
                                <th>UserId</th>
                                <th>UserName</th>
                                <th>StatementId</th>
                                <th>StatementDate</th>
                                <th>Faculty</th>
                                <th>TotalPoints</th>
                                <th>checkbox</th>
                            </tr>
                            <c:forEach items="${statementDtoList}" var="statementDto" varStatus="status">
                                <tr>
                                    <td><c:out value="${statementDto.user.id}"></c:out></td>
                                    <td><c:out value="${statementDto.user.name}"></c:out></td>
                                    <td><c:out value="${statementDto.statement.id}"></c:out></td>
                                    <td><c:out value="${statementDto.statement.date}"></c:out></td>
                                    <td><c:out value="${statementDto.faculty.name}"></c:out></td>
                                    <td><c:out value="${statementDto.totalPoints}"></c:out></td>
                                    <td>
                                        <p>
                                            <input type="checkbox" name="statementId"
                                                   value="${statementDto.statement.id}"/>
                                        </p>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>

                <div class="confirm-act">
                    <c:if test="${isRegisteredToFaculty eq false}">
                        <h2><fmx:message bundle="${statementsMenuB}" key="submit.registration"/></h2>
                    </c:if>
                    <c:if test="${isRegisteredToFaculty eq true}">
                        <h2><fmx:message bundle="${statementsMenuB}" key="submit.deregistration"/></h2>
                    </c:if>
                    <p>
                        <input type="hidden" name="command" value="register_page_confirm_act"/>
                        <input type="hidden" name="registerOrUnregisterCommand" value="${isRegisteredToFaculty}"/>
                        <button type="submit">
                            <fmx:message bundle="${statementsMenuB}" key="button.statements.registration.confirm"/>
                        </button>
                    </p>
                </div>
            </form>
        </div>
    </div>

    <c:import url="/view/page/general/footer.jsp"/>
</div>
</body>
</html>