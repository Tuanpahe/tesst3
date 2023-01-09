package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import model.*;
import java.util.*;

@WebServlet(urlPatterns = {"/search2"})
public class Search2Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xName = request.getParameter("name");
        StudentDAO u = new StudentDAO();
        List<Student> lst = u.getStudents(xName);
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}

