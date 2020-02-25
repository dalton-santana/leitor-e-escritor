/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 03/08/2016
* Ultima alteracao: 10/08/2016
* Nome: Leitor/Escritor
* Funcao: Simulacao de escritoes e leitores
/*************************************************************************************/

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritor extends Thread {
	//atributos da classe 
  Cenario cenario;
  private static int ultimo = 0;//atribuir a identidade do escritor anterior
  int id = ultimo++;//aticionando a identidade
	
  public Escritor(Cenario cenario) {
    this.cenario = cenario;
    if (ultimo > 3) {
      ultimo = 0;//zerando pra nao estourar o maximo do vetor
    }
  }

  @Override
  public void run() {
    while (Acoes.permissaoDeExeThread) {//permicao do botao iniciar
      escrever();//metodo 
    }
  }
	//metodo que que escreve no livro
  public void escrever() {
    try {
      cenario.db.acquire();//controle entre o escritor e leitor
      cenario.escrever(id);//escrevendo
      sleep(7000 - cenario.velocidadeEsc[id] * 500);//velocidade do escritor
      cenario.pensarEscritor(id);//metodo de o escritor parar de escrever
      cenario.db.release();//devolvendo permissao
      sleep(1000);
    } catch (InterruptedException ex) {
    }
  }
}


