package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import model.*;
import java.util.*;

@WebServlet(urlPatterns = {"/search1"})
public class Search1Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xRollno = request.getParameter("rollno");
        StudentDAO u = new StudentDAO();
        Student x = u.getStudent(xRollno);
        if(x==null) {
           out.println("<h2> A student is not found</h2>");
           request.getRequestDispatcher("search1.html").include(request, response);
        }
        else {
           request.setAttribute("x", x);
           request.getRequestDispatcher("search1.jsp").forward(request, response);
        }

    }
}

