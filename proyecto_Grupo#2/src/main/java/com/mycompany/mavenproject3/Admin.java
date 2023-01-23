/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;
import com.mycompany.mavenproject3.ThirdController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mamay
 */
public class Admin extends Usuario{
    
     private Scanner input;
    private List<Admin> listaAdmins;
   
    
    public Admin(Scanner input){
        listaAdmins = new ArrayList<>();
        this.input = input;
        this.listaAdmins.add(new Admin("admin1","12345678","Administrador","admin"));
        ThirdController.listaUsuarios.addAll(listaAdmins);
    }

    public Admin(String usuario, String contraseña, String nombre, String nivel) {
        super(usuario, contraseña, nombre, nivel);
    }
   
    
    
    
}
