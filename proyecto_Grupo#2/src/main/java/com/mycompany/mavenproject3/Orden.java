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
public class Orden {
    
    private Cliente cliente;
    private String fechaServicio;
    private String tipoVehiculo;
    private String placaVehiculo;
    private int cantidad;
    private ArrayList<Servicio> listaSer;
    private Scanner input;
    protected static List<Orden> listaOrdenes;
    public static ArrayList<Servicio> servRealizados = new ArrayList<>();
    private static Tecnico Tecnico;
    
    public Orden(Scanner input){
        listaOrdenes = new ArrayList<>();
        this.input = input;
        Cliente C1 = new Cliente("123456","Carlos Bayas","Guayaquil","0975661328","Empresarial");
        Cliente C2 = new Cliente("123457","Mateo Vega","Machala","0975661328","Personal");
        Cliente C3 = new Cliente("123458","Carla Gaona","Cuenca","0975661328","Empresarial");
        Cliente C4 = new Cliente("123459","Aianna Mata","Quito","0975661328","Personal");       
        // CREA UNA LISTA DE SERVICIOS INDEPENDIENTE A CADA UNA DE LAS ORDENES
        
        ArrayList<Servicio> LS1= new ArrayList<>();
        ArrayList<Servicio> LS2= new ArrayList<>();
        ArrayList<Servicio> LS3= new ArrayList<>();
        ArrayList<Servicio> LS4= new ArrayList<>();
        Servicio S1 = new Servicio("ali001","Alineación",17.5);
        Servicio S2 = new Servicio("bal002","Balanceo",12.0);
        Servicio S3 = new Servicio("fre003","Frenos",20.0);
        Servicio S4 = new Servicio("cAc004","Cambio Aceite",35.0);
        Servicio S5 = new Servicio("cFi005","Cambio Filtro",20.0);
        Servicio S6 = new Servicio("enl006","Enllantaje",25.0);
        LS1.add(S1);
        LS1.add(S4);
        LS2.add(S2);
        LS2.add(S5);
        LS3.add(S6);
        LS4.add(S3);
        LS4.add(S1);
        Tecnico Tec1= new Tecnico("alopez","al123456","Alvaro Lopez","tecnico");
        Tecnico Tec2 = new Tecnico("mbarcos","mb123456","Mario Barcods","tecnico");
        
        listaOrdenes.add(new Orden(C1,"19/11/2022","automóvil","GST-0984",LS1,Tec1));
        listaOrdenes.add(new Orden(C2,"20/06/2022","bus","GNW-087",LS2,Tec1));
        listaOrdenes.add(new Orden(C3,"29/11/2022","motocicleta","PQR-988",LS3,Tec1));
        listaOrdenes.add(new Orden(C4,"15/11/2022","automóvil","OBB-444",LS4,Tec2));     
    }
        
  
    public Orden(Cliente cliente, String fechaServicio, String tipoVehiculo, String placaVehiculo,ArrayList<Servicio> listaSer,Tecnico Tecnico){
        this.cliente=cliente;
        this.fechaServicio=fechaServicio;
        this.tipoVehiculo=tipoVehiculo;
        this.placaVehiculo=placaVehiculo;
        this.listaSer = listaSer;
        this.Tecnico = Tecnico;
    }
    
    public static List<Orden> getListaOrdenes() {
        return listaOrdenes;
    }
    
    public static Tecnico getTecnico(){
        return Tecnico;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(String fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }
    
    public ArrayList<Servicio> getListaSer(){
        return listaSer;
    }
    
    
    
    @Override
    public String toString(){
        return "Cliente: "+cliente+", Fecha: "+fechaServicio+", Vehiculo: "+tipoVehiculo+", Placa: "+placaVehiculo+", Servicios:"+listaSer;
    }


    public  Orden generarOrden(){
        Scanner sc= new Scanner(System.in);
        String res = "";
        String codSer = "";
        double valorTotal = 0.0;
        //Cambiar String a cliente

        System.out.println(" ");
        System.out.println("Ingrese el codigo del cliente: ");
        String codCli= sc.nextLine();
        
        Cliente c1= new Cliente(codCli,"","","","");
        Tecnico Tect= new Tecnico("","","","");
        Orden orden = new Orden(c1,"","","",servRealizados,Tect);  
        
        
        System.out.println("Ingrese la fecha del Servicio(DD/MM/YYYY): ");
        String fechaServ= sc.nextLine();
        System.out.println("Ingrese el tipo de Vehiculo: ");
        String tipoVehi= input.nextLine();
        System.out.println("Ingrese la placa del vehiculo: ");
        String placaVehi= input.nextLine();
        while(!codSer.equals("-1")){
            System.out.println("Ingrese el codigo del Servicio: ");
            codSer= input.nextLine();
            Servicio busqueda= new Servicio(codSer,"",0.0);
            if (Servicio.listaServicios.contains(busqueda)){
                System.out.println("Ingrese cantidad del Servicio: ");
                int cantidad= sc.nextInt();
                int ind = Servicio.listaServicios.indexOf(busqueda);
                Servicio editServ= Servicio.listaServicios.get(ind);
                servRealizados.add(editServ);
                double precioServ = editServ.getPrecio()*cantidad;
                valorTotal += precioServ;
                Tecnico Tec1= getTecnico();
                orden= new Orden(c1,fechaServ,tipoVehi,placaVehi,servRealizados,Tec1);
                listaOrdenes.add(orden);
            }
            else{
                if(codSer.equals("-1")){
                    System.out.println("!! Su Orden fue registrada !!"); 
                }
                else{
                    System.out.println("!! No se encontro el servicio !!");
                }
            }
        }
            
        System.out.println(orden +", Valor a pagar: "+valorTotal);
        return orden;
    }
    @Override
        public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(obj != null && obj instanceof Orden){
            Orden other = (Orden)obj;
            Cliente C1= getCliente();
            return C1.equals(other.getCliente());
        }
        return false;
}
    
}
