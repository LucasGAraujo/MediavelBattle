/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medievalbattle;

import Models.Barbaro;
import Models.Guerreiro;
import Models.Jogador;
import Models.Paladino;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lukin
 */


public class Menu {
    private Random random = new Random();
    private boolean inicia = true;
    private Jogador jogador = null;
    private boolean menu = true;

    public void iniciarMenu() {
        while (inicia) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o seu nickname: ");
            String nome = sc.nextLine();
            System.out.println("");
            System.out.println("Escolha um herói");
            System.out.println("[ ] Herói  - Ponto de vida - Força - Defesa - Agilidade - Fator de Dano ");
            System.out.println(".[1] Guerreiro -     12      -   4   -    3   -     3     -       2d4     ");
            System.out.println("[2] Bárbaro   -     13      -   6   -    1   -     3     -       2d6     ");
            System.out.println("[3] Paladino  -     15      -   2   -    5   -     1    -        2d4     ");
            int opcao;

            try {
                inicia = false;
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        jogador = new Jogador(nome, new Guerreiro());
                        break;
                    case 2:
                        jogador = new Jogador(nome, new Barbaro());
                        break;
                    case 3:
                        jogador = new Jogador(nome, new Paladino());
                        break;
                    default:
                        System.out.println("Opção inválida. Saindo do jogo.");
                        inicia = true;
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, insira um número inteiro.");
                inicia = true;
            }
        }

        Batalha batalha = new Batalha(jogador);
        batalha.realizarBatalha();
    }
}
