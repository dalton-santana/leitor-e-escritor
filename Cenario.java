/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 03/08/2016
* Ultima alteracao: 10/08/2016
* Nome: Leitor/Escritor
* Funcao: Simulacao de escritoes e leitores
/*************************************************************************************/

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Cenario extends JPanel {
  public static int[] velocidadeEsc = new int[4];//velocidades dos escritores
  public static int[] velocidadeLei = new int[4];//velocidades dos leitores
  JLabel titulo, tituloLeitor, tituloEscritor, imgMao, imgLivro, texto;//tituloos e imagens
  JLabel[] idEscritor = new JLabel[4];//string na tela
  JLabel[] idLeitor = new JLabel[4];//string na tela
  JLabel[] escritores = new JLabel[4];//string na tela
  JLabel[] leitores = new JLabel[4];//string na tela
  JLabel[] tituloVelocidadeEscritor = new JLabel[4];//titulos
  JLabel[] tituloVelocidadeLeitor = new JLabel[4];//titulos
  //controle de velocidades
  JButton[] volumeEscritorMais = new JButton[4];
  JButton[] volumeEscritorMenos = new JButton[4];
  JButton[] volumeLeitorMais = new JButton[4];
  JButton[] volumeLeitorMenos = new JButton[4];
  //butoes
  JButton volumeLeitor1, volumeLeitor2, volumeLeitor3, volumeLeitor4;
  JButton iniciar;
  //semaforos
  Semaphore mutex = new Semaphore(1);//semaforo de exclusao mutua
  Semaphore db = new Semaphore(1);//semaforo para controle entre escritores e leitores
  public static int rc = 0;//quantidade de leitoes lendo

  public Cenario() {
    //configuracoes do painel
    this.setSize(900, 600);
    this.setLayout(null);
    this.setBackground(Color.WHITE);

    //instanciando titulos
    titulo = new JLabel("ESCRITOR/LEITOR");
    titulo.setFont(new Font("Arial", Font.BOLD, 40));
    titulo.setBounds(270, 10, 500, 70);
    this.add(titulo);

    tituloEscritor = new JLabel("Escritor");
    tituloEscritor.setFont(new Font("Arial", Font.BOLD, 18));
    tituloEscritor.setBounds(60, 30, 100, 70);
    this.add(tituloEscritor);

    tituloLeitor = new JLabel("Leitores");
    tituloLeitor.setFont(new Font("Arial", Font.BOLD, 18));
    tituloLeitor.setBounds(760, 30, 100, 70);
    this.add(tituloLeitor);

    //instanciando imagens
    imgMao = new JLabel(new ImageIcon(getClass().getResource("mao.gif")));
    imgMao.setBounds(150, 60, 150, 200);
    imgMao.setVisible(false);
    this.add(imgMao);

    //instanciando strng
    texto = new JLabel();
    texto.setFont(new Font("Arial", Font.ITALIC, 10));
    texto.setBounds(270, 50, 200, 300);
    this.add(texto);

    //instanciando imagem de fundo
    imgLivro = new JLabel(new ImageIcon(getClass().getResource("livro.jpg")));
    imgLivro.setBounds(150, 100, 600, 400);
    this.add(imgLivro);

    //instanciando, definindo local e tamanho de cada imagem dos leitores
    for (int i = 0, x = 90; i < 4; i++) {
      leitores[i] = new JLabel(new ImageIcon(getClass().getResource("lendo.gif")));
      leitores[i].setBounds(630, x, 300, 200);
      leitores[i].setVisible(false);
      this.add(leitores[i]);
      x += 100;
    }
    //instanciando, definindo local e tamanho de cada imagem dos escritores
    for (int i = 0, x = 40; i < 4; i++) {
      escritores[i] = new JLabel(new ImageIcon(getClass().getResource("escritor.jpg")));
      escritores[i].setBounds(90, x, 150, 200);
      escritores[i].setVisible(false);
      this.add(escritores[i]);
      x += 100;
    }
    //instanciando, definindo local e tamanho de cada imagem dos botoes
    iniciar = new JButton("INICIAR");//botao de diminuir consumo
    iniciar.setBounds(400, 470, 100, 30);//tamanho e localizacao do botao
    iniciar.addActionListener(new Acoes(this));//aco do botao
    this.add(iniciar);

    //instanciando strings
    for (int i = 0, x = 100; i < 4; i++) {
      idEscritor[i] = new JLabel("Escritor " + (i));
      idEscritor[i].setBounds(50, x, 120, 30);
      this.add(idEscritor[i]);
      x += 100;
    }
    //instanciando, definindo local e tamanho de cada imagem dos botoes
    for (int i = 0, x = 150; i < 4; i++) {
      volumeEscritorMenos[i] = new JButton("-");
      volumeEscritorMenos[i].setBounds(20, x, 47, 30);
      volumeEscritorMenos[i].addActionListener(new Acoes(this));
      this.add(volumeEscritorMenos[i]);
      x += 100;
    }
    for (int i = 0, x = 150; i < 4; i++) {
      volumeEscritorMais[i] = new JButton("+");
      volumeEscritorMais[i].setBounds(70, x, 47, 30);
      volumeEscritorMais[i].addActionListener(new Acoes(this));
      this.add(volumeEscritorMais[i]);
      x += 100;
    }
    for (int i = 0, x = 120; i < 4; i++) {
      tituloVelocidadeEscritor[i] = new JLabel("VELOCIDADE: 5 ");
      tituloVelocidadeEscritor[i].setBounds(30, x, 120, 30);
      this.add(tituloVelocidadeEscritor[i]);
      x += 100;
    }

    for (int i = 0, x = 100; i < 4; i++) {
      idLeitor[i] = new JLabel("Leitor " + (i));
      idLeitor[i].setBounds(790, x, 120, 30);
      this.add(idLeitor[i]);
      x += 100;
    }

    for (int i = 0, x = 150; i < 4; i++) {
      volumeLeitorMenos[i] = new JButton("-");
      volumeLeitorMenos[i].setBounds(770, x, 47, 30);
      volumeLeitorMenos[i].addActionListener(new Acoes(this));
      this.add(volumeLeitorMenos[i]);
      x += 100;
    }
    for (int i = 0, x = 150; i < 4; i++) {
      volumeLeitorMais[i] = new JButton("+");
      volumeLeitorMais[i].setBounds(820, x, 47, 30);
      volumeLeitorMais[i].addActionListener(new Acoes(this));
      this.add(volumeLeitorMais[i]);
      x += 100;
    }
    for (int i = 0, x = 120; i < 4; i++) {
      tituloVelocidadeLeitor[i] = new JLabel("VELOCIDADE: 5 ");
      tituloVelocidadeLeitor[i].setBounds(770, x, 120, 30);
      this.add(tituloVelocidadeLeitor[i]);
      x += 100;
    }
    //definindo tamanho inicial de cada velocidade
    for (int i = 0; i < 4; i++) {
      velocidadeLei[i] = 5;
      velocidadeEsc[i] = 5;
    }
  }//fim do contrutor

  //metodo de escrever
  public void escrever(int id) {
    escritores[id].setVisible(true);
    texto.setText("Escritor " + id);
    imgMao.setVisible(true);

  }
  //metodo de parar de escrever
  public void pensarEscritor(int id) {
    escritores[id].setVisible(false);
    imgMao.setVisible(false);
  }
  //metodo de ler
  public void ler(int id) {
    leitores[id].setVisible(true);
  }
  //metodo de parar de ler
  public void naoLer(int id) {
    leitores[id].setVisible(false);
  }

}//fim da classe
