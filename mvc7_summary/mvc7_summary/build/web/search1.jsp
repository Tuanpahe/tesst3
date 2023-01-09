<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search result</title>
  </head>
  <body>
     <%
      Student x = (Student) request.getAttribute("x");
     %>    
     <h2>Student found:</h2>
     <h3>RollNo: <%= x.getRollno() %> </h3>
     <h3>Name: <%= x.getName() %> </h3>
     <h3>Mark: <%= x.getMark() %> </h3>
     <p><button onclick='window.history.go(-1);'>Back to previous page</button>
     <p><a href="index.html">Back to homepage</a>
  </body>
</html>
