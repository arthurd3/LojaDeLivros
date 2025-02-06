package View;

import Controller.CadastarClientesController;
import Controller.ClientesController;
import Main.Main;
import Model.Clientes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ClienteEditarView extends JFrame {
    private Clientes clientes;
    private JTextField nomeField, telefoneField, emailField, cpfField, dataNascimentoField,
            bairroField, ruaField, numeroRuaField, cidadeField, estadoField, cepField;
    private JButton voltarButton;
    private Main main;
    private CadastarClientesController cadController;
    private ClientesController controller;

    public ClienteEditarView(Main main, CadastarClientesController cadController, ClientesController controller, ClienteDeletarView deletarView) {
        this.main = main;
        this.cadController = cadController;
        this.controller = new ClientesController(clientes, cadController);

        setTitle("Editar Cliente");
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


        // Botão Editar
        JButton editarButton = new JButton("Editar");
        editarButton.addActionListener(e -> {
            setVisible(false);
            String busca = buscaField.getText().trim();
            if (controller.buscarClientes(busca)) {
                editarCliente(busca);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao pesquisar cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                main.startMainApp();
            }
        });
        botoesPanel.add(editarButton);

        // Botão Voltar
        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(e -> {
            dispose();
            main.startMainApp();
        });
        botoesPanel.add(voltarButton);

        // Botão Listar
        JButton listarButton = new JButton("Listar");
        listarButton.addActionListener(e -> deletarView.exibirClientes());
        botoesPanel.add(listarButton);

        panel.add(botoesPanel, BorderLayout.SOUTH);
        add(panel);

        // Inicializar campos
        nomeField = new JTextField();
        telefoneField = new JTextField();
        emailField = new JTextField();
        cpfField = new JTextField();
        dataNascimentoField = new JTextField();
        bairroField = new JTextField();
        ruaField = new JTextField();
        numeroRuaField = new JTextField();
        cidadeField = new JTextField();
        estadoField = new JTextField();
        cepField = new JTextField();


    }

    private JLabel criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

    private void limparCampos() {
        nomeField.setText("");
        telefoneField.setText("");
        emailField.setText("");
        cpfField.setText("");
        dataNascimentoField.setText("");
        bairroField.setText("");
        ruaField.setText("");
        numeroRuaField.setText("");
        cidadeField.setText("");
        estadoField.setText("");
        cepField.setText("");
    }



    private void preencherDados(Clientes cliente) {
        nomeField.setText(cliente.getNome());
        telefoneField.setText(cliente.getTelefone());
        emailField.setText(cliente.getEmail());
        cpfField.setText(cliente.getCpf());
        dataNascimentoField.setText(cliente.getDataNascimento());
        bairroField.setText(cliente.getBairro());
        ruaField.setText(cliente.getRua());
        numeroRuaField.setText(cliente.getNumeroRua());
        cidadeField.setText(cliente.getCidade());
        estadoField.setText(cliente.getEstado());
        cepField.setText(cliente.getCep());
    }

    private void editarCliente(String busca) {
        Clientes clienteObj = controller.buscarClientesObj(busca);

        if (clienteObj == null) {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        preencherDados(clienteObj);


        getContentPane().removeAll();
        revalidate();
        repaint();


        editarView(clienteObj);
    }

    private void editarView(Clientes cliente) {
        setTitle("Editar Cliente");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar painel principal
        JPanel panel = new JPanel(new GridLayout(12, 2, 10, 10));
        panel.setBorder(new TitledBorder("Dados do Cliente"));

        panel.add(criarLabel("Nome:"));
        panel.add(nomeField);
        panel.add(criarLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(criarLabel("Email:"));
        panel.add(emailField);
        panel.add(criarLabel("CPF:"));
        panel.add(cpfField);
        panel.add(criarLabel("Data de Nascimento:"));
        panel.add(dataNascimentoField);
        panel.add(criarLabel("Bairro:"));
        panel.add(bairroField);
        panel.add(criarLabel("Rua:"));
        panel.add(ruaField);
        panel.add(criarLabel("Número da Rua:"));
        panel.add(numeroRuaField);
        panel.add(criarLabel("Cidade:"));
        panel.add(cidadeField);
        panel.add(criarLabel("Estado:"));
        panel.add(estadoField);
        panel.add(criarLabel("CEP:"));
        panel.add(cepField);

        // Criar painel de botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Botão Salvar (Editar)
        JButton editarButton = new JButton("Salvar Alterações");
        editarButton.addActionListener(e -> {
            cliente.setNome(nomeField.getText());
            cliente.setTelefone(telefoneField.getText());
            cliente.setEmail(emailField.getText());
            cliente.setCpf(cpfField.getText());
            cliente.setDataNascimento(dataNascimentoField.getText());
            cliente.setBairro(bairroField.getText());
            cliente.setRua(ruaField.getText());
            cliente.setNumeroRua(numeroRuaField.getText());
            cliente.setCidade(cidadeField.getText());
            cliente.setEstado(estadoField.getText());
            cliente.setCep(cepField.getText());

        });
        botoesPanel.add(editarButton);

        // Botão Voltar
        voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(e -> {
            dispose();
            main.startMainApp();
        });
        botoesPanel.add(voltarButton);

        // Adicionar componentes à janela
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(botoesPanel, BorderLayout.SOUTH);

        // Exibir janela
        setVisible(true);
    }

}
