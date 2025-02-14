package Main;

import Controller.CadastarClientesController;
import Controller.ClienteDeletarController;
import Controller.ClientesController;
import Model.Clientes;
import View.CadastroClientesView;
import View.ClienteDeletarView;
import View.ClienteEditarView;
import View.ClientesView;

import javax.swing.*;

public class Main {
    private static Main main = new Main();
    private static ClienteDeletarController clienteDeletarController = new ClienteDeletarController(new CadastarClientesController(null));
    private static CadastarClientesController cadClienteController = new CadastarClientesController(clienteDeletarController);
    private static ClientesController clienteController = new ClientesController(new Clientes(), cadClienteController);
    private static ClientesView clienteView = new ClientesView(main , clienteController ,cadClienteController);
    private static CadastroClientesView cadClienteView = new CadastroClientesView(main ,cadClienteController);
    private static ClienteDeletarView clienteDeletar = new ClienteDeletarView(main , clienteController , cadClienteController);



    public static void main(String[] args) {
        startMainApp();
    }

    public static void startMainApp() {
        String[] opcoes = {"Cadastrar Cliente", "Listar Clientes", "Deletar Cliente" ,"Editar Cliente"};
        int escolha = JOptionPane.showOptionDialog(
                null, // (null = centro da tela)
                "Selecione uma opção:",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
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
                CadastroClientesView cadastroClientesView = new CadastroClientesView( main,  cadClienteController);
                cadastroClientesView.setVisible(true);
                break;
            case 1:
                clienteView.clienteInfos();
                break;
            case 2:
                ClienteDeletarView clienteDeletarView = new ClienteDeletarView(main , clienteController , cadClienteController);
                clienteDeletarView.setVisible(true);
                break;
            case 3:
                ClienteEditarView clienteEditarView = new ClienteEditarView(main ,cadClienteController , clienteController , clienteDeletar);
                clienteEditarView.setVisible(true);
                break;
            default:
                System.exit(0);
                break;
        }
    }

}