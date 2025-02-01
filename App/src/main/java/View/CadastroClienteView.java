package View;

import Controller.CadastarClienteController;
import Model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class    CadastroClienteView extends JFrame {
    private JTextField nomeField, telefoneField, emailField, cpfField, dataNascimentoField,
            bairroField, ruaField, numeroRuaField, cidadeField, estadoField, cepField;
    private JButton cadastrarButton;

    private CadastarClienteController controller;

    public CadastroClienteView(CadastarClienteController controller) {
        this.controller = controller;


        setTitle("Cadastro de Cliente");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // CENTRALIZA


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
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cadastrarCliente()){
                    JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!");
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!");
                }

            }
        });
        panel.add(cadastrarButton);

        add(panel);
    }

    private boolean cadastrarCliente() {
        try{
            Cliente cliente = new Cliente();
            cliente.setNome(nomeField.getText());
            cliente.setTelefone(telefoneField.getText());
            cliente.setEmail(emailField.getText());
            cliente.setCpf(cpfField.getText());
            cliente.setDataNascimento(dataNascimentoField.getText());
            cliente.setBairro(bairroField.getText());
            cliente.setRua(ruaField.getText());
            cliente.setNumeroRua(Integer.parseInt(numeroRuaField.getText()));
            cliente.setCidade(cidadeField.getText());
            cliente.setEstado(estadoField.getText());
            cliente.setCep(cepField.getText());

            controller.cadastrarClientes(cliente);
            return true;

        }catch(Exception e){
            return false;
        }


    }
}
