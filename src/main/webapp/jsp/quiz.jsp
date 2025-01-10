<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<h1>Welcome to the Quiz</h1>
<form action="${pageContext.request.contextPath}/quiz" method="post">
    <c:forEach var="question" items="${questions}">
        <h3>${question.questionText}</h3>
        <c:forEach var="answer" items="${question.answers}">
            <label>
                <input type="radio" name="answers" value="${answer.answerText}">
                    ${answer.answerText}
            </label>
            <br>
        </c:forEach>
    </c:forEach>
    <button type="submit">Submit</button>
</form>
</body>
</html>
