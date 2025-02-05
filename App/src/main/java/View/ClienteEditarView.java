package View;

import Controller.CadastarClientesController;
import Main.Main;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ClienteEditarView extends JFrame {

    private JTextField nomeField, telefoneField, emailField, cpfField, dataNascimentoField,
            bairroField, ruaField, numeroRuaField, cidadeField, estadoField, cepField;
    private JButton cadastrarButton, voltarButton;
    private Main main;
    private CadastarClientesController cadController;

    public ClienteEditarView(Main main, CadastarClientesController cadController) {
        this.main = main;
        this.cadController = cadController;

        setTitle("EDITAR CLIENTE");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2, 10, 10));
        panel.setBorder(new TitledBorder("Dados do Cliente"));

        panel.add(criarLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(criarLabel("Telefone:"));
        telefoneField = new JTextField();
        panel.add(telefoneField);

        panel.add(criarLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(criarLabel("CPF:"));
        cpfField = new JTextField();
        panel.add(cpfField);

        panel.add(criarLabel("Data de Nascimento:"));
        dataNascimentoField = new JTextField();
        panel.add(dataNascimentoField);

        panel.add(criarLabel("Bairro:"));
        bairroField = new JTextField();
        panel.add(bairroField);

        panel.add(criarLabel("Rua:"));
        ruaField = new JTextField();
        panel.add(ruaField);

        panel.add(criarLabel("Número da Rua:"));
        numeroRuaField = new JTextField();
        panel.add(numeroRuaField);

        panel.add(criarLabel("Cidade:"));
        cidadeField = new JTextField();
        panel.add(cidadeField);

        panel.add(criarLabel("Estado:"));
        estadoField = new JTextField();
        panel.add(estadoField);

        panel.add(criarLabel("CEP:"));
        cepField = new JTextField();
        panel.add(cepField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        cadastrarButton = new JButton("Cadastrar");

        cadastrarButton.addActionListener(e -> {

        });

        buttonPanel.add(cadastrarButton);

        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(e -> {
            limparCampos();
            dispose();
            main.startMainApp();
        });

        buttonPanel.add(voltarButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

    private void limparCampos() {
        nomeField.setText(null);
        telefoneField.setText(null);
        emailField.setText(null);
        cpfField.setText(null);
        dataNascimentoField.setText(null);
        bairroField.setText(null);
        ruaField.setText(null);
        numeroRuaField.setText(null);
        cidadeField.setText(null);
        estadoField.setText(null);
        cepField.setText(null);
    }


}
