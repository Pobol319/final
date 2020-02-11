<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmx" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmx:setBundle basename="locale.usual.register_to_faculty" var="facultiesMenuB"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><fmx:message bundle="${facultiesMenuB}" key="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="<c:url value="/view/style/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="page-wrapper">
    <div class="menu-and-content-wrapper">
        <c:import url="/view/page/general/top_panel.jsp"/>
        <c:import url="/view/page/usual/left_panel.jsp"/>
        <c:if test="${allFaculties eq null}">
            <div class="centered">
                <h1><fmx:message bundle="${facultiesMenuB}" key="user.create.statement"/></h1>
            </div>
        </c:if>
        <c:if test="${allFaculties ne null}">
            <div class="inner-content">
                <h1><fmx:message bundle="${facultiesMenuB}" key="head"/></h1>
                <c:forEach items="${allFaculties}" var="faculty">
                    <div class="entity">
                        <h3><fmx:message bundle="${facultiesMenuB}" key="faculty.name"/> - ${faculty.name}</h3>
                        <p><fmx:message bundle="${facultiesMenuB}" key="faculty.maxSize"/> - ${faculty.maxSize}</p>
                    </div>
                </c:forEach>
                <div class="registration">
                    <form method="get">
                        <p><fmx:message bundle="${facultiesMenuB}" key="choose.faculty"/>:</p>
                        <select name="facultyId">
                            <c:forEach items="${allFaculties}" var="faculty">
                                <option value="${faculty.id}"> ${faculty.name}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="command" value="get_required_subjects">
                        <button type="submit">
                            <fmx:message bundle="${facultiesMenuB}" key="faculty.get.subjects"/>
                        </button>
                    </form>

                    <c:if test="${selectedFacultyId ne null}">
                        <form method="post" action="<c:url value="/command"/>">
                            <input type="hidden" name="command" value="create_statement"/>
                            <input type="hidden" name="selectedFacultyId" value="${selectedFacultyId}"/>
                            <p><fmx:message bundle="${facultiesMenuB}" key="required.subjects"/>:</p>
                            <c:forEach items="${requiredSubjects}" var="subject">
                                <p><fmx:message bundle="${facultiesMenuB}" key="subject.${subject.name}"/>:</p>
                                <p><input name="points" type="number" min="0" max="100" value="0"></p>
                            </c:forEach>
                            <button type="submit">
                                <fmx:message bundle="${facultiesMenuB}" key="faculty.create.statement"/>
                            </button>
                        </form>
                    </c:if>

                    <c:if test="${userHaveStatement eq true}">
                        <fmx:message bundle="${facultiesMenuB}" key="faculty.user.have.statement"/>
                    </c:if>

                </div>
            </div>
        </c:if>
    </div>
    <c:import url="/view/page/general/footer.jsp"/>
</div>
</body>
</html>