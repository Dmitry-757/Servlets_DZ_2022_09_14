<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Max digit</title>
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

  <label for="digit2"> Input second number
    <input type="number" id="digit2" name="number2">
  </label>
  <br/>

  <label for="digit3"> Input third number
    <input type="number" id="digit3" name="number3">
  </label>
  <br/>

  <input type="radio" id="maxChoice"
         name="choice" value="max">
  <label for="maxChoice">Max</label>

  <input type="radio" id="minChoice"
         name="choice" value="min">
  <label for="minChoice">Min</label>

  <input type="radio" id="avgChoice"
         name="choice" value="avg" checked>
  <label for="maxChoice">Avg</label>

  <br>


  <input type="submit" value="do it">
</form>

<br>
<hr>
<br>
<% String result;
  if (request.getAttribute("result") != null)
   {result = request.getAttribute("result").toString();}
  else {result = "";}
%>
  <a>From numbers
    [<%= request.getAttribute("number1")%>,
     <%= request.getAttribute("number2")%>,
     <%= request.getAttribute("number3")%>]
    <%= request.getAttribute("choice")%> number = <%= result%>
  </a>



</body>
</html>
