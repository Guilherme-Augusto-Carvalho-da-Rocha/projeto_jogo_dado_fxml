package jogo.dados.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jogo.dados.App;
import jogo.dados.model.Dado;
import jogo.dados.model.dao.DadoDao;

public class TerciaryController {
    
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
        DadoDao dadoDao = new DadoDao();
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        dado1.setId(dadoDao.getAll().get(0).getId());
        dado2.setId(dadoDao.getAll().get(1).getId());
        dado1.setValorFace(dadoDao.getAll().get(0).getValorFace());
        dado2.setValorFace(dadoDao.getAll().get(1).getValorFace());
        primeiroDado.setImage(new Image("dado_" + dado1.getValorFace() + ".png"));
        segundoDado.setImage(new Image("dado_" + dado2.getValorFace() + ".png"));
        dadoDao.delete(dado1);
        dadoDao.delete(dado2);
        
    }
}
