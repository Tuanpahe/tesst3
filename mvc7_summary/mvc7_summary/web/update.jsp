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
      if(x==null) return;
     %>    
     <h2> Update a student </h2>
     <form action="update" method="POST">
        <p><input type="text" name="rollno" value="<%= x.getRollno()%>" readonly /> 
        <p><input type="text" name="name" value="<%= x.getName() %>"/> 
        <p><input type="text" name="mark" value="<%= x.getMark() %>"/> 
        <p><input type="submit" value="Update"> 
     </form>  
     <p><button onclick='window.history.go(-1);'>Back to previous page</button>
     <p><a href="index.html">Back to homepage</a>
  </body>
</html>
