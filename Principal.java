/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 03/08/2016
* Ultima alteracao: 10/08/2016
* Nome: Leitor/Escritor
* Funcao: Simulacao de escritoes e leitores
/*************************************************************************************/

import java.awt.Color;
import javax.swing.JFrame;

public class Principal {
   
    public static void main(String[] args) {
				//instanciando janela e atribuindo cenario ao mesmo
        Janela janela = new Janela();
        Cenario cenario = new Cenario();
        janela.add(cenario);

       
        janela.setVisible(true);
    }
}
