package jogo.dados.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import jogo.dados.App;
import jogo.dados.model.Jogador;
import jogo.dados.model.dao.JogadorDao;

//inserir jogadores e apostas
public class PrimaryController {
    ArrayList<Jogador> jogadores = new ArrayList<>();

    @FXML
    private ImageView dices_moving;

    @FXML
    private TextField namePlayer1;
    private TextField namePlayer2;
    private TextField namePlayer3;
    private TextField namePlayer4;
    private TextField namePlayer5;
    private TextField namePlayer6;
    private TextField namePlayer7;
    private TextField namePlayer8;
    private TextField namePlayer9;
    private TextField namePlayer10;
    private TextField namePlayer11;

    @FXML
    private TextField aposta1;
    private TextField aposta2;
    private TextField aposta3;
    private TextField aposta4;
    private TextField aposta5;
    private TextField aposta6;
    private TextField aposta7;
    private TextField aposta8;
    private TextField aposta9;
    private TextField aposta10;
    private TextField aposta11;


    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        
        ArrayList<TextField> caixas = new ArrayList<>();
        ArrayList<TextField> apostas = new ArrayList<>();
        JogadorDao jogadorDao = new JogadorDao();

        caixas.add(namePlayer1);
        caixas.add(namePlayer2);
        caixas.add(namePlayer3);
        caixas.add(namePlayer4);
        caixas.add(namePlayer5);
        caixas.add(namePlayer6);
        caixas.add(namePlayer7);
        caixas.add(namePlayer8);
        caixas.add(namePlayer9);
        caixas.add(namePlayer10);
        caixas.add(namePlayer11);

        apostas.add(aposta1);
        apostas.add(aposta2);
        apostas.add(aposta3);
        apostas.add(aposta4);
        apostas.add(aposta5);
        apostas.add(aposta6);
        apostas.add(aposta7);
        apostas.add(aposta8);
        apostas.add(aposta9);
        apostas.add(aposta10);
        apostas.add(aposta11);

        for(int i = 0; i > 10; i++){
            String nome = caixas.get(i).getText();
            String apostaString = apostas.get(i).getText();
            int aposta = Integer.parseInt(apostaString);
            if(nome == null){
                break;
            } else {
                Jogador jogador = new Jogador(nome, aposta);
                jogadores.add(jogador);
            }
        }

        App.setRoot("secondary");
    }
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public PrimaryController(){
        
    }
}
