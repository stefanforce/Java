/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalTime;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Stefan
 */
@Logger
@Interceptor
public class LoggingInterceptor implements Serializable {
 @AroundInvoke
 public Object logMethodEntry(InvocationContext invocationContext)
 throws Exception {
 System.out.println("Entering method: "
 + invocationContext.getMethod().getName() + " in class "
+ invocationContext.getMethod().getDeclaringClass().getName());
 OutputStream os= new FileOutputStream(new File("C:\\Users\\Stefan\\Desktop"+"fisier.txt"));
      BufferedWriter writer= new BufferedWriter(new FileWriter("logging.txt"));
      writer.newLine();
      writer.append(' ');
      LocalTime time = LocalTime.now();
      writer.append(time.toString());
return invocationContext.proceed();
 }
}
