package jogo.dados.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import jogo.dados.App;

public class TerciaryController {
    
    @FXML
    Label Ganhadores;
    ImageView primeiroDado;
    ImageView segundoDado;

    @FXML
    private void SwitchtoPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void SwitchtoQuaternary(ActionEvent event) throws IOException {
        App.setRoot("quaternary");
    }
}
