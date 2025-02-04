package View;

import Controller.CadastarClientesController;
import Controller.ClienteDeletarController;
import Controller.ClientesController;
import Main.Main;


import javax.swing.*;
import java.awt.*;

public class ClienteDeletarView extends JFrame {

    private ClientesController controller;
    private CadastarClientesController cadastroController;
    private ClienteDeletarController controllerDeletar;
    private Main main;

    public ClienteDeletarView(Main main, ClientesController controller, CadastarClientesController cadastroController) {
        this.main = main;
        this.controller = controller;
        this.cadastroController = cadastroController;


        this.controllerDeletar = new ClienteDeletarController(cadastroController, controller);
        setTitle("Deletar Cliente");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(60, 10));

        JLabel titulo = new JLabel("Digite o CPF ou Nome do Cliente:");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        JTextField buscaField = new JTextField();
        buscaField.setPreferredSize(new Dimension(250, 20));
        panel.add(buscaField, BorderLayout.CENTER);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));


        //DELETAR
        JButton deletarButton = new JButton("Deletar");
        deletarButton.addActionListener(e -> {
            String busca = buscaField.getText();
            if(controllerDeletar.buscarClientes(busca)){

                controllerDeletar.excluirClientes(busca);
            }

        });
        botoesPanel.add(deletarButton);

        //VOLTAR
        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(e -> {
            dispose();
            main.startMainApp();
        });
        botoesPanel.add(voltarButton);

        panel.add(botoesPanel, BorderLayout.SOUTH);

        //LISTAR
        JButton listarButton = new JButton("Listar");
        listarButton.addActionListener(e -> {
            exibirClientes();
        });
        botoesPanel.add(listarButton);

        panel.add(botoesPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public void exibirClientes() {

        JFrame listaClientesFrame = new JFrame("Lista de Clientes");
        listaClientesFrame.setSize(500, 400);
        listaClientesFrame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        listaClientesFrame.add(scrollPane);

        String infos = controllerDeletar.mostarClientes();
        textArea.append(infos + "\n");

        listaClientesFrame.setVisible(true);
    }
}