<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

            <c:forEach items="${mapFaculty}" var="map">

                <h3><fmx:message bundle="${enrollMenuB}" key="faculty.name"/> - ${map.key.name}</h3>
                <c:forEach items="${map.value}" var="statementDto">
                    <p><fmx:message bundle="${enrollMenuB}" key="statementDto.applicant"/> - ${statementDto.user.name}: ${statementDto.totalPoints}</p>
                </c:forEach>
            </c:forEach>
        </div>
    </div>
    <c:import url="/view/page/general/footer.jsp"/>
</div>
</body>
</html>