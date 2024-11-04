package jogo.dados.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import jogo.dados.App;
import jogo.dados.model.Jogador;
import jogo.dados.model.Jogo;
import jogo.dados.model.dao.DadoDao;
import jogo.dados.model.dao.JogadorDao;

//inserir jogadores e apostas
public class PrimaryController {
    Jogo jogo = new Jogo();

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
        setJogadores();
        VerificarVitoria();
        App.setRoot("secondary");
    }

    public void  setJogadores(){
        ArrayList<Jogador> jogadores = new ArrayList<>();
        ArrayList<TextField> caixas = new ArrayList<>();
        ArrayList<TextField> apostas = new ArrayList<>();

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
                jogo.setJogadores(jogadores);
            }
        }
        
    }

    public Jogo getJogo(){
        return this.jogo;
    }

    public void VerificarVitoria(){
        boolean venceu = false;
        DadoDao dadoDao = new DadoDao();
        JogadorDao jogadorDao = new JogadorDao();
        jogo.getDado1().randomValorFace();
        jogo.getDado2().randomValorFace();
        int valor_venceu = jogo.getDado1().getValorFace() + jogo.getDado2().getValorFace();
        dadoDao.save(jogo.getDado1());
        dadoDao.save(jogo.getDado2());
        for (int i = 0; i>10; i++){
            String nome = jogo.getJogadores().get(i).getNome();
            if(nome == null){
                break;
            } else if(valor_venceu == jogo.getJogadores().get(i).getValor_aposta()) {
                int j = 0;
                while(jogadorDao.getAll().get(j) != null){
                    if (jogadorDao.getAll().get(j).getNome().equals(jogo.getJogadores().get(i).getNome())) {
                        jogo.getJogadores().get(i).setWinCount(jogadorDao.getAll().get(j).getWinCount());
                        jogo.getJogadores().get(i).setId(jogadorDao.getAll().get(j).getId());
                        jogo.getJogadores().get(i).improveWinCount();
                        jogadorDao.update(jogo.getJogadores().get(i), null);
                        jogo.getJogadores().get(i).setVenceu(true);
                        venceu = jogo.getJogadores().get(i).getVenceu();
                    } 
                    j++;
                }
                if(venceu == false){
                    jogo.getJogadores().get(i).improveWinCount();
                    jogadorDao.save(jogo.getJogadores().get(i));
                    jogo.getJogadores().get(i).setVenceu(true);
                    venceu = jogo.getJogadores().get(i).getVenceu();
                    }
                }
            }
        }
    }
