/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

/**
 *
 * @author Stefan
 */
public class Entry {
    private String key;
    private String value;
    private String language;
    
    public Entry(String key,String value,String language){
        this.key=key;
        this.language=language;
        this.value=value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
   
    public String getLanguage() {
        return language;
    }
    
    
}
