/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Win1OPro Station
 */
public class Jugador {
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String tipoCliente;
    static protected List <Jugador> lJ = new ArrayList<>();
    
    
    public Jugador(String codigo, String nombre, String direccion, String telefono, String tipoCliente){
    this.codigo=codigo;
    this.nombre=nombre;
    this.direccion=direccion;
    this.telefono=telefono;
    this.tipoCliente=tipoCliente;
    } 
    
    public Jugador(){
    this.lJ.add(new Jugador("123460","Diego Contreras","Guayaquil","0975661330","Personal"));
    }
    
    public static List <Jugador> getlJ(){
      return lJ;
     }
    
    public String getNombre(){
      return nombre;
     }
        @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(obj != null && obj instanceof Jugador){
            Jugador other = (Jugador)obj;
            String cod1= getNombre();
            return cod1.equals(other.getNombre());
        }
        return false;
    }
        @Override
    public String toString(){
        return codigo+","+nombre;
    }

}

    
