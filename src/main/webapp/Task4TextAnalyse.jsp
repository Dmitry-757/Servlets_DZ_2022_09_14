<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 4. Text analyse</title>
</head>
<body>
<h1>Task 4. Text analyse</h1>
<br>

<a style="font-size: x-large" href="${pageContext.request.contextPath}/index.jsp">main menu</a>
<br>
<br>
<hr>
<br>

<form method="post">
    <label for="inputedText"> Input text:
        <input type="text" id="inputedText" name="inputedText">
    </label>
    <br/>

    <input type="submit" value="do it">
</form>

<br>
<hr>
<br>
<% String result;
    if (request.getAttribute("result1") != null) {
        result = request.getAttribute("result1").toString();
    } else {
        result = "";
    }
%>
<a>Inputed text [<%= request.getAttribute("inputedText")%>] </a>
<br>
<a> is consist of: </a>
<br>
<a> <%= result%></a>
</body>
</html>
