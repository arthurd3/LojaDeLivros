package View;

import Controller.CadastarClientesController;
import Main.Main;
import javax.swing.*;
import java.awt.*;

public class CadastroClientesView extends JFrame {
    private JTextField nomeField, telefoneField, emailField, cpfField, dataNascimentoField,
            bairroField, ruaField, numeroRuaField, cidadeField, estadoField, cepField;
    private JButton cadastrarButton, voltarButton;
    private Main main;
    private CadastarClientesController controller;

    public CadastroClientesView(Main main, CadastarClientesController controller) {
        this.main = main;
        this.controller = controller;

        setTitle("Cadastro de Cliente");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2, 10, 10));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        panel.add(telefoneField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("CPF:"));
        cpfField = new JTextField();
        panel.add(cpfField);

        panel.add(new JLabel("Data de Nascimento:"));
        dataNascimentoField = new JTextField();
        panel.add(dataNascimentoField);

        panel.add(new JLabel("Bairro:"));
        bairroField = new JTextField();
        panel.add(bairroField);

        panel.add(new JLabel("Rua:"));
        ruaField = new JTextField();
        panel.add(ruaField);

        panel.add(new JLabel("Número da Rua:"));
        numeroRuaField = new JTextField();
        panel.add(numeroRuaField);

        panel.add(new JLabel("Cidade:"));
        cidadeField = new JTextField();
        panel.add(cidadeField);

        panel.add(new JLabel("Estado:"));
        estadoField = new JTextField();
        panel.add(estadoField);

        panel.add(new JLabel("CEP:"));
        cepField = new JTextField();
        panel.add(cepField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(e -> {
            if(controller.cadastrarCliente(nomeField ,telefoneField , emailField , cpfField , dataNascimentoField , bairroField , ruaField , numeroRuaField , cidadeField, estadoField , cepField)){
                JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!");
                dispose();
                main.startMainApp();
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
            }
        });
        panel.add(cadastrarButton);

        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(e -> {
            dispose();
            main.startMainApp();
        });
        panel.add(voltarButton);

        add(panel);
    }
}

