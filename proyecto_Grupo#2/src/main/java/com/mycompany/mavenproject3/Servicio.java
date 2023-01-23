/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mamay
 */
public class Servicio {
    
    private String codigo;
    private String nombre;
    private double precio;
    
    private Scanner input;
    protected static List<Servicio> listaServicios;
    private char respuesta = '1';
    
    public Servicio(Scanner input){
        listaServicios = new ArrayList<>();
        this.input = input;
        
        listaServicios.add(new Servicio("ali001","Alineación",17.5));
        listaServicios.add(new Servicio("bal002","Balanceo",12.0));
        listaServicios.add(new Servicio("fre003","Frenos",20.0));
        listaServicios.add(new Servicio("cAc004","Cambio Aceite",35.0));
        listaServicios.add(new Servicio("cFi005","Cambio Filtro",20.0));
        listaServicios.add(new Servicio("enl006","Enllantaje",25.0));
        
    }
        
        


    public Servicio(String codigo, String nombre, double precio){
	this.codigo=codigo;
	this.nombre=nombre;
	this.precio=precio;
    }
    
    public static List<Servicio> getListaServicios(){
        return listaServicios;
    }
            
    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

        
        
        
    public void agregarServicio(){
	Scanner sc = new Scanner(System.in);
	String res = " ";
        
        String cd = "";
        int ultiSer = listaServicios.size()-1;
        String cod = listaServicios.get(ultiSer).getCodigo();
        for(int i = 0; i < cod.length(); i++){
            int n = (int)(Math.random()*cod.length());
            cd += cod.charAt(n);
        }
        cod =cd;

	do{
            System.out.println("Ingrese el nombre del Servicio: ");
            String nombreS= sc.nextLine();
            System.out.println("Ingrese el precio del Servicio: ");
            double precioS= sc.nextDouble();
            sc.nextLine();
            Servicio Serv= new Servicio(cod,nombreS,precioS);
            listaServicios.add(Serv);
            System.out.println("Desea ingresar otro Servicio(S/N): ");
            res= sc.nextLine();
        }while(res.equals("S"));
    }

        
    public void editarServicio(){
        Scanner sc= new Scanner(System.in);
        String res = "";
        do{
            System.out.println("Ingrese el codigo del servicio: ");
            String cod= sc.nextLine();
            Servicio busqueda= new Servicio(cod,"",0.0);
            if (listaServicios.contains(busqueda)){
                int ind = listaServicios.indexOf(busqueda);
                Servicio editServ= listaServicios.get(ind);
                System.out.println("Ingrese el nuevo valor del precio");
                double newPrecio= sc.nextDouble();
                sc.nextLine();
                editServ.setPrecio(newPrecio);
                System.out.println("!! El servicio fue editado exitosamente !!");
                System.out.println("Desea editar otro servicio(S/N)?");
                res = sc.nextLine();
            }
            else{
                System.out.println("!! Servicio no encontrado !!");
            }
        }while(res.equals("S"));
    }
    
    @Override
    public String toString(){
        return codigo+","+nombre+","+precio;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(obj != null && obj instanceof Servicio){
            Servicio other = (Servicio)obj;
            return codigo.equals(other.codigo);
        }
        return false;
    }
    
    public void menuServicios(){
        
        respuesta = '1';        
        while(respuesta != '3'){
            
            System.out.println(" ");
            System.out.println("!! Información de los servicios !!");
            System.out.println(listaServicios);
            
            System.out.println(" ");
            System.out.println("\"\"\n" +
"                Menú Servicios:\n" +
"                1.Agregar Servicio\n" +
"                2.Editar Servicio               \n" +
"                3.Regresar al menú principal\n" +
"                \"\"");
            System.out.print("Ingrese el número de la opción selecionada: ");
            respuesta = input.nextLine().charAt(0);
            switch(respuesta){
                
                case '1':
                   agregarServicio();
                    break;
                
                case '2':
                    editarServicio();
                    break;
                 
                case '3':
                    return;
                   
                default :
                    System.out.println("La opcion es incorrecta");

            }
        }
    }
    
}
