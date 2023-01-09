<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Student" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
  List<Student> lst = (List<Student>) request.getAttribute("lst");
%>    
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>List of students</title>
  </head>
  <body>
    <h2> List of students </h2>
    <p> <a href="search1.html"/> Search </a>
    <p> <a href="sort.jsp"/> Sort </a>
    <table border="1">
      <tr>
        <td align="center"> Rollno </td>
        <td align="center"> Name </td>
        <td align="center"> Mark </td>
        <td  colspan="2" align="center"> <a href="insert.html"/> Insert </a> </td>
      </tr>
      <%
        for(Student x: lst) {
      %>
      <tr>
        <td><%= x.getRollno() %> </td>
        <td><%= x.getName() %> </td>
        <td><%= x.getMark() %> </td>
        <td><a href="update?rollno=<%=x.getRollno() %>">  Edit </a> </td>
        <td><a href="delete?rollno=<%=x.getRollno() %>">  Delete </a> </td>

      </tr>  
      <% } %>  
    </table>     
    <p><button onclick='window.history.go(-1);'>Back to previous page</button>
    <p><a href="index.html">Back to homepage</a>
  </body>
</html>
