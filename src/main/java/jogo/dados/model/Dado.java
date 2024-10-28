package jogo.dados.model;

import java.util.Random;

public class Dado {
    public int valorFace;

    public int getValorFace() {
        return this.valorFace;
    }

    public void setValorFace() {
        Random random = new Random();
        this.valorFace = random.nextInt(6) + 1;
    }
}
