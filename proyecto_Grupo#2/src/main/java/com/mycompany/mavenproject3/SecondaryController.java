package com.mycompany.mavenproject3;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.fxml.FXML;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.util.regex.*;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SecondaryController extends Thread{

    @FXML
    VBox JuegoM;
    
    @FXML
    String first_val="";
    @FXML
    private Rectangle first_rectangle;
    private Timer GameTimer;
    @FXML
    Label time;
    @FXML
    Label Aciertos;
    @FXML
    Label Fallos;
    @FXML
    Label Score;
    private int A,F=0;
            
            
    private long min, sec, hr,TotalSec=0;
    //Convierte el tiempo de segundos a un reloj
    public void convertTime(){
        min = TimeUnit.SECONDS.toMinutes(TotalSec);
        sec = TotalSec - (min * 60);
        hr = TimeUnit.MINUTES.toHours(min);
        min = min - (hr * 60);
        time.setText(hr + ":" + min + ":" + sec);

        TotalSec--;
    }        
    
    // El Timer mismo
   @FXML  
   private void TimerStart(){
    TotalSec=120;
    this.GameTimer= new Timer();
    TimerTask timerHandler = new TimerTask(){
    @Override
    public void run(){
        Platform.runLater(new Runnable(){
        @Override
        public void run(){
        convertTime();
        if(A==10){
        GameTimer.cancel();
        scorePlayer();
        }
        if(TotalSec<=0){
        GameTimer.cancel();
        time.setText("00:00:00");
}}}
);};};
    GameTimer.schedule(timerHandler,0,1000);   
            }
   
   public void scorePlayer(){
       String Timer = time.getText();
       String Acs = Aciertos.getText();
       String Fs = Fallos.getText();
       mostrarAlerta(Alert.AlertType.CONFIRMATION,"Aciertos: "+Acs+" Fallos: "+Fs+" Timer: "+Timer);
   }   
   
   
   

    
   
   
   
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
        playSongP();
    }
    
    @FXML
    private void switchThird() throws IOException {
        App.setRoot("third");
        
    }
    
    
    
 // juega cancion para el primary.
       public void playSongP(){ 
       Media song = new Media(getClass().getResource("/Musica/MP1P.wav").toExternalForm());   
       MediaPlayer mediaPlayer= new MediaPlayer(song);
       mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
       mediaPlayer.play(); 
       }
    
        
   public static void setTimeout(Runnable runnable, int delay){
          
          new Thread(()->{
          try{
              Thread.sleep(delay);
              runnable.run();
          }
          catch(Exception e){
          System.err.println(e);}
      }).start();    
      } 
   
   
   //Es el que hace el cambio
      public void flip(String id,Rectangle rec, Image img){
       if(first_val.equals("")){
       first_val= id;
       first_rectangle=rec;
       rec.setFill(new ImagePattern(img));           
       }
       else{
           if(first_val.equals(id)){
               rec.setFill(new ImagePattern(img));
               first_val="";
               first_rectangle= new Rectangle();   
               A++;
               Aciertos.setText(A+"");
       }
           else{
        Image image= new Image("Imagenesjuego/Question.jpeg");
        rec.setFill(new ImagePattern(img));

        CompletableFuture.delayedExecutor(1,TimeUnit.SECONDS).execute(()->{
            rec.setFill(new ImagePattern(image));
            first_rectangle.setFill(new ImagePattern(image));
            first_val="";
            first_rectangle= new Rectangle();
        });
        F++;
        Fallos.setText(F+"");
           }
       }
      
      }
        
      private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle("FELICIDADES");
        alert.setHeaderText("TU HAS GANADO");
        alert.setContentText(mensaje);
        alert.showAndWait();
    } 
      
      
      
      
      //Es el que pide el cambio para ver si se puede hacer flip.
    public void cambio(Event e){
    Rectangle rec= (Rectangle)e.getSource();
    System.out.println(rec);
    String rid= rec.getId();
    
    Pattern p1 = Pattern.compile("Birdo", Pattern.CASE_INSENSITIVE);
    Matcher m1 = p1.matcher(rid);
    boolean mF1 = m1.find();
    
    Pattern p2 = Pattern.compile("Bowser", Pattern.CASE_INSENSITIVE);
    Matcher m2 = p2.matcher(rid);
    boolean mF2 = m2.find();
    
    Pattern p3 = Pattern.compile("Boy", Pattern.CASE_INSENSITIVE);
    Matcher m3 = p3.matcher(rid);
    boolean mF3 = m3.find();
    
    Pattern p4 = Pattern.compile("DK", Pattern.CASE_INSENSITIVE);
    Matcher m4 = p4.matcher(rid);
    boolean mF4 = m4.find();
    
    Pattern p5 = Pattern.compile("Daisy", Pattern.CASE_INSENSITIVE);
    Matcher m5 = p5.matcher(rid);
    boolean mF5 = m5.find();
    
    Pattern p6 = Pattern.compile("Luigi", Pattern.CASE_INSENSITIVE);
    Matcher m6 = p6.matcher(rid);
    boolean mF6 = m6.find();
    
    Pattern p7 = Pattern.compile("Mario", Pattern.CASE_INSENSITIVE);
    Matcher m7 = p7.matcher(rid);
    boolean mF7 = m7.find();
    
    Pattern p8 = Pattern.compile("Peach", Pattern.CASE_INSENSITIVE);
    Matcher m8 = p8.matcher(rid);
    boolean mF8 = m8.find();
    
    Pattern p9 = Pattern.compile("Wario", Pattern.CASE_INSENSITIVE);
    Matcher m9 = p9.matcher(rid);
    boolean mF9 = m9.find();
    
    Pattern p10 = Pattern.compile("Toadette", Pattern.CASE_INSENSITIVE);
    Matcher m10 = p10.matcher(rid);
    boolean mF10 = m10.find();
    
    if(mF1){
     Image img= new Image("Imagenesjuego/Birdo.jpeg");
     flip("Birdo.jpeg",rec,img);
    }
    else if(mF2){
     Image img= new Image("Imagenesjuego/Bowser.jpeg");
     flip("Bowser.jpeg",rec,img);
    }
    else if(mF3){
     Image img= new Image("Imagenesjuego/Boy.jpeg");
     flip("Boy.jpeg",rec,img);
    }    
    else if(mF4){
     Image img= new Image("Imagenesjuego/DK.jpeg");
     flip("DK.jpeg",rec,img);
    }    
    else if(mF5){
     Image img= new Image("Imagenesjuego/Daisy.jpeg");
     flip("Daisy.jpeg",rec,img);
    }    
    else if(mF6){
     Image img = new Image("Imagenesjuego/Luigi.jpeg");
     flip("Luigi",rec,img);
    }   
    else if(mF7){
     Image img= new Image("Imagenesjuego/Mario.jpeg");
     flip("Mario.jpeg",rec,img);
    }    
    else if(mF8){
     Image img= new Image("Imagenesjuego/Peach.jpeg");
     flip("Peach.jpeg",rec,img);
    }    
    else if(mF9){
     Image img= new Image("Imagenesjuego/Wario.jpeg");
     flip("Wario.jpeg",rec,img);
    }    
    else if(mF10){
     Image img= new Image("Imagenesjuego/Toadette.jpeg");
     flip("Toadette.jpeg",rec,img);
    }      
      }
    }
    
    
       




