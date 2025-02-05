package View;

import Controller.CadastarClientesController;
import Controller.ClientesController;
import Main.Main;
import Model.Clientes;

import javax.swing.*;
import java.awt.*;


public class ClientesView extends JFrame {
    private Clientes clientes;
    private ClientesController controller;
    private CadastarClientesController cadastroController;
    private Main main;
    public ClientesView(Main main, ClientesController controller , CadastarClientesController cadastroController) {
        this.cadastroController = cadastroController;
        this.main = main;
        this.controller = new ClientesController(clientes , cadastroController);
    }


    public void clienteInfos(){

        JFrame listaClientesFrame = new JFrame("Lista de Clientes");
        listaClientesFrame.setSize(500, 400);
        listaClientesFrame.setLocationRelativeTo(null);
        listaClientesFrame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        listaClientesFrame.add(scrollPane, BorderLayout.CENTER);


        String infos = controller.mostarClientes();
        textArea.append(infos + "\n");

        // Botão de Voltar
        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(e -> {
            listaClientesFrame.dispose();
            main.startMainApp();
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(voltarButton);
        listaClientesFrame.add(buttonPanel, BorderLayout.SOUTH);

        listaClientesFrame.setVisible(true);

    }


}
