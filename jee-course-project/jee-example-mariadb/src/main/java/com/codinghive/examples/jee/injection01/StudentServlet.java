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
        String studentIdStr = request.getParameter("ticketId");
        int ticketId = 0;
        if (studentIdStr != null && !studentIdStr.equals("")) {
            ticketId = Integer.parseInt(studentIdStr);
        }
        //get price and pass from index and store them to the loginprice and loginPassword
        String loginprice = request.getParameter("loginprice");
        String loginPassword = request.getParameter("loginPassword");
       // System.out.println("StudentServlet class. This is the loginprice provided from the html "+loginprice);
       // System.out.println("StudentServlet class. This is the loginPassword provided from the html "+ loginPassword);
        String ticket_number = request.getParameter("ticket_number");
        String isReserved = request.getParameter("isReserved");
         System.out.println("StudentServlet class. This is the ticket_number provided from the html "+ ticket_number);
        
        String eventName = request.getParameter("eventName");
        String location = request.getParameter("location");
        String price = request.getParameter("price");
        String password = request.getParameter("password");
        String yearLevelStr = request.getParameter("yearLevel");

        int yearLevel = 0;
        if (yearLevelStr != null && !yearLevelStr.equals("")) {
            yearLevel = Integer.parseInt(yearLevelStr);
        }

        Student student = new Student(ticketId, eventName, location, price, password, yearLevel);
        
//        switch(action.toLowerCase()) {
//        case "login":
//        	studentDao.login(loginprice , loginPassword);
//        	break;
//        case "add": 
//        	studentDao.addStudent(student);
//        	break;
//        case "edit":
//        	 studentDao.editStudent(student);
//        	 break;
//        case "delete":
//        	studentDao.deleteStudent(ticketId);
//        	break;
//        case "search" :
//        	student = studentDao.getStudent(ticketId);
//        	break;
//        case "reserve":
//        	System.out.println("Ticket reserved");
//        }
        
        if("login".equalsIgnoreCase(action)) {
            studentDao.login(loginprice , loginPassword);
        }
        if ("Add".equalsIgnoreCase(action)) {
            studentDao.addStudent(student);
            
        } else if ("Edit".equalsIgnoreCase(action)) {
            studentDao.editStudent(student);
            
        } else if ("Delete".equalsIgnoreCase(action)) {
            studentDao.deleteStudent(ticketId);
            
            
        } else if ("Search".equalsIgnoreCase(action)) {
            student = studentDao.getStudent(ticketId);
            
        }else if("reserve".equalsIgnoreCase(action)){
        	System.out.println("Ticket reserved");
        	System.out.println("StudentServlet class. This is the ticket_number provided from the html : "+ ticket_number);
        	System.out.println("StudentServlet class. This is the isReserved provided from the html : "+ isReserved);
        }

        request.setAttribute("student", student);
        request.setAttribute("allStudents", studentDao.getAllStudents());
        request.setAttribute("reserved", studentDao.getReservedTickets());
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
