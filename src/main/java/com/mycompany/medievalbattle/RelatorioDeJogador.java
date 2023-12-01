/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medievalbattle;

/**
 *
 * @author lukin
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioDeJogador {

    public String getMonstroEnfrentado() {
        return obterMonstroMaisEnfrentado();
    }

    public String getHeroiMaisJogado() {
        return obterHeroiMaisJogado();
    }

    private static class RegistroDeJogador {
        private String dataDaPartida;
        private String heroiEscolhido;
        private String resultado;
        private String monstroEnfrentado;
        private int quantidadeDeRodadas;

        public RegistroDeJogador(String dataDaPartida, String heroiEscolhido, String resultado, String monstroEnfrentado, int quantidadeDeRodadas) {
            this.dataDaPartida = dataDaPartida;
            this.heroiEscolhido = heroiEscolhido;
            this.resultado = resultado;
            this.monstroEnfrentado = monstroEnfrentado;
            this.quantidadeDeRodadas = quantidadeDeRodadas;
        }

        public String getHeroiEscolhido() {
            return heroiEscolhido;
        }

        public String getMonstroEnfrentado() {
            return monstroEnfrentado;
        }

        public int getQuantidadeDeRodadas() {
            return quantidadeDeRodadas;
        }
    }

    private List<RegistroDeJogador> registros;

    public RelatorioDeJogador() {
        this.registros = new ArrayList<>();
    }

    public void carregarRegistrosDoJogador(String nicknameDoJogador) {
        String diretorioLogs = "temp/";
        String nomeArquivo = nicknameDoJogador + ".csv";
        Path caminhoArquivo = Paths.get(diretorioLogs, nomeArquivo);

        if (!Files.exists(caminhoArquivo)) {
            System.err.println("Arquivo não encontrado: " + caminhoArquivo.toString());
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo.toFile()))) {
            registros = br.lines()
                    .map(line -> line.split(";"))
                    .map(parts -> new RegistroDeJogador(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }

    public String obterHeroiMaisJogado() {
        Map<String, Long> heroisMaisJogados = registros.stream()
                .collect(Collectors.groupingBy(RegistroDeJogador::getHeroiEscolhido, Collectors.counting()));
        return heroisMaisJogados.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum");
    }

    public String obterMonstroMaisEnfrentado() {
        Map<String, Long> monstrosMaisEnfrentados = registros.stream()
                .collect(Collectors.groupingBy(RegistroDeJogador::getMonstroEnfrentado, Collectors.counting()));
        return monstrosMaisEnfrentados.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum");
    }

    public int calcularPontuacaoTotal() {
        return registros.stream()
                .mapToInt(RegistroDeJogador::getQuantidadeDeRodadas)
                .map(rodadas -> 100 - rodadas)
                .sum();
    }
}

