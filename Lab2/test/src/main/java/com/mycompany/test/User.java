/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

import java.time.LocalDate;

public class User {
 private String name;
 public User() {
 }
 public User(String name) {
 this.name = name;
 }
 public String getName() {
 return name;
 }
 public void setName(String name) {
 this.name = name;
 }
 public String getMessage() {
 return "Today is " + LocalDate.now().toString();
 }
}