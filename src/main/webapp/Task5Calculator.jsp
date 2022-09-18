
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task5Calculator</title>
</head>
<body>
<h1>Task 3. Find min, max or avg number</h1>
<br>

<a style="font-size: x-large" href="${pageContext.request.contextPath}/index.jsp">main menu</a>
<br>
<br>
<hr>
<br>

<form method="post">
    <label for="digit1"> Input first number
        <input type="number" id="digit1" name="number1">
    </label>
    <br/>
    <br/>

    <label for="digit2"> Input second number
        <input type="number" id="digit2" name="number2">
    </label>
    <br/>
    <br/>

    <input type="submit" name="buttonAction" value="+">
    <input type="submit" name="buttonAction" value="-">
    <input type="submit" name="buttonAction" value="*">
    <input type="submit" name="buttonAction" value="/">
    <input type="submit" name="buttonAction" value="^">
    <input type="submit" name="buttonAction" value="%">

</form>

<br>
<hr>
<br>
<% String result;
    if (request.getAttribute("result") != null)
    {result = request.getAttribute("result").toString();}
    else {result = "";}
%>
<a>Result of operation
    [ <%= request.getAttribute("operation")%> ]
    is number = <%= result%>
</a>



</body>
</html>
