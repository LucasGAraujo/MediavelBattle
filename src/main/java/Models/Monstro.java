/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Interface.IGerenciarAtaque;
import java.util.*;
/**
 *
 * @author lucas.garaujo
 */
public class Monstro implements IGerenciarAtaque {
    private String TipoMonstro;
    private int PdVida;
    private int Forca;
    private int Defesa;
    private int Agilidade;
     private int FatorLadodedado;
    private int FatorQuantJogarDado;

    public Monstro(String TipoMonstro, int PdVida, int Forca, int Defesa, int Agilidade,int Lado, int QuantJogada) {
        this.TipoMonstro = TipoMonstro;
        this.PdVida = PdVida;
        this.Forca = Forca;
        this.Defesa = Defesa;
        this.Agilidade = Agilidade;
        this.FatorLadodedado = Lado;
        this.FatorQuantJogarDado = QuantJogada;
    }
    @Override
    public String toString() {
        return " TipoMonstro: " + TipoMonstro +
               ", PdVida: " + PdVida +
               ", Forca: " + Forca +
               ", Defesa: " + Defesa +
               ", Agilidade: " + Agilidade;
    }

    
    
    
    public String getTipoMonstro() {
        return TipoMonstro;
    }

    public void setTipoMonstro(String TipoMonstro) {
        this.TipoMonstro = TipoMonstro;
    }

    public int getPdVida() {
        return PdVida;
    }

    public void setPdVida(int PdVida) {
        this.PdVida = PdVida;
    }

    public int getForca() {
        return Forca;
    }

    public void setForca(int Forca) {
        this.Forca = Forca;
    }

    public int getDefesa() {
        return Defesa;
    }

    public void setDefesa(int Defesa) {
        this.Defesa = Defesa;
    }

    public int getAgilidade() {
        return Agilidade;
    }

    public void setAgilidade(int Agilidade) {
        this.Agilidade = Agilidade;
    }

    public int getFatorLadodedado() {
        return FatorLadodedado;
    }

    public void setFatorLadodedado(int FatorLadodedado) {
        this.FatorLadodedado = FatorLadodedado;
    }

    public int getFatorQuantJogarDado() {
        return FatorQuantJogarDado;
    }

    public void setFatorQuantJogarDado(int FatorQuantJogarDado) {
        this.FatorQuantJogarDado = FatorQuantJogarDado;
    }

    @Override
    public void Atacar(Jogador jogador, Monstro monstroSelecionado ) {
        
       Random random = new Random();
         int dano = 0;
        
                    for (int i = 0; i <= monstroSelecionado.getFatorQuantJogarDado(); i++) {
                        int atacar = random.nextInt(monstroSelecionado.getFatorLadodedado());
                        dano += atacar;
                    }
                    System.out.println("Monstro atacando . . .");
                    System.out.println("As somas de dados foi ... " + dano);
                    int vidaHeroi = jogador.getHeroi().getPdVida() - dano;
                    jogador.getHeroi().setPdVida(vidaHeroi);

                    System.out.println("Resultado desta rodada...");
                    System.out.println("A vida do herói agora é: " + jogador.getHeroi().getPdVida());
                    System.out.println("");
                System.out.println("------------------");
                System.out.println("");
    }

    
    }
