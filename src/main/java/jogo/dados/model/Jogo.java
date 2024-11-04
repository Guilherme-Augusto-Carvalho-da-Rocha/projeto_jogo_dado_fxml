package jogo.dados.model;
//testando

import java.util.ArrayList;

public class Jogo {
    private Dado dado1 = new Dado();
    private Dado dado2 = new Dado();
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    

    public Dado getDado1() {
        return dado1;
    }
    public Dado getDado2() {
        return dado2;
    }
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

}

