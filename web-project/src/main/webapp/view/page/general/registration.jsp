<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authorization</title>
    <link href="<c:url value="/view/style/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="centered">
    <h1>Registration to selection committee</h1>
    <div class="sign-in">
        <form method="get" action="<c:url value="/command"/>" class="buttons">
            <input type="hidden" name="command" value="sign_up">
            <button type="submit">Sign up</button>
        </form>
        <form method="get" action="<c:url value="/command"/>" class="buttons">
            <input type="hidden" name="command" value="sign_in">
            <button type="submit">Sign in</button>
        </form>
    </div>
    <form method="post" action="<c:url value="/command"/>" class="sign-in">
        <input type="hidden" name="command" value="create_account">
        <label for="firstName">Enter first name</label><br>
        <input type="text" required maxlength="20" placeholder="First name" name="firstName" id="firstName"><br>
        <label for="secondName">Enter second name</label><br>
        <input type="text" required maxlength="20" placeholder="Second name" name="secondName" id="secondName"><br>
        <label for="login">Enter login</label><br>
        <input type="text" required maxlength="20" placeholder="Login" name="login" id="login"><br>
        <label for="password">Enter password</label><br>
        <input type="password" required maxlength="20" placeholder="Password" name="password" id="password"><br>
        <button type="submit">Create account</button>
    </form>
    <c:set var="answer" scope="page" value="${answerForRegistration}"/>
    <c:choose>
        <c:when test="${answer eq false}">
            Account with such login is already registered!
        </c:when>
        <c:when test="${answer eq true}">
            Account created!
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
    <p class="error">${error}</p>
</div>
</body>
</html>
