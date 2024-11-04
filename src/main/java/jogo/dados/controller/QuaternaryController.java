package jogo.dados.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jogo.dados.App;
import jogo.dados.model.dao.JogadorDao;

public class QuaternaryController {

    @FXML
    private JFXListView<Label> rankList;

    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    public void initialize(){
        JogadorDao jogadorDao = new JogadorDao();
        Label primeiro  = new Label();
        Label segundo = new Label();
        Label terceiro  = new Label();
        Label quarto = new Label();
        Label quinto = new Label();
        primeiro.setText("1°"+jogadorDao.getAll().get(0).getNome());
        segundo.setText("2°"+jogadorDao.getAll().get(1).getNome());
        terceiro.setText("3°"+jogadorDao.getAll().get(2).getNome());
        quarto.setText("4°"+jogadorDao.getAll().get(3).getNome());
        quinto.setText("5°"+jogadorDao.getAll().get(4).getNome());
    }
}
