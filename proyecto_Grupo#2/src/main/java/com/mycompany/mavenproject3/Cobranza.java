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
public class Cobranza extends Usuario{
    
    private Scanner input;
    private List<Cobranza> listaCobranzas;
    
    
    public Cobranza(Scanner input){
        listaCobranzas = new ArrayList<>();
        this.input = input;
        this.listaCobranzas.add(new Cobranza("mcastro","mc123456","Mario Castro","cobranzas"));
        ThirdController.listaUsuarios.addAll(listaCobranzas);
        
    }

    public Cobranza(String usuario, String contraseña, String nombre, String nivel) {
        super(usuario, contraseña, nombre, nivel);
    }
   
    public void generarFactura(){
        Scanner input = new Scanner (System.in);
        System.out.print("Por favor Ingrese el codigo de la empresa: ");
        String codigo= input.nextLine();
        System.out.print("Por favor Ingrese el año de la factura: ");
        String año= input.nextLine();
        System.out.print("Por favor Ingrese el mes de la factura: ");
        String mes= input.nextLine();
        String fechaFactura= año+"_"+mes;
        ArrayList<Servicio> list = new ArrayList();
        Cliente cB= new Cliente(codigo,"","","","");
        if (Cliente.listaClientes.contains(cB)){ //Esto se repetira solo una vez, ya que los codigos son unicos
        int ind= Cliente.listaClientes.indexOf(cB);
        Cliente c1= Cliente.listaClientes.get(ind); 
        int vExtra=0;
        String f= c1.getTipoCliente();
        if(f.equals("Empresarial")){
         vExtra=50;
        }
        System.out.println("Empresa/Cliente: "+ c1.getNombre());
        System.out.println("Periodo de facturacion: "+fechaFactura);
        System.out.println("#Placa-Fecha-Tipo-Servicio-Cantidad-Total"); 
        Tecnico tect= new Tecnico("","","","");
        Orden busqueda = new Orden(c1,"","","",list,tect);
        List<Orden> listaOrdenes = Orden.getListaOrdenes();
        double Total=0;
        Total+=vExtra;
        if (listaOrdenes.contains(busqueda)){
        int id= listaOrdenes.indexOf(busqueda);
        Orden B2= listaOrdenes.get(id);
        String pB= B2.getPlacaVehiculo();
        String tV= B2.getTipoVehiculo();
        String fS= B2.getFechaServicio();
        ArrayList<Servicio> lS= B2.getListaSer();
        for (Servicio i: lS){
            String cS= i.getCodigo();
            String nombreS= i.getNombre();
            double totalS= i.getPrecio();
            Total+=totalS;
            int cantidad=0;
            for(Servicio j:lS){
                String cSv= j.getCodigo();
                if(cS.equals(cSv)){
                    cantidad+=1;
                }
            }
        System.out.println(pB+"-"+fS+"-"+"-"+tV+"-"+nombreS+"-"+cantidad+"-"+totalS);}  
        }
        System.out.println("Total: "+Total);
        }
        
        
        
    }
    /*
    Iterar por la lista de Servicio y si el mes y ano es igual/similar
    a la busqueda se agarra ese Servicio Su Nombre y Total.   
    Para mostrarlo podemos hacer lo proximo  
    Crear dos listas, una con el nombre del servicio que no se puede
    repetir y la otra con los totales, Si el servicio no esta en esta lista
    Se agrega este y su valor y Si esta en la lista Se busca la posicion del codigo/nombre
    y se suma ese valor, Es decir listas paralelas.
    luego for para hacer print de ambas listas.
    */
    public void reporteIngresos(){
        Scanner input = new Scanner (System.in);
        System.out.println("Ingrese la fecha de la Busqueda(MM/YYYY): ");
        String fechaB= input.nextLine();
        List<Orden> listaOrdenes = Orden.getListaOrdenes();
        ArrayList<String> lOrdenes= new ArrayList();
        ArrayList<Double> lValores = new ArrayList();
        ArrayList<String> lCod= new ArrayList();
        for(Orden i: listaOrdenes){
        String f= i.getFechaServicio();
        String fO = f.substring(3);
        if (fechaB.equals(fO)){
            ArrayList<Servicio> lS= i.getListaSer();
            for (Servicio j: lS){
            String cS= j.getCodigo();
            String nombreS= j.getNombre();
            double totalS= j.getPrecio();
            if (!lCod.contains(cS)){
                lOrdenes.add(nombreS);
                lCod.add(cS);
                lValores.add(totalS);
            }
            else{
                int id= lCod.indexOf(cS);
                double vI= lValores.get(id);
                vI+=totalS;
                lValores.set(id, vI);
            }
            
            }
        }
        }
        System.out.println("Servicio"+"----"+"Total");
        for (int i = 0 ;i<= lCod.size()-1;i++){
            String Nombre= lOrdenes.get(i);
            Double Total= lValores.get(i);
            System.out.println(Nombre+"----"+Total);
        }

    }
    /*
    SE DEBE GUARDARSE EL NOMBRE DEL TECNICO QUE GENERO LA ORDEN...
    */
    public void reporteAtencionTecnico(){
        Scanner input = new Scanner (System.in);
        System.out.println("Ingrese la fecha de la Busqueda(MM/YYYY): ");
        String fechaB= input.nextLine();
        List<Orden> listaOrdenes = Orden.getListaOrdenes();
        List<Tecnico> listaTecnicos = Tecnico.getListaTecnicos();
        ArrayList<Double> lValores = new ArrayList();
        ArrayList<String> lNom= new ArrayList();
        
        for(Orden i: listaOrdenes){
        String f= i.getFechaServicio();
        String fO = f.substring(3);
        Tecnico Tecs = Orden.getTecnico();
        String nombre= Tecs.getNombre();
        if (fechaB.equals(fO)){
            ArrayList<Servicio> lS= i.getListaSer();
            for (Servicio j: lS){
            String nombreS= j.getNombre();
            double totalS= j.getPrecio();
            if (!lNom.contains(nombre)){
                lNom.add(nombre);
                lValores.add(totalS);
            }
            else{
                int id= lNom.indexOf(nombre);
                double vI= lValores.get(id);
                vI+=totalS;
                lValores.set(id, vI);
            }  
        }
        }
    }
        System.out.println("Tecnico"+"----"+"Total");
        for (int i = 0 ;i<= lNom.size()-1;i++){
            String Nombre= lNom.get(i);
            Double Total= lValores.get(i);
            System.out.println(Nombre+"----"+Total);
        }
    }
    
}
