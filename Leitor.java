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

public class Leitor extends Thread {

    Cenario cenario;
    private static int ultimo = 0;//atribuir a identidade do escritor anterior
    int id = ultimo++;//aticionando a identidade

    public Leitor(Cenario cenario) {
        this.cenario = cenario;
        if (ultimo > 3) {
            ultimo = 0;//zerando pra nao estourar o maximo do vetor
        }
    }

    @Override
    public void run() {
        while (Acoes.permissaoDeExeThread) {//permicao do botao iniciar

            try {
                if (cenario.texto.getText() != "") {
                    cenario.mutex.acquire();//semaforo de exclusao mutua
                    sleep(500);
                    cenario.rc++;//adicionado quant de leitor
                    if (cenario.rc == 1) {//testanto a quant da regiao critica
                        cenario.db.acquire();//controle entre o escritor e leitor
                    }
                    cenario.mutex.release();//semaforo de exclusao mutua
                    cenario.ler(id);//metodo ler
                    sleep(7000 - cenario.velocidadeLei[id] * 500);//velocidade da thread
                    cenario.naoLer(id);//metodo para de ler

                    cenario.mutex.acquire();//semaforo de exclusao mutua
                    cenario.rc--;//decrementado a quant

                    if (cenario.rc == 0) {//testando a quant
                        cenario.db.release();//controle entre o escritor e leitor
                    }
                    cenario.mutex.release();//semaforo de exclusao mutua

                }
                sleep(3000);
            } catch (InterruptedException ex) {

            }

        }//fim do while

    }//fim do run
}//fim da class
