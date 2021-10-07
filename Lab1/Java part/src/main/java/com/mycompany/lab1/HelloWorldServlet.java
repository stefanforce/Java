/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.lab1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stefan
 */
@WebServlet(
        name = "HelloWorldServlet",
        urlPatterns = "/hello")

public class HelloWorldServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //response.setContentType("text/plain");
        try (PrintWriter out = response.getWriter()) {
            String key = request.getParameter("key");
            String value = request.getParameter("value");
            String mock = request.getParameter("mock");
            String sync = request.getParameter("sync");

            if ("true".equals(request.getParameter("sync"))) {
                if ("true".equals(request.getParameter("mock"))) {
                    out.println("Confirmed");
                } else {
                    String str;
                    BufferedWriter writer = new BufferedWriter(new FileWriter("repository.txt"));

                    for (int i = 0; i < Integer.parseInt(value); i++) {
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        str = key + " " + timestamp + "\n";
                        writer.write(str);
                        out.println(str + "<br>");
                    }

                    logElements(request);

                    writer.close();
                }
            }
        }
    }

    protected void logElements(HttpServletRequest request) {
        log("Method used: " + request.getMethod());
        log("Client IP: " + request.getLocalAddr());
        log("User-agent: " + request.getHeader("User-Agent"));
        log("Languages: " + request.getLocale());
        log("Key: " + request.getParameter("key"));
        log("Value: " + request.getParameter("value"));
        log("Mock: " + request.getParameter("mock"));
        log("Sync: " + request.getParameter("sync"));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
