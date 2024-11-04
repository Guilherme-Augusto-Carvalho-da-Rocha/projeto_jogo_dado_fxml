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
import jogo.dados.model.Dado;
import jogo.dados.model.dao.DadoDao;

//loading
public class SecondaryController {

    int counter = 0;

    @FXML
    private ImageView carregando;

    @FXML
    private Label lblCounter;


    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        DadoDao dadoDao = new DadoDao();
        dado1.setId(dadoDao.getAll().get(0).getId());
        dado2.setId(dadoDao.getAll().get(1).getId());
        dado1.setValorFace(dadoDao.getAll().get(0).getValorFace());
        dado2.setValorFace(dadoDao.getAll().get(1).getValorFace());
        dadoDao.delete(dado1);
        dadoDao.delete(dado2);
        App.setRoot("primary");
    }

    private void switchToTerciary() throws IOException{
        App.setRoot("terciary");
    }

    @FXML
    public void initialize() throws IOException{
        //temporizador (exemplo)
        
        lblCounter.setText("segundos esperando: " + String.valueOf(counter));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            counter++;
            lblCounter.setText("segundos esperando: " + String.valueOf(counter));
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


