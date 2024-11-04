package jogo.dados.model;

import java.util.Random;

public class Dado {
    private long id;
    private int valorFace;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValorFace() {
        return this.valorFace;
    }

    public void setValorFace(int valorFace) {
        this.valorFace = valorFace;
    }

    public void randomValorFace(){
        Random random = new Random();
        this.valorFace = random.nextInt(6) + 1;
    }
}
