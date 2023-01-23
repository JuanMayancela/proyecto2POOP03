package com.mycompany.mavenproject3;

import java.io.IOException;
import javafx.fxml.FXML;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public class PrimaryController extends Thread {

    @FXML
    private TextField Usuario;
    @FXML
    private TextField Contra;
    
    private List<Jugador> lClientes = new ArrayList();
    private List<Jugador> lAdmins = new ArrayList();
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    
    //Es el metodo que revisa si el usuario es correcto, hay que modificarlo para que sean Cliente en vez de Jugador
    @FXML
    private void checkUserC(){
        String ft= Usuario.getText();
        String st= Contra.getText();
        Jugador B= new Jugador(st,ft,"","","");
        Jugador j = new Jugador();
        lClientes= Jugador.getlJ();
        try{
        if(lClientes.contains(B)){
        switchToSecondary();
        }
        else if(lAdmins.contains(B)){
        switchToSecondary();
        }
        else{
            mostrarAlerta(Alert.AlertType.ERROR,"Usuario no Valido");
        }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
        playSongC();
    }
    
     @FXML
    private void switchThird() throws IOException {
        App.setRoot("third");
       
    }
    
        private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
 
  //Juega la cancion del secondaryController
       public void playSongC(){ 
       Media song = new Media(getClass().getResource("/Musica/MP1C.wav").toExternalForm());   
       MediaPlayer mediaPlayer= new MediaPlayer(song);
       mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
       mediaPlayer.play(); 
       
       }
}
    
    
    

