package jogo.dados.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import jogo.dados.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
        /*public boolean verificaVitoria(){
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        dado2.setValorFace();
        dado1.setValorFace();
        int valor_real = dado2.getValorFace() + dado1.getValorFace();
        if(valor_real == valor_aposta){
            return true;
        } else{
            return false;
        }
    } */

}
