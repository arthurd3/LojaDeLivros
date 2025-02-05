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

    public boolean cadastrarCliente(String nomeField, String telefoneField, String emailField, String cpfField, String dataNascimentoField, String bairroField, String ruaField, String numeroRuaField, String cidadeField, String estadoField, String cepField) {

        if (nomeField.trim().isEmpty() || telefoneField.trim().isEmpty() || emailField.trim().isEmpty() ||
                cpfField.trim().isEmpty() || dataNascimentoField.trim().isEmpty() || bairroField.trim().isEmpty() ||
                ruaField.trim().isEmpty() || numeroRuaField.trim().isEmpty() || cidadeField.trim().isEmpty() ||
                estadoField.trim().isEmpty() || cepField.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }


        Clientes cliente = new Clientes();
        cliente.setNome(nomeField);
        cliente.setTelefone(telefoneField);
        cliente.setEmail(emailField);
        cliente.setCpf(cpfField);
        cliente.setDataNascimento(dataNascimentoField);
        cliente.setBairro(bairroField);
        cliente.setRua(ruaField);
        cliente.setNumeroRua(numeroRuaField);
        cliente.setCidade(cidadeField);
        cliente.setEstado(estadoField);
        cliente.setCep(cepField);

        try {
            clientesCadastrados.add(cliente);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public List<Clientes> getClientesCadastrados() {
        return clientesCadastrados;
    }



    public void deletarCliente(String nomeField) {
       try {
           clientesCadastrados.removeIf(cliente -> cliente.getNome().equals(nomeField));

       }catch (NullPointerException e){
           JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
       }
    }
}


