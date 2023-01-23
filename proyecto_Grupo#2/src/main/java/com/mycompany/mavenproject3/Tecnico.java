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
public class Tecnico extends Usuario {
    
    private int stock;
    private String implemento;
    private Scanner input;
    protected static List<Tecnico> listaTecnicos;
    public static  List<Tecnico> listaImplementos;
    public static final String email = "responsableInsumos@gmail.com";
    
    
    public Tecnico(Scanner input){
        listaTecnicos = new ArrayList<>();
        this.input = input;
        listaTecnicos.add(new Tecnico("alopez","al123456","Alvaro Lopez","tecnico"));
        listaTecnicos.add(new Tecnico("mbarcos","mb123456","Mario Barcos","tecnico"));
        ThirdController.listaUsuarios.addAll(listaTecnicos);
        listaImplementos = new ArrayList<>();
    }

    public Tecnico(String usuario, String contraseña, String nombre, String nivel) {
        super(usuario, contraseña, nombre, nivel);
    }
    
    public Tecnico(String implemento, int stock){
   
        this.implemento = implemento;
        this.stock = stock;
        
    }
    
       public static List<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }
    
    
    @Override
    public String toString(){
        return "Implemento: "+implemento+", Stock: "+stock;
    }
    
    
    
}
