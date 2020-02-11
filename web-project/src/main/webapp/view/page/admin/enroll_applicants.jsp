<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ex" uri="/taglib/condratulationTagLib.tld" %>
<fmx:setBundle basename="locale.admin.enroll_applicants" var="enrollMenuB"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><fmx:message bundle="${enrollMenuB}" key="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="<c:url value="/view/style/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="page-wrapper">
    <div class="menu-and-content-wrapper">
        <c:import url="/view/page/general/top_panel.jsp"/>
        <c:import url="/view/page/usual/left_panel.jsp"/>
        <div class="inner-content">
            <h1><fmx:message bundle="${enrollMenuB}" key="head"/></h1>


            <div class="table-actions">
                <c:forEach items="${mapFaculty}" var="map">
                    <div class="display-table-inline">
                        <h3><fmx:message bundle="${enrollMenuB}" key="faculty.name"/> - ${map.key.name}</h3>
                        <table>
                            <tr>
                                <th><fmx:message bundle="${enrollMenuB}" key="applicant.name"/></th>
                                <th><fmx:message bundle="${enrollMenuB}" key="applicant.points"/></th>
                            </tr>
                            <c:forEach items="${map.value}" var="statementDto">
                                <tr>
                                    <td><c:out value="${statementDto.user.name}"></c:out></td>
                                    <td><c:out value="${statementDto.totalPoints}"></c:out></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:forEach>
            </div>
            <div class="user-tag">
            <body>
            <ex:congratulation/>
            </body>
        </div>
        </div>
    </div>
    <c:import url="/view/page/general/footer.jsp"/>
</div>
</body>
</html>