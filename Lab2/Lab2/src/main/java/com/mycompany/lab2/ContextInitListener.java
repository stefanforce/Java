/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package com.mycompany.lab2;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Stefan
 */
public class ContextInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

       ServletContext context = sce.getServletContext();
        String language = context.getInitParameter("language");
        context.setAttribute("defaultLanguage", language);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}




    