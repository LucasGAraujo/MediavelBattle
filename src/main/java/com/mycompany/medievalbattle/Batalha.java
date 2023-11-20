/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medievalbattle;

import Models.Jogador;
import Models.Kobold;
import Models.Monstro;
import Models.MortoVivo;
import Models.Orc;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
>>>>>>> bb87e367234b242189bde83d50ecbe3390f0d1a6

/**
 *
 * @author lukin
 */
public class Batalha {
<<<<<<< HEAD
    private static final Logger LOGGER = LoggerFactory.getLogger(Batalha.class);
=======
>>>>>>> bb87e367234b242189bde83d50ecbe3390f0d1a6
    private Random random = new Random();
    private Jogador jogador;
    

    public Batalha(Jogador jogador) {
        this.jogador = jogador;
    }

    public void realizarBatalha() {
<<<<<<< HEAD

=======
>>>>>>> bb87e367234b242189bde83d50ecbe3390f0d1a6
        Monstro m1 = new MortoVivo();
        Monstro m2 = new Orc();
        Monstro m3 = new Kobold();
        List<Monstro> listaDeMonstros = new ArrayList<>();
        listaDeMonstros.add(m1);
        listaDeMonstros.add(m2);
        listaDeMonstros.add(m3);
        int monstroSorteado = random.nextInt(3); 
        int valorHeroi = random.nextInt(10) + 1;
        int valorMonstro = random.nextInt(10) + 1;
        Monstro monstroSelecionado = listaDeMonstros.get(monstroSorteado);
<<<<<<< HEAD
        LOGGER.info("    ");
        LOGGER.info("--------------------------------------");
        LOGGER.info("Possíveis monstros a enfrentar ... ");
        LOGGER.info("Monstro    - Ponto de vida - Força - Defesa - Agilidade - Fator de Dano ");
        LOGGER.info("Morto-vivo -     25        -   4   -    0   -     1     -       2d4     ");
        LOGGER.info("ORC        -     20        -   6   -    2   -     2     -       1d8     ");
        LOGGER.info("Kobold     -     20        -   4   -    2   -     4     -       3d2     ");
        LOGGER.info("--------------------------------------");
        LOGGER.info(" ");
        LOGGER.info("Monstro sorteado foi {}", monstroSelecionado.getTipoMonstro());
        LOGGER.info(" ");
        LOGGER.info("--------------------------------------");
        LOGGER.info("Rola-se um dado de 10 faces...");

        while (valorMonstro == valorHeroi) {
            LOGGER.error("Valores iguais...");
            valorMonstro = random.nextInt(10) + 1;
            valorHeroi = random.nextInt(10) + 1;
        }

        LOGGER.debug("Valor Monstro: " + (valorMonstro + monstroSelecionado.getAgilidade()));
        LOGGER.debug("Valor Herói: " + (valorHeroi + jogador.getHeroi().getAgilidade()));
=======
        System.out.println("    ");
        System.out.println("--------------------------------------");
        System.out.println("Possíveis monstros a enfrentar ... ");
        System.out.println("Monstro    - Ponto de vida - Força - Defesa - Agilidade - Fator de Dano ");
        System.out.println("Morto-vivo -     25        -   4   -    0   -     1     -       2d4     ");
        System.out.println("ORC        -     20        -   6   -    2   -     2     -       1d8     ");
        System.out.println("Kobold     -     20        -   4   -    2   -     4     -       3d2     ");
        System.out.println("--------------------------------------");
        System.out.println(" ");
        System.out.println("Monstro sorteado foi " + monstroSelecionado.getTipoMonstro());
        System.out.println(" ");
        System.out.println("--------------------------------------");
        System.out.println("Rola-se um dado de 10 faces...");

        while (valorMonstro == valorHeroi) {
            System.out.println("Valores iguais...");
            valorMonstro = random.nextInt(10) + 1;
            valorHeroi = random.nextInt(10) + 1;
        }
 
        System.out.println("Valor Monstro: " + (valorMonstro + monstroSelecionado.getAgilidade()));
        System.out.println("Valor Herói: " + (valorHeroi + jogador.getHeroi().getAgilidade()));
>>>>>>> bb87e367234b242189bde83d50ecbe3390f0d1a6
        String IniciaAtaque = (valorMonstro > valorHeroi) ? "Monstro inicia" : "Herói inicia";
        boolean  iniciamonstro =  (valorMonstro > valorHeroi) ? true : false;
        System.out.println(IniciaAtaque);
        
        int rodadas = 0; 
        while (jogador.getHeroi().getPdVida() > 0 && monstroSelecionado.getPdVida() > 0) {
            rodadas++;
            if (iniciamonstro) {
                int valorataque = random.nextInt(10) + 1 + monstroSelecionado.getAgilidade() + monstroSelecionado.getForca();
                int valordefesa = random.nextInt(10) + 1 + jogador.getHeroi().getAgilidade() + jogador.getHeroi().getDefesa();
<<<<<<< HEAD
                LOGGER.info("Resultado dado de 10 - Monstro ATACA");
                LOGGER.info("Valor de ataque: {} " , valorataque);
                LOGGER.info("Valor de defesa: {}", valordefesa);
=======
                System.out.println("Resultado dado de 10 - Monstro ATACA");
                System.out.println("Valor de ataque: " + valorataque);
                System.out.println("Valor de defesa: " + valordefesa);
>>>>>>> bb87e367234b242189bde83d50ecbe3390f0d1a6
                System.out.println("");
                System.out.println("------------------");
                System.out.println("");
                if (valorataque <= valordefesa) {
<<<<<<< HEAD
                    LOGGER.info("Valor de ataque igual ou menor... girando rodada");
=======
                    System.out.println("Valor de ataque igual ou menor... girando rodada");
>>>>>>> bb87e367234b242189bde83d50ecbe3390f0d1a6
                    System.out.println("");
                System.out.println("------------------");
                System.out.println("");
                
                } else {  
                    monstroSelecionado.Atacar(jogador,monstroSelecionado);
                }
                iniciamonstro = false;
            } else {
                int valorataque = random.nextInt(10) + 1 + jogador.getHeroi().getAgilidade() + jogador.getHeroi().getForca();
                int valordefesa = random.nextInt(10) + 1 + monstroSelecionado.getAgilidade() + monstroSelecionado.getDefesa();
<<<<<<< HEAD
                LOGGER.info("Resultado dado de 10 - herói ATACA");
                LOGGER.info("Valor de ataque: {} " , valorataque);
                LOGGER.info("Valor de defesa: {}", valordefesa);
=======
                System.out.println("Resultado dado de 10 - herói ATACA");
                System.out.println("Valor de ataque: " + valorataque);
                System.out.println("Valor de defesa: " + valordefesa);
>>>>>>> bb87e367234b242189bde83d50ecbe3390f0d1a6
                System.out.println("");
                System.out.println("------------------");
                System.out.println("");
                if (valorataque <= valordefesa) {
<<<<<<< HEAD
                    LOGGER.info("Valor de ataque igual ou menor... girando rodada");
=======
                    System.out.println("Valor de ataque igual ou menor... girando rodada");
>>>>>>> bb87e367234b242189bde83d50ecbe3390f0d1a6
                    System.out.println("");
                System.out.println("------------------");
                System.out.println("");
                } else {
                    jogador.getHeroi().Atacar(jogador, monstroSelecionado);
                }
                iniciamonstro = true;
            }
        }

        String resultado;
<<<<<<< HEAD
        LOGGER.info("A rodada durou ..." + rodadas);
        if (jogador.getHeroi().getPdVida() <= 0) {
            LOGGER.info("O monstro venceu!");
            resultado = "perdeu";  
        } else {
            LOGGER.info("O herói venceu!");
=======
        System.out.println("A rodada durou ..." + rodadas);
        if (jogador.getHeroi().getPdVida() <= 0) {
            System.out.println("O monstro venceu!");
            resultado = "perdeu";  
        } else {
            System.out.println("O herói venceu!");
>>>>>>> bb87e367234b242189bde83d50ecbe3390f0d1a6
            resultado = "Ganhou";  
        }
        jogador.gravarLog(jogador.getNickName(), jogador.getHeroi().getTipoHeroi(), resultado, monstroSelecionado.getTipoMonstro(), rodadas);
    }
}
