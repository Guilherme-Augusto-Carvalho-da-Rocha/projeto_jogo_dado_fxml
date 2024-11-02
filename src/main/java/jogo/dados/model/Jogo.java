package jogo.dados.model;
//testando
/*/import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.util.Comparator;

import java.util.List;
import java.io.*;

import jogo.dados.model.dao.JogadorDao;
*/
public class Jogo {
    /*public int qtdJogadores;
    public int resultado;
    ArrayList<String> names = new ArrayList<>();
    public Dado dado1 = new Dado();
    public Dado dado2 = new Dado();
    Jogador j1 = new Jogador();
    Scanner r = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        Jogo jogo = new Jogo();
        JogadorDao jogadorDao = new JogadorDao();
        jogadorDao.getAll();
        jogo.InserirJogadores();
        jogo.InserirApostas();
        jogo.jogarDados();
        jogo.mostrarResultado();
        jogo.mostrarVencedor();
        jogo.r.close();
    }

    public void InserirJogadores(){
        int cod;
        while(true){
            System.out.print("Quantos jogadores participarão da partida? [1 - 11] ");
            cod = r.nextInt();
            if(cod <= 11 && cod >= 1){
                break;
            }else{
                System.out.println("Você inseriu um valor inválido! Digite um valor entre 1 e 11. ");
            }
        }
        setQtdJogadores(cod);
        r.nextLine();
        qtdJogadores = getQtdJogadores();
        for(int i=1; i<=qtdJogadores; i++){
            System.out.print("Qual é o seu nome? ");
            this.names.add(r.nextLine());
        }
    }

    public void InserirApostas(){
        for(int i=0; i< getQtdJogadores(); i++){
            int cod;
            while (true) {
                System.out.print(names.get(i) + ", digite o valor que você deseja apostar para o somatório das faces: ");
                cod = r.nextInt();
                if(cod>=2 && cod <= 12){
                    break;
                }else{
                    System.out.println("Você digitou uma aposta inválida! Digite um valor entre 2 e 12...");
                }
            }
            this.names.set(i,this.names.get(i)+", "+cod);
        }
    }

    public void jogarDados(){
        dado1.setValorFace();
        dado2.setValorFace();
    }

    public void mostrarResultado(){
        setResultado(dado1.getValorFace() + dado2.getValorFace());
        System.out.println("O resultado do lançamento de dados foi "+ getResultado() + ".");

    }

    public boolean mostrarVencedor() throws IOException{
        for (String x : this.names) {
            
            String[] aux = x.split(", ");
            //System.out.println(aux[0] + ", " + aux[1]);
            if(getResultado() == Integer.parseInt(aux[1])){
               System.out.println("O jogador de nome "+ aux[0]  + " venceu! Parabéns!");

               //FUNCIONA
               GuardarRanking(aux);


               return true;
            }
        }

        System.out.println("Nenhum jogador venceu! Rs, pelo visto, eu (máquina), venci!");
        return false;
    }

    public int getQtdJogadores(){
        return this.qtdJogadores;
    }

    public void setQtdJogadores(int newQtdJogadores){
        this.qtdJogadores = newQtdJogadores;
    }

    public int getResultado(){
        return this.resultado;
    }

    public void setResultado(int newResultado){
        this.resultado = newResultado;
    }

    public static void GuardarRanking(String[] newData) throws IOException {
        String filePath = "C:\\Users\\Carlos Magno\\Documents\\Jogo_dados_POO\\demo\\src\\main\\java\\com\\example\\ranking.csv";

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<String[]> rows = new ArrayList<>();

        for (String line : lines) {
            rows.add(line.replace("\"", "").split(","));
        }

        boolean jogadorExistente = false;
        for (String[] row : rows) {
            if (row[0].equals(newData[0].replace("\"", ""))) { // Compara pelo nome do jogador
                int numVitorias = Integer.parseInt(row[1]) + 1;
                row[1] = String.valueOf(numVitorias);
                jogadorExistente = true;
                break;
            }
        }

        if (!jogadorExistente) {
            String[] novoJogador = {newData[0].replace("\"", ""), "1"};
            rows.add(novoJogador);
        }


        rows.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
            }
        });

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(rows);
        }
    }
    
    public void readCsv() throws IOException {
        String filePath = "C:\\Users\\Carlos Magno\\Documents\\Jogo_dados_POO\\demo\\src\\main\\java\\com\\example\\ranking.csv";
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Verifica se o arquivo está vazio
        if (lines.isEmpty()) {
            System.out.println("Nenhum player venceu até agora!");
            return;
        }
        List<String[]> rows = new ArrayList<>();

        for (String line : lines) {
            rows.add(line.replace("\"", "").split(","));
        }
        
        int aux = 0;
        for (String[] row : rows) {
            // Processa cada linha (row)
            System.out.println(String.join(" | ", row));
            aux++;
            if(aux >=4){
                break;
            }
        }
    }*/
}
