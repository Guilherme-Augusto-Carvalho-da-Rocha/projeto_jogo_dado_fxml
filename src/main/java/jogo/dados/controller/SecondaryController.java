package jogo.dados.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import jogo.dados.App;
import jogo.dados.model.Dado;
import jogo.dados.model.dao.JogadorDao;

//loading
public class SecondaryController {
    Dado dado1 = new Dado();
    Dado dado2 = new Dado();

    boolean venceu = false;

    @FXML
    private ImageView carregando;

    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void initialize() throws IOException{
        JogadorDao jogadorDao = new JogadorDao();
        dado1.setValorFace();
        dado2.setValorFace();
        int valor_venceu = dado1.getValorFace() + dado2.getValorFace();
        PrimaryController primaryController = new PrimaryController();
        for (int i = 0; i>10; i++){
            String nome = primaryController.getJogadores().get(i).getNome();
            if(nome == null){
                break;
            } else if(valor_venceu == primaryController.getJogadores().get(i).getValor_aposta()) {
                int j = 0;
                while(jogadorDao.getAll().get(j) != null){
                    if (jogadorDao.getAll().get(j).getNome().equals(primaryController.getJogadores().get(i).getNome())) {
                        primaryController.getJogadores().get(i).setWinCount(jogadorDao.getAll().get(j).getWinCount());
                        primaryController.getJogadores().get(i).improveWinCount();
                        jogadorDao.update(primaryController.getJogadores().get(i), null);
                        primaryController.getJogadores().get(i).setVenceu(true);
                        venceu = primaryController.getJogadores().get(i).getVenceu();
                    } else {
                        primaryController.getJogadores().get(i).improveWinCount();
                        jogadorDao.save(primaryController.getJogadores().get(i));
                        primaryController.getJogadores().get(i).setVenceu(true);
                        venceu = primaryController.getJogadores().get(i).getVenceu();
                    }
                    j++;
                }
            } else if(venceu == true){
                App.setRoot("terciary");
            }
        } 
    }
}

