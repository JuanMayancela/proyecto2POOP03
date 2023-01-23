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
public class Cliente extends Persona{
    
    private String tipoCliente;
    
    private Scanner input;
    public static List<Cliente> listaClientes;
    private char respuesta = '1';
    
    
    
    
    public Cliente(Scanner input){
        listaClientes = new ArrayList<>();
        this.input = input;
        listaClientes.add(new Cliente("123456","ECODUK CIA LTDA","Guayaquil","0975661328","Empresarial"));
        listaClientes.add(new Cliente("123457","Mateo Vega","Machala","0975661328","Personal"));
        listaClientes.add(new Cliente("123458","TRACTOPARTES S.A","Cuenca","0975661328","Empresarial"));
        listaClientes.add(new Cliente("123459","Aianna Mata","Quito","0975661328","Personal"));
    }

    public Cliente(String codigo, String nombre, String direccion, String telefono,String tipoCliente) {
        super(codigo, nombre, direccion, telefono);
        this.tipoCliente = tipoCliente;
       
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

 
    
    public void agregarCliente(){
        
        Scanner sc = new Scanner(System.in);
        
        String res = "";
        String cd = "";
        int ultiCli = listaClientes.size()-1;
        String cod = listaClientes.get(ultiCli).getCodigo();
        for(int i = 0; i < cod.length(); i++){
            
            int n = (int)(Math.random()*cod.length());
            cd += cod.charAt(n);
        }
        cod =cd;
        
        System.out.println("!! Ingrese los datos del cliente !!");
        
        do{
            System.out.println("Ingrese nombre del cliente: ");
            String nom = sc.nextLine();
            System.out.println("Ingrese dirección del cliente: ");
            String direc = sc.nextLine();
            System.out.println("Ingrese teléfono del cliente: ");
            String tel = sc.nextLine();
            System.out.println("Ingrese tipo de cliente: ");
            String tipoCli = sc.nextLine();
           
            Cliente cliente = new Cliente(cod,nom,direc,tel,tipoCli);
            listaClientes.add(cliente);
            System.out.println("Desea agregar otro cliente(S/N)?");
            res = sc.nextLine();
            System.out.println(" ");
            
        }while(res.equals("S"));
        
    }
    
    @Override
    public String toString(){
        return getCodigo()+","+getNombre()+","+getDireccion()+","+getTelefono()+","+tipoCliente;
    }
    

    
    public void menuCliente(){
        
        respuesta = '1';        
        while(respuesta != '2'){
            
            System.out.println(" ");
            System.out.println("!! Información de los clientes !!");
            System.out.println(listaClientes);
            System.out.println(" ");
            System.out.println("\"\"\n" +
"                Menú Cliente:\n" +
"                1.Agregar Cliente\n" +
"                2.Regresar al menú principal\n" +
"                \"\" ");
           
            
            System.out.print("Ingrese el número de la opción selecionada: ");
            respuesta = input.nextLine().charAt(0);
            switch(respuesta){
                
                case '1':
                   agregarCliente();
                    break;
                 
                case '2':
                    return;
                   
                default :
                    System.out.println("La opcion es incorrecta");

            }
        }
    }
    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(obj != null && obj instanceof Cliente){
            Cliente other = (Cliente)obj;
            return getCodigo().equals(other.getCodigo());
        }
        return false;
    }
    
}
