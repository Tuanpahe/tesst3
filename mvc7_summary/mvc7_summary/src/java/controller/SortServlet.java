package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/sort"})
public class SortServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xColName,xSortType;
        xColName = request.getParameter("colName").trim();
        xSortType = request.getParameter("sortType");
        if(xSortType==null) {
           pr.print("<h3> The sort type cannot be empty!");
           request.getRequestDispatcher("sort.jsp").include(request, response);
           return;
        }
        StudentDAO u = new StudentDAO();
        List<Student> lst = u.getStudents(xColName,xSortType);
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

}
