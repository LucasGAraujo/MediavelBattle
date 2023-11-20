/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Interface.IGerenciarAtaque;
import java.util.Random;



/**
 *
 * @author lucas.garaujo
 */
public class Heroi implements IGerenciarAtaque  {
    private String TipoHeroi;
    private int PdVida;
    private int Forca;
    private int Defesa;
    private int Agilidade;
    private int FatorLadodedado;
    private int FatorQuantJogarDado;
    

    public int getAgilidade() {
        return Agilidade;
    }

    public void setAgilidade(int Agilidade) {
        this.Agilidade = Agilidade;
    }

    
    public Heroi(String TipoHeroi, int PdVida, int Forca, int Defesa, int Agilidade, int Lado, int QuantJogada) {
        this.TipoHeroi = TipoHeroi;
        this.PdVida = PdVida;
        this.Forca = Forca;
        this.Defesa = Defesa;
        this.Agilidade = Agilidade;
        this.FatorLadodedado = Lado;
        this.FatorQuantJogarDado = QuantJogada;
    }

    
    
    public String getTipoHeroi() {
        return TipoHeroi;
    }

    public void setTipoHeroi(String TipoHeroi) {
        this.TipoHeroi = TipoHeroi;
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

    public int getFatorLadodedado() {
        return FatorLadodedado;
    }

    public void setFatorLadodedado(int FatorDanoLadodedado) {
        this.FatorLadodedado = FatorDanoLadodedado;
    }

    public int getFatorQuantJogarDado() {
        return FatorQuantJogarDado;
    }

    public void setFatorQuantJogarDado(int FatorQuantJogarDado) {
        this.FatorQuantJogarDado = FatorQuantJogarDado;
    }

    @Override
    public void Atacar(Jogador jogador, Monstro monstroSelecionado) {
      Random random = new Random();
        int dano = 0;

                    for (int i = 0; i <= jogador.getHeroi().getFatorQuantJogarDado(); i++) {
                        int atacar = random.nextInt(jogador.getHeroi().getFatorLadodedado());
                        dano += atacar;
                    }
                    System.out.println("Herói atacando . . .");
                    System.out.println("As somas de dados foi ... " + dano);
                    int vidaMonstro = monstroSelecionado.getPdVida() - dano;
                    monstroSelecionado.setPdVida(vidaMonstro);

                    System.out.println("Resultado desta rodada...");
                    System.out.println("A vida do monstro agora é: " + monstroSelecionado.getPdVida());
                    System.out.println("");
                System.out.println("------------------");
                System.out.println("");
    }

    
    
    
    
}
