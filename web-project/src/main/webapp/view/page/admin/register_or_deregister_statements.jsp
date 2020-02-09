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
        </div>
    </div>
    

    <form method="get">
        <table width="950" border="0">
            <tr>
                <th width="30" height="32" scope="col"></th>
                <th width="50" scope="col">UserId</th>
                <th width="60" scope="col">UserName</th>
                <th width="60" scope="col">StatementId</th>
                <th width="60" scope="col">StatementDate</th>
                <th width="60" scope="col">Faculty</th>
                <th width="60" scope="col">TotalPoints</th>
            </tr>

            <c:forEach items="${statementDtoList}" var="statementDto" varStatus="status">
                <tr>
                    <th height="25" scope="row"></th>
                    <td><c:out value="${statementDto.user.id}"></c:out></td>
                    <td><c:out value="${statementDto.user.name}"></c:out></td>
                    <td><c:out value="${statementDto.statement.id}"></c:out></td>
                    <td><c:out value="${statementDto.statement.date}"></c:out></td>
                    <td><c:out value="${statementDto.faculty.name}"></c:out></td>
                    <td><c:out value="${statementDto.totalPoints}"></c:out></td>
                    <td>
                        <p>
                            <input type="checkbox" name="statementId" value="${statementDto.statement.id}"/>
                        </p>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${isRegisteredToFaculty eq false}">
            <p><fmx:message bundle="${statementsMenuB}" key="submit.registration"/></p>
        </c:if>
        <c:if test="${isRegisteredToFaculty eq true}">
            <p><fmx:message bundle="${statementsMenuB}" key="submit.deregistration"/></p>
        </c:if>


        <p>
            <input type="hidden" name="command" value="register_page_confirm_act"/>
            <input type="hidden" name="registerOrUnregisterCommand" value="${isRegisteredToFaculty}"/>
            <button type="submit">
                <fmx:message bundle="${statementsMenuB}" key="button.statements.registration.confirm"/>
            </button>
        </p>
    </form>


    <c:import url="/view/page/general/footer.jsp"/>
</div>
</body>
</html>