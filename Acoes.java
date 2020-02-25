/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 03/08/2016
* Ultima alteracao: 10/08/2016
* Nome: Leitor/Escritor
* Funcao: Simulacao de escritoes e leitores
/*************************************************************************************/
import java.awt.event.*;

public class Acoes implements ActionListener {
    
    private Cenario cenario;
    private Janela janela;
    public static boolean permissaoDeExeThread = false; // variavel que permite o loop dos threads

    public Acoes(Cenario cenario) { // construtor da classe
        this.cenario = cenario;
        
    }//fim construtor da classe

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cenario.volumeLeitorMais[0]) { // se o botao pressionado foi o de aumentar a velocidade
            
            if (cenario.velocidadeLei[0] >= 1) {
                cenario.velocidadeLei[0]--;  //fim if
            }
            
            cenario.tituloVelocidadeLeitor[0].setText("VELOCIDADE: " + (10 - cenario.velocidadeLei[0])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeLeitorMais[1]) { // se o botao pressionado foi o de aumentar a velocidade
           
            if (cenario.velocidadeLei[1] >= 1) {
                cenario.velocidadeLei[1]--;  //fim if
            }
            
            cenario.tituloVelocidadeLeitor[1].setText("VELOCIDADE: " + (10 - cenario.velocidadeLei[1])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeLeitorMais[2]) { // se o botao pressionado foi o de aumentar a velocidade
          
            if (cenario.velocidadeLei[2] >= 1) {
                cenario.velocidadeLei[2]--;  //fim if
            }
            
            cenario.tituloVelocidadeLeitor[2].setText("VELOCIDADE: " + (10 - cenario.velocidadeLei[2])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeLeitorMais[3]) { // se o botao pressionado foi o de aumentar a velocidade
            
            if (cenario.velocidadeLei[3] >= 1) {
                cenario.velocidadeLei[3]--;  //fim if
            }
            
            cenario.tituloVelocidadeLeitor[3].setText("VELOCIDADE: " + (10 - cenario.velocidadeLei[3])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeLeitorMenos[0]) { // se o botao pressionado foi o de diminuir a velocidade
           
            if (cenario.velocidadeLei[0] < 9) {
                cenario.velocidadeLei[0]++;  //fim if
            }
            
            cenario.tituloVelocidadeLeitor[0].setText("VELOCIDADE: " + (10 - cenario.velocidadeLei[0])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeLeitorMenos[1]) { // se o botao pressionado foi o de diminuir a velocidade
        
            if (cenario.velocidadeLei[1] < 9) {
                cenario.velocidadeLei[1]++;  //fim if
            }
            
            cenario.tituloVelocidadeLeitor[1].setText("VELOCIDADE: " + (10 - cenario.velocidadeLei[1])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeLeitorMenos[2]) { // se o botao pressionado foi o de diminuir a velocidade
          
            if (cenario.velocidadeLei[2] < 9) {
                cenario.velocidadeLei[2]++;  //fim if
            }
            
            cenario.tituloVelocidadeLeitor[2].setText("VELOCIDADE: " + (10 - cenario.velocidadeLei[2])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeLeitorMenos[3]) { // se o botao pressionado foi o de diminuir a velocidade
          
            if (cenario.velocidadeLei[3] < 9) {
                cenario.velocidadeLei[3]++;  //fim if
            }
            
            cenario.tituloVelocidadeLeitor[3].setText("VELOCIDADE: " + (10 - cenario.velocidadeLei[3])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeEscritorMais[0]) { // se o botao pressionado foi o de aumentar a velocidade
        
            if (cenario.velocidadeEsc[0] >= 1) {
                cenario.velocidadeEsc[0]--;  //fim if
            }
            
            cenario.tituloVelocidadeEscritor[0].setText("VELOCIDADE: " + (10 - cenario.velocidadeEsc[0])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeEscritorMais[1]) { // se o botao pressionado foi o de aumentar a velocidade
           
            if (cenario.velocidadeEsc[1] >= 1) {
                cenario.velocidadeEsc[1]--;  //fim if
            }
            
            cenario.tituloVelocidadeEscritor[1].setText("VELOCIDADE: " + (10 - cenario.velocidadeEsc[1])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeEscritorMais[2]) { // se o botao pressionado foi o de aumentar a velocidade
      
            if (cenario.velocidadeEsc[2] >= 1) {
                cenario.velocidadeEsc[2]--;  //fim if
            }
            
            cenario.tituloVelocidadeEscritor[2].setText("VELOCIDADE: " + (10 - cenario.velocidadeEsc[2])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeEscritorMais[3]) { // se o botao pressionado foi o de aumentar a velocidade
       
            if (cenario.velocidadeEsc[3] >= 1) {
                cenario.velocidadeEsc[3]--;  //fim if
            }
            
            cenario.tituloVelocidadeEscritor[3].setText("VELOCIDADE: " + (10 - cenario.velocidadeEsc[3])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeEscritorMenos[0]) { // se o botao pressionado foi o de diminuir a velocidade
          
            if (cenario.velocidadeEsc[0] < 9) {
                cenario.velocidadeEsc[0]++;  //fim if
            }
            
            cenario.tituloVelocidadeEscritor[0].setText("VELOCIDADE: " + (10 - cenario.velocidadeEsc[0])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeEscritorMenos[1]) { // se o botao pressionado foi o de diminuir a velocidade
        
            if (cenario.velocidadeEsc[1] < 9) {
                cenario.velocidadeEsc[1]++;  //fim if
            }
            
            cenario.tituloVelocidadeEscritor[1].setText("VELOCIDADE: " + (10 - cenario.velocidadeEsc[1])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeEscritorMenos[2]) { // se o botao pressionado foi o de diminuir a velocidade
        
            if (cenario.velocidadeEsc[2] < 9) {
                cenario.velocidadeEsc[2]++;  //fim if
            }
            
            cenario.tituloVelocidadeEscritor[2].setText("VELOCIDADE: " + (10 - cenario.velocidadeEsc[2])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.volumeEscritorMenos[3]) { // se o botao pressionado foi o de diminuir a velocidade

            if (cenario.velocidadeEsc[3] < 9) {
                cenario.velocidadeEsc[3]++;  //fim if
            }
            
            cenario.tituloVelocidadeEscritor[3].setText("VELOCIDADE: " + (10 - cenario.velocidadeEsc[3])); //imprimindo o feedback na tela

        } //fim if
        else if (e.getSource() == cenario.iniciar) {//se  o botao pressionado foi o de iniciar
            cenario.iniciar.setEnabled(false);
            permissaoDeExeThread = true;
            for (int i = 0; i < 4; i++) {
                Escritor escritor = new Escritor(cenario);
                escritor.start();
            }
            for (int i = 0; i < 4; i++) {
                Leitor leitor = new Leitor(cenario);
                leitor.start();
            }
            
        } //fim else if
       
    }//fim run

}//fim class
