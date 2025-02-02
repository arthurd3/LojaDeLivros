package Controller;

import Model.Clientes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadastarClientesController {

    private List<Clientes> clientesCadastrados;

    public CadastarClientesController() {
        this.clientesCadastrados = new ArrayList<>();
    }

    public boolean cadastrarCliente(JTextField nomeField, JTextField telefoneField, JTextField emailField, JTextField cpfField, JTextField dataNascimentoField, JTextField bairroField, JTextField ruaField, JTextField numeroRuaField, JTextField cidadeField, JTextField estadoField, JTextField cepField) {
        try{
            Clientes cliente = new Clientes();
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
            clientesCadastrados.add(cliente);

            return true;

        }catch(Exception e){
            return false;
        }

    }

    public List<Clientes> getClientesCadastrados() {
        return clientesCadastrados;
    }
}
