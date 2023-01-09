package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import model.*;

@WebServlet(urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xRollno = request.getParameter("rollno");
        StudentDAO u = new StudentDAO();
        Student x = u.getStudent(xRollno);
        if(x==null) {
           pr.println("<h2> A student is not found</h2>");
           request.getRequestDispatcher("update.html").include(request, response);
        }
        else {
           request.setAttribute("x", x);
           request.getRequestDispatcher("update.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xRollno, xName, sMark; float xMark;
        xRollno = request.getParameter("rollno");
        xName = request.getParameter("name");
        boolean isOk = true;
        if(xRollno==null || xRollno.equals("")) {
           isOk = false;
        }
        if(xName==null || xName.trim().length()==0 || xName.trim().equals("Invalid name!")) {
           xName = "Invalid name!"; 
           isOk = false;
        }
        sMark = request.getParameter("mark");
        if(sMark==null || sMark.trim().length()==0)
            xMark = 0;
          else
           xMark = Float.parseFloat(sMark.trim());
        Student x = new Student(xRollno,xName,xMark);
        if(!isOk) {
          request.setAttribute("x", x);
          request.getRequestDispatcher("update.jsp").forward(request, response);
          return;
        }
        StudentDAO u = new StudentDAO();
        u.update(xRollno,x);
        response.sendRedirect("list");
  }
}
