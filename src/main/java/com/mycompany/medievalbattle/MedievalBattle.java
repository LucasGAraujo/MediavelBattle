/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.medievalbattle;

import Models.*;
import java.util.*;


/**
 *
 * @author lukin
 */
import java.util.Scanner;

public class MedievalBattle {

    public static void main(String[] args) {
        boolean menuAtivo = true;
        
        while (menuAtivo) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("[1] - Iniciar programa ");
            System.out.println("[2] - Gerar relatório ");
            System.out.println("[0] - Sair");
            int opcaoMenu1 = scanner.nextInt();
            switch (opcaoMenu1) {
                case 1:
                    Menu menu = new Menu();
                    menu.iniciarMenu();
                    break;
                case 2:  
                    Scanner n1 = new Scanner(System.in);
                    RelatorioDeJogador relatorio = new RelatorioDeJogador();
                    System.out.println("Digite o nickname");
                    String nicknameDoJogador = n1.next();
                    relatorio.carregarRegistrosDoJogador(nicknameDoJogador);
                    System.out.println("Herói mais jogado: " + relatorio.obterHeroiMaisJogado());
                    System.out.println("Monstro mais enfrentado: " + relatorio.obterMonstroMaisEnfrentado());
                    System.out.println("Pontuação total: " + relatorio.calcularPontuacaoTotal());
                break;
                case 0:
                    menuAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}

