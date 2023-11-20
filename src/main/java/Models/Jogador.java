/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Interface.IGerenciar;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lucas.garaujo
 */
public class Jogador implements IGerenciar {
    private int Id = 0;
    private String NickName;
    private Heroi heroi;

    public Jogador(String NickName, Heroi heroi) {
        this.NickName = NickName;
        this.heroi = heroi;
    }

    public int getId() {
        return Id;
    }

    public void setId() {
        this.Id++;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    @Override
    public void gravarLog(String nicknameDoJogador, String heroiEscolhido, String resultado, String monstroEnfrentado, int quantidadeDeRodadas) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDaPartida = new Date();
        String dataDaPartidaStr = dateFormat.format(dataDaPartida);
        String diretorioLogs = "temp/";
        Path diretorioTemp = Paths.get(diretorioLogs);
        if (!Files.exists(diretorioTemp)) {
            try {
                Files.createDirectories(diretorioTemp);
            } catch (IOException e) {
                System.err.println("Erro ao criar o diretório 'temp': " + e.getMessage());
                return;
            }
        }
        String nomeArquivo = nicknameDoJogador + ".csv";
        try (FileWriter fileWriter = new FileWriter(diretorioLogs + nomeArquivo, true);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.printf("%s;%s;%s;%s;%d;%n", dataDaPartidaStr, heroiEscolhido, resultado, monstroEnfrentado, quantidadeDeRodadas);
            System.out.println("Log de batalha gravado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar o log de batalha: " + e.getMessage());
        }
    }
}
