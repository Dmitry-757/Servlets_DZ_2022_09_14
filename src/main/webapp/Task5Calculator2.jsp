
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task5Calculator2</title>
</head>
<body>
<h1>Calculator 2</h1>
<br>

<a style="font-size: x-large" href="${pageContext.request.contextPath}/index.jsp">main menu</a>
<br>
<br>
<hr>
<br>

<form method="post">
    <label for="digit1"> Input first number
        <input type="number" id="digit1" name="number1" value=<%= request.getAttribute("number1")%>>
    </label>
<%--    <br/>--%>
<%--    <br/>--%>

    <label> selectAction
        <select name="selectedAction">
            <option value="+" >+</option>
            <option value="-" >-</option>
            <option value="*" >*</option>
            <option value="/" >/</option>
        </select>
    </label>


    <label for="digit2"> Input second number
        <input type="number" id="digit2" name="number2" value=<%= request.getAttribute("number2")%> >
    </label>


    <label for="result">   =
<%--        <input type="number" id="result" name="result"  disabled  value=<%= request.getAttribute("result")%> >--%>
        <input type="number" id="result" name="result"  disabled  value="${result}" >
    </label>

<%--    <label for="result2">   ==--%>
<%--        <input type="number" id="result2" name="result2"  value=<%= (String)request.getSession().getAttribute("result2")%> >--%>
<%--    </label>--%>



    <br/>
    <br/>

<%--    <input type="submit" name="selectedAction"  value="calculate">--%>
    <button>Calculate</button>

</form>

<br>
<hr>
<br>
<%--<% String result;--%>
<%--    if (request.getAttribute("result") != null)--%>
<%--    {result = request.getAttribute("result").toString();}--%>
<%--    else {result = "";}--%>
<%--%>--%>
<%--<a>Result of operation--%>
<%--    [ <%= request.getAttribute("operation")%> ]--%>
<%--    is number = <%= result%>--%>
<%--</a>--%>



</body>
</html>
