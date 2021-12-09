/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import com.mycompany.lab7.managedBeans.DocumentBean;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
@ApplicationScoped
public class ApplicationConfig extends Application {
 public Set<Class<?>> getClasses() {
 Set<Class<?>> resources = new java.util.HashSet<>();
 addRestResourceClasses(resources);
 return resources;
 }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.lab7.services.service.DocumentFacadeREST.class);
    }
}
