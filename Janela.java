/**************************************************************************************
* Autor: Dalton Jose Santos Sant'Ana
* Matricula: 201510220
* Inicio: 03/08/2016
* Ultima alteracao: 10/08/2016
* Nome: Leitor/Escritor
* Funcao: Simulacao de escritoes e leitores
/*************************************************************************************/


import javax.swing.JFrame;

public class Janela extends JFrame {

    public Janela() {
				//configurando janela
        super("ESCRITOR/LEITOR");//titulo da janela
        this.setSize(900, 550);//tamanho da janela
        this.setLayout(null);//layout da janela
        this.setDefaultCloseOperation(3);//opcao de fechar janela
        this.setResizable(false);//nao redimisionar
        this.setLocationRelativeTo(null);//colocar no centro
        
       
    }
}
