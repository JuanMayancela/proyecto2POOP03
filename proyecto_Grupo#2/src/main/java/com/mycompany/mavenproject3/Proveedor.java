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
public class Proveedor extends Persona{
    
      private Scanner input;
    private List<Proveedor> listaProveedores;
    private char respuesta = '1';
    
    public Proveedor(Scanner input){
        listaProveedores = new ArrayList<>();
        this.input = input;
        this.listaProveedores.add(new Proveedor("123460","Maria Vera","Machala","0975661328"));
        this.listaProveedores.add(new Proveedor("123461","Adriana Barco","Cuenca","0975661328"));
        
    }

    public Proveedor(String codigo, String nombre, String direccion, String telefono) {
        super(codigo, nombre, direccion, telefono);
    }
  
    
    public void agregarProveedor(){
        Scanner sc = new Scanner(System.in); 
        
        String res = "";
        String cd = "";
        int ultiCli = listaProveedores.size()-1;
        String cod = listaProveedores.get(ultiCli).getCodigo();
        for(int i = 0; i < cod.length(); i++){
            
            int n = (int)(Math.random()*cod.length());
            cd += cod.charAt(n);
        }
        cod =cd;
        
        System.out.println("!! Ingrese los datos del proveedor !!\n");
        do{
            System.out.println("Ingrese nombre del proveedor: ");
            String nom = sc.nextLine();
            System.out.println("Ingrese dirección del proveedor: ");
            String direc = sc.nextLine();
            System.out.println("Ingrese teléfono del proveedor: ");
            String tel = sc.nextLine();
            
            Proveedor proveedor = new Proveedor(cod,nom,direc,tel);
            listaProveedores.add(proveedor);
            System.out.println("Desea agregar otro proveedor(S/N)?");
            res = sc.nextLine();
            System.out.println(" ");
            
        }while(res.equals("S"));    
    }
    
    @Override
    public String toString(){
        return getCodigo()+","+getNombre()+","+getDireccion()+","+getTelefono();
    }
    
    public void menuProveedores(){
        
        respuesta = '1';        
        while(respuesta != '2'){
            
            System.out.println(" ");
            System.out.println("!! Información de los Proveedores !!");
            System.out.println(listaProveedores);
            System.out.println(" ");
            System.out.println("\"\"\n" +
"                Menú Proveedor:\n" +
"                1.Agregar Proveedor\n" +
"                2.Regresar al menú principal\n" +
"                \"\"");
            
            System.out.print("Ingrese el número de la opción selecionada: ");
            respuesta = input.nextLine().charAt(0);
            switch(respuesta){
                
                case '1':
                   agregarProveedor();
                    break;
                 
                case '2':
                    return;
                   
                default :
                    System.out.println("La opcion es incorrecta");

            }
        }
    }
}
