<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmx:setBundle basename="locale.usual.look_and_delete_statement" var="lookStatementB"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><fmx:message bundle="${lookStatementB}" key="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="<c:url value="/view/style/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="page-wrapper">
    <div class="menu-and-content-wrapper">
        <c:import url="/view/page/general/top_panel.jsp"/>
        <c:import url="/view/page/usual/left_panel.jsp"/>

        <c:if test="${isUserHaveStatement eq true}">
            <div class="inner-content">
                <h1><fmx:message bundle="${lookStatementB}" key="head"/></h1>
                <h3><fmx:message bundle="${lookStatementB}" key="statement"/> #${statementDto.statement.id}</h3>
                <h3><fmx:message bundle="${lookStatementB}" key="faculty"/> - ${statementDto.faculty.name}</h3>
                <h3><fmx:message bundle="${lookStatementB}" key="statementDate"/> - ${statementDto.statement.date}</h3>
                <c:forEach items="${subjects}" var="subject" varStatus="status">
                    <div class="inner-content">
                        <p> ${subject.name} - ${points[status.index].numberOfPoints}</p>
                    </div>
                </c:forEach>
            </div>


            <div class="centered">
                <form method="post" action="<c:url value="/command"/>">
                    <input type="hidden" name="command" value="delete_statement">
                    <input type="hidden" name="statementId" value="${statementDto.statement.id}">
                    <button type="submit">
                        <fmx:message bundle="${lookStatementB}" key="delete.statement"/>
                    </button>
                </form>
            </div>


        </c:if>
        <c:if test="${isUserHaveStatement eq false}">
            <div class="centered">
                <h1><fmx:message bundle="${lookStatementB}" key="user.not.have.statement"/></h1>
            </div>
        </c:if>
        <c:if test="${isUserHaveStatement eq null}">
            <div class="centered">
                <h1><fmx:message bundle="${lookStatementB}" key="user.delete.statement"/></h1>
            </div>
        </c:if>
    </div>


    <c:import url="/view/page/general/footer.jsp"/>
</div>
</body>
</html>