/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3.repositories;

import com.mycompany.lab3.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class InMemoryMap {
    private Map<String,List<Resource>> assignments;
    
    @PostConstruct
    public void init(){assignments= new HashMap<>();}
    
    public void addAssignment(String examName, List<Resource> resources){ assignments.put(examName,resources);}
}
