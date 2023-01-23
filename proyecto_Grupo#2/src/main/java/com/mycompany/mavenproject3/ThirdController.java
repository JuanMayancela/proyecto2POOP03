/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author mamay
 */
public class ThirdController implements Initializable {
    
    
    @FXML
    private AnchorPane scenaPrincipal;
    
    @FXML
    private VBox vbGene;
    
    @FXML
    private Label lblTitulo;
 
    
    static Scanner input = new Scanner(System.in);
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static char respuesta = '1';
    
    private static Admin adm;
    private static Cobranza cobra;
    private static Tecnico tec;
    private static Cliente cli;
    private static Proveedor pro1;
    private static Servicio ser;
    private static Orden ord;
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarSistema();
        validarUsuario();
        
    }
    
    public static void inicializarSistema(){
        
        adm = new Admin(input);
        cobra = new Cobranza(input);
        tec = new Tecnico(input);
        cli = new Cliente(input);
        pro1 = new Proveedor(input);
        ser = new Servicio(input);
        ord = new Orden(input);
        
    }
    
    @FXML
    public void validarUsuario(){
        scenaPrincipal.getChildren().clear();
        Label lblInicio = new Label();
        lblInicio.setText("Inicio de Sesión");
        lblInicio.relocate(220,50);
        lblInicio.setFont(new Font("Arial", 30));
        
        Label lblUsuario = new Label();
        lblUsuario.setText("Usuario:");
        TextField tf1 = new TextField();
        Label lblClave = new Label();
        lblClave.setText("Clave:");
        TextField tf2 = new TextField();
        
        Button bt1 = new Button("Iniciar Sesión");
        bt1.setPrefWidth(207);
        bt1.setPrefHeight(37);
        vbGene.getChildren().addAll(lblUsuario, tf1, lblClave,tf2,bt1);
        scenaPrincipal.getChildren().addAll(lblInicio,vbGene);
        bt1.setOnMouseClicked(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            String usua = tf1.getText();
            String contra = tf2.getText();
            Usuario busqueda = new Admin(usua,contra,"","");
            if(listaUsuarios.contains(busqueda)){


                int ind = listaUsuarios.indexOf(busqueda);
                Usuario u = listaUsuarios.get(ind);
                if(u instanceof Admin){
                    scenaPrincipal.getChildren().clear();
                    lblInicio.setText("Menú Admin");
                    lblInicio.relocate(220,50);
                    lblInicio.setFont(new Font("Arial", 30));
                    vbGene.getChildren().clear();
                    vbGene.setAlignment(Pos.TOP_CENTER);
                    Button but1 = new Button("Menú Clientes");
                    Button but2 = new Button("Menú Proveedores");
                    Button but3 = new Button("Menú Servicios");
                    Button but4 = new Button("Cerrar Sesión");
                    vbGene.getChildren().addAll(lblInicio,but1,but2,but3,but4);
                    scenaPrincipal.getChildren().add(vbGene);
                }
                
                if(u instanceof Tecnico){
                    scenaPrincipal.getChildren().clear();
                    lblInicio.setText("Menú Tecnico");
                    lblInicio.relocate(220,50);
                    lblInicio.setFont(new Font("Arial", 30));
                    vbGene.getChildren().clear();
                    vbGene.setAlignment(Pos.TOP_CENTER);
                    Button but1 = new Button("Generar Orden");
                    Button but2 = new Button("Reportar Stock");
                    Button but4 = new Button("Cerrar Sesión");
                    vbGene.getChildren().addAll(lblInicio,but1,but2,but4);
                    scenaPrincipal.getChildren().add(vbGene);
                    but1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        
                    }});
                    
                    but2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        reportarStock();
                    }});
                }
                
                if(u instanceof Cobranza){
                    scenaPrincipal.getChildren().clear();
                    lblInicio.setText("Menú Cobranza");
                    lblInicio.relocate(220,50);
                    lblInicio.setFont(new Font("Arial", 30));
                    vbGene.getChildren().clear();
                    vbGene.setAlignment(Pos.TOP_CENTER);
                    Button but1 = new Button("Generar Factura");
                    Button but2 = new Button("Reporte de Ingresos");
                    Button but3 = new Button("Reporte de Atenciones");
                    Button but4 = new Button("Cerrar Sesión");
                    vbGene.getChildren().addAll(lblInicio,but1,but2,but3,but4);
                    scenaPrincipal.getChildren().add(vbGene);
                    but1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        GFSwitch();
                    }});
                     
                    but2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        RISwitch();
                    }});
                    
                    but3.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        RATSwitch();
                    }});
                }
                    
            
           
            }
            else{
            System.out.println("!! Error: usuario o contraseña incorrectos !!");
            }
            
            
        }});
        
        
      }
    
    @FXML
    public void GFSwitch(){
         scenaPrincipal.getChildren().clear();
        String menuCGF= "GENERAR FACTURA";
        Label GF1= new Label();
        GF1.setText(menuCGF);
        String CodE="Ingrese el codigo de la empresa";
        Label GF2 = new Label();
        GF2.setText(CodE);
        String MGF = "Ingrese el mes ";
        Label GF3 = new Label();
        GF3.setText(MGF);
        String AGF = "Ingrese el año";
       Label GF4 = new Label();
       GF4.setText(AGF);
       TextField CodEGF = new TextField();
       TextField AnoGF = new TextField();
       TextField MsGF= new TextField();
       TableView PGF= new TableView();
      Label gr= new Label();
      Label hr= new Label();
      Label tr= new Label();

      //LISTA LA CUAL SERA AGREGADA AL TABLEVIEW;
      ArrayList<String> ls= new ArrayList(); 
      Button GF= new Button("Generar Factura");
      GF.setPrefWidth(207);
      GF.setPrefHeight(37);
      GF.setOnMouseClicked(new EventHandler<MouseEvent>(){
      @Override
      public void handle(MouseEvent event){
          //TODO ESTO ES EL METODO DE GENERARFACTURA
      String codigo= CodEGF.getText();
      String año= AnoGF.getText();
      String mes= MsGF.getText();
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
      hr.setText("Empresa/Cliente:"+c1.getNombre()+"Periodo de facturacion: "+fechaFactura);
      tr.setText("#Placa-Fecha-Tipo-Servicio-Cantidad-Total");
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
      String fd = pB+"-"+fS+"-"+"-"+tV+"-"+nombreS+"-"+cantidad+"-"+totalS;
      }  
      }
      System.out.println("Total: "+Total);
      } 
      PGF.setItems((ObservableList) ls);
      }
      });
      Button MP= new Button("Menu Principal");
      MP.setPrefWidth(207);
      MP.setPrefHeight(37);
      MP.setOnMouseClicked(new EventHandler<MouseEvent>(){
          @Override
          public void handle(MouseEvent event){
              MUSwitch();
          }});
      scenaPrincipal.getChildren().addAll(GF1,GF2,CodEGF,GF3,AnoGF,GF4,MsGF,GF,gr,hr,tr,PGF,MP);


    }
    
     @FXML
            public void RISwitch(){
                scenaPrincipal.getChildren().clear();
                String menuRI= "REPORTE INGRESOS";
                Label RI1= new Label();
                RI1.setText(menuRI);
                String CodE="Ingrese la Fecha del reporte MM/YYYY";
                Label RI2 = new Label();
                RI2.setText(CodE);
                TextField AnoMSRI = new TextField();
                TableView PRI= new TableView();
                Label hr= new Label();
                Label gr=new Label();
                Label tr= new Label();
                Button RI= new Button("Generar RI");
                RI.setPrefWidth(207);
                RI.setPrefHeight(37);
                RI.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    //TODO ESTO ES EL METODO REPORTEINGRESO
                String fechaB= AnoMSRI.getText();
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
                hr.setText("Servicio"+"----"+"Total");
                //LISTA QUE SERA AGREGADA AL TABLEVIEW
                ArrayList<String> gj= new ArrayList();
                for (int i = 0 ;i<= lCod.size()-1;i++){
                    String Nombre= lOrdenes.get(i);
                    Double Total= lValores.get(i);
                    gj.add(Nombre+"----"+Total);
                }
                PRI.setItems((ObservableList) gj);
                }});
                Button MP= new Button("Menu Principal");
                MP.setPrefWidth(207);
                MP.setPrefHeight(37);
                MP.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        MUSwitch();
                    } } );
                scenaPrincipal.getChildren().addAll(RI1,RI2,AnoMSRI,RI,gr,hr,tr,PRI,MP);
                }
            
            @FXML
    public void RATSwitch(){
        scenaPrincipal.getChildren().clear();
        String menuRI= "REPORTE ATENCION TECNICO";
        Label RAT1= new Label();
        RAT1.setText(menuRI);
        String CodE="Ingrese la Fecha del reporte MM/YYYY";
        Label RAT2 = new Label();
        RAT2.setText(CodE);
        Label hr= new Label();
        Label gr=new Label();
        Label tr= new Label();
        TextField AnoMSRAT = new TextField();
        TableView PRAT= new TableView();
        Button RAT= new Button("Generar RAT");
        RAT.setPrefWidth(207);
        RAT.setPrefHeight(37);
        RAT.setOnMouseClicked(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            //TODO ESTO ES EL METODO DE REPORTEAT
        String fechaB= AnoMSRAT.getText();
        List<Orden> listaOrdenes = Orden.getListaOrdenes();
        List<Tecnico> listaTecnicos = Tecnico.getListaTecnicos();
        ArrayList<Double> lValores = new ArrayList();
        ArrayList<String> lNom= new ArrayList();
        System.out.println(listaTecnicos);
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
        
        ArrayList<String> gj= new ArrayList();
        //LISTA QUE SERA AGREGADA AL TABLEVIEW
        hr.setText("Tecnico"+"----"+"Total");
        System.out.println("Tecnico"+"----"+"Total");
        for (int i = 0 ;i<= lNom.size()-1;i++){
            String Nombre= lNom.get(i);
            Double Total= lValores.get(i);
            gj.add(Nombre+"----"+Total);
        }     
        TableView PRI= new TableView();
        PRI.setItems((ObservableList) gj);
        }});
        Button MP= new Button("Menu Principal");
        MP.setPrefWidth(207);
        MP.setPrefHeight(37);
        MP.setOnMouseClicked(new EventHandler<MouseEvent>(){
        
            @Override
            public void handle(MouseEvent event){
                MUSwitch();
            }
        } );
        scenaPrincipal.getChildren().addAll(RAT1,RAT2,AnoMSRAT,RAT,gr,hr,tr,PRAT,MP);
}
    

 //ESTE ES EL METODO QUE CAMBIA EL MENU A SU NORMALIDAD    
        public void MUSwitch(){
        scenaPrincipal.getChildren().clear();
        String P1= "Opcion 1!";
        String P2= "Opcion 2!";
        String P3= "Opcion 3!";
        Label OP1= new Label();
        OP1.setPrefWidth(207);
        OP1.setPrefHeight(37);
        Label OP2= new Label();
        Label OP3= new Label();
        OP2.setPrefWidth(207);
        OP2.setPrefHeight(37);
        OP3.setPrefWidth(207);
        OP3.setPrefHeight(37);
        OP1.setText(P1);
        OP2.setText(P2);
        OP3.setText(P3);
        Button OM1 = new Button("Generar Factura");
        OM1.setPrefWidth(223);
        OM1.setPrefHeight(29);
        OM1.setOnMouseClicked(new EventHandler<MouseEvent>(){
        
            @Override
            public void handle(MouseEvent event){
                GFSwitch();
            }
        } );
        Button OM2 = new Button("Reporte Ingresos");
        OM2.setOnMouseClicked(new EventHandler<MouseEvent>(){
        
            @Override
            public void handle(MouseEvent event){
                RISwitch();
            }
        } );
        Button OM3 = new Button("Reporte AT");
        OM3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                RATSwitch();
            }
        } );
        OM2.setPrefWidth(223);
        OM2.setPrefHeight(29);
        OM3.setPrefWidth(223);
        OM3.setPrefHeight(29);
        scenaPrincipal.getChildren().addAll(OP1,OM1,OP2,OM2,OP3,OM3);
        } 
        
        
        @FXML
        public void reportarStock(){
            scenaPrincipal.getChildren().clear();
            try{
               
                Label lblInicio = new Label();
                lblInicio.setText("Reportar de Stock");
                lblInicio.relocate(220,50);
                lblInicio.setFont(new Font("Arial", 30));


                Label lbNombre = new Label("nombre del implemento: ");
                TextField tx1 = new TextField();
                Label lbCantidad = new Label("cantidad de implementos: ");
                TextField tx2 = new TextField();

                String imple = tx1.getText();
                String stc1 = tx2.getText();
                int stc = Integer.parseInt(stc1);


                Button bt1 = new Button("Agregar Implemento");
                Button bt2 = new Button("Enviar notificación");
                ComboBox cb = new ComboBox();
                Tecnico implemen = new Tecnico(imple,stc);
                Tecnico.listaImplementos.add(implemen); 
                

               
                bt1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                         
                    }
                } );

                 bt1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){

                    }
                } );
                 
                vbGene.getChildren().addAll(lblInicio,lbNombre,lbCantidad);
                scenaPrincipal.getChildren().addAll(vbGene);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
            
        
           
            
    }
     
    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
}
