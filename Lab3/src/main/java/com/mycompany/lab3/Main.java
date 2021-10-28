/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3;

public class Main {

    public static void main(String[] args) {
        DBconnection db = new DBconnection();
        db.connect_to_db("postgres", "postgres", "postgres");
    }

}
