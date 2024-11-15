package jogo.dados.controller;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import jogo.dados.App;
import jogo.dados.model.Dado;
import jogo.dados.model.dao.DadoDao;

public class TerciaryController extends VBox {
    
    @FXML
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

    @FXML
    private void initialize() throws IOException{
        try {
        DadoDao dadoDao = new DadoDao();
        List<Dado> dados = dadoDao.getAll();

        if (dados.size() >= 2) {
            Dado dado1 = dados.get(0);
            Dado dado2 = dados.get(1);
            System.out.println("Dado 1: " + dado1);
            System.out.println("Dado 2: " + dado2);
        } else {
            System.out.println("Dados insuficientes na lista: " + dados.size());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    }

