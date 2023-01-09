package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import model.*;
import java.util.*;

@WebServlet(urlPatterns = {"/insert"})
public class InsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xRollno,xName,sMark; float xMark;
        xRollno = request.getParameter("rollno");
        xRollno = xRollno.trim();
        StudentDAO u = new StudentDAO();
        Student x = u.getStudent(xRollno);
        if(x != null) {
           pr.print("<h3> The roll no " + xRollno + " already exists!");
           request.getRequestDispatcher("insert.html").include(request, response);
           return;
        }
        xName = request.getParameter("name");
        if(xName==null || xName.trim().length()==0) {
           pr.print("<h3> The name must not be empty!");
           request.getRequestDispatcher("insert.html").include(request, response);
           return;
         }
        sMark = request.getParameter("mark");
        if(sMark.trim().length()==0)
          xMark=0;
        else {
          xMark = Float.parseFloat(sMark);
         }
        x = new Student(xRollno,xName,xMark);
        u.insert(x);
        response.sendRedirect("list");
    }
}
