package jogo.dados.controller;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import jogo.dados.App;

//loading
public class SecondaryController {

    int counter = 0;
    
    @FXML
    private ImageView carregando;

    @FXML
    private Label lblCounter;


    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    private void switchToTerciary() throws IOException{
        App.setRoot("terciary");
    }

    @FXML
    public void initialize() throws IOException{
        //temporizador (exemplo)
        
        lblCounter.setText(String.valueOf(counter));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            counter++;
            lblCounter.setText(String.valueOf(counter));
        }));
        timeline.setCycleCount(5); //Animation.INDEFINITE (-1)
        timeline.play();
        timeline.setOnFinished(e -> {
            try {
                switchToTerciary();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        } 
    }


