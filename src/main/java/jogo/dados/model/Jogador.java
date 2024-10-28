package jogo.dados.model;

public class Jogador {
    private long id;
    private int winCount;
    public String nome;
    public int valor_aposta;

    public Jogador(){

    }

    public Jogador(long id, int winCount, String nome) {
        this.id = id;
        this.winCount = winCount;
        this.nome = nome;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getWinCount() {
        return winCount;
    }
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getValor_aposta() {
        return valor_aposta;
    }
    public void setValor_aposta(int valor_aposta) {
        this.valor_aposta = valor_aposta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + winCount;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + valor_aposta;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jogador other = (Jogador) obj;
        if (id != other.id)
            return false;
        if (winCount != other.winCount)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (valor_aposta != other.valor_aposta)
            return false;
        return true;
    }
    

}
