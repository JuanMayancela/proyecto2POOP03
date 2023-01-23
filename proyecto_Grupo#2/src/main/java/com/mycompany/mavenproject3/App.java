package com.mycompany.mavenproject3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * JavaFX App
 */
public class App extends Application{

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        playSongP();
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Juego de Memoria para Clientes");
        stage.show();
        
    }
 
       public void playSongP(){ 
       Media song = new Media(getClass().getResource("/Musica/MP1P.wav").toExternalForm());   
       MediaPlayer mediaPlayer= new MediaPlayer(song);
       mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
       mediaPlayer.play(); 
       }
    
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        
    }

}