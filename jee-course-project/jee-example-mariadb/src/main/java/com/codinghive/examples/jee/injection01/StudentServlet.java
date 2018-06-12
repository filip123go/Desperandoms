package com.codinghive.examples.jee.injection01;


import com.codinghive.examples.jee.dao.StudentDaoLocal;
import com.codinghive.examples.jee.model.Student;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @Inject
    private StudentDaoLocal studentDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String studentIdStr = request.getParameter("studentId");
        int studentId = 0;
        if (studentIdStr != null && !studentIdStr.equals("")) {
            studentId = Integer.parseInt(studentIdStr);
        }
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String yearLevelStr = request.getParameter("yearLevel");

        int yearLevel = 0;
        if (yearLevelStr != null && !yearLevelStr.equals("")) {
            yearLevel = Integer.parseInt(yearLevelStr);
        }

        Student student = new Student(studentId, firstname, lastname, userName, password, yearLevel);

        if ("Add".equalsIgnoreCase(action)) {
            studentDao.addStudent(student);
        }
        else if ("Edit".equalsIgnoreCase(action)) {
            studentDao.editStudent(student);
        }
        else if ("Delete".equalsIgnoreCase(action)) {
            studentDao.deleteStudent(studentId);
        }
        else if ("Search".equalsIgnoreCase(action)) {
            student = studentDao.getStudent(studentId);
        }

        request.setAttribute("student", student);
        request.setAttribute("allStudents", studentDao.getAllStudents());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
