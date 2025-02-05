package View;

import Controller.CadastarClientesController;
import Controller.ClienteDeletarController;
import Controller.ClientesController;
import Model.Clientes;

import javax.swing.*;
import java.awt.*;


public class ClientesView extends JFrame {
    private Clientes clientes;
    private ClientesController controller;
    private CadastarClientesController cadastroController;

    public ClientesView(ClientesController controller , CadastarClientesController cadastroController) {
        this.cadastroController = cadastroController;
        this.controller = new ClientesController(clientes ,  cadastroController);
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
        voltarButton.addActionListener(e -> listaClientesFrame.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(voltarButton);
        listaClientesFrame.add(buttonPanel, BorderLayout.SOUTH);

        listaClientesFrame.setVisible(true);

    }


}
