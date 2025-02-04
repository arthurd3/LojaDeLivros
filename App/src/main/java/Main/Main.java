package Main;


import Controller.CadastarClientesController;
import Controller.ClientesController;
import Model.Clientes;
import View.CadastroClientesView;
import View.ClienteDeletarView;
import View.ClientesView;

import javax.swing.*;

public class Main {
    private static Main main = new Main();
    private static ClientesController clienteController = new ClientesController(new Clientes());
    private static CadastarClientesController cadClienteController = new CadastarClientesController();
    private static ClientesView clienteView = new ClientesView(clienteController ,cadClienteController);
    private static CadastroClientesView cadClienteView = new CadastroClientesView(main ,cadClienteController);
    private static ClienteDeletarView clienteDeletar = new ClienteDeletarView(main , clienteController , cadClienteController);


    public static void main(String[] args) {
        startMainApp();
    }

    public static void startMainApp() {
        String[] opcoes = {"Cadastrar Cliente", "Listar Clientes", "Deletar Cliente" ,"Editar Cliente"};
        int escolha = JOptionPane.showOptionDialog(
                null, // Componente pai (null = centro da tela)
                "Selecione uma opção:", // Mensagem
                "Menu Principal", // Título da janela
                JOptionPane.DEFAULT_OPTION, // Tipo de opção
                JOptionPane.QUESTION_MESSAGE, // Tipo de mensagem
                null,
                opcoes, // Opções
                opcoes[0] // Opção padrão
        );

        switch (escolha) {
            case 0:
                startApp(0);
                break;
            case 1:
                startApp(1);
                break;
            case 2:
                startApp(2);
                break;
            case 3:
                startApp(3);
                break;
            case 4:
                startApp(4);
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void startApp(int opcao) {
        switch(opcao){
            case 0:
                cadClienteView.setVisible(true);
                break;
            case 1:
                clienteView.clienteInfos();
                startMainApp();
                break;
            case 2:
                clienteDeletar.setVisible(true);
                break;
            case 3:
                startMainApp();
                break;
            default:
                System.exit(0);
                break;
        }
    }

}