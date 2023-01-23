/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author mamay
 */
public class Usuario {
    
    private String usuario;
    private String contraseña;
    private String nombre;
    private String nivel;
    
    public Usuario(){
    }
    
    public Usuario(String usuario, String contraseña, String nombre, String nivel) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
   @Override
   public boolean equals(Object obj){
       if(obj==this){
           return true;
       }
       if(obj != null && obj instanceof Usuario){
           Usuario other = (Usuario)obj;
           boolean resul = usuario.equals(other.usuario) && contraseña.equals(other.contraseña);
           return resul;
       }
       return false;
   }
    
}
