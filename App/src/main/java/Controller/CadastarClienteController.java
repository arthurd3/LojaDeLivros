package Controller;

import Model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class CadastarClienteController {

    private List<Cliente> clientesCadastrados;

    public CadastarClienteController() {
        this.clientesCadastrados = new ArrayList<>();
    }

    public void cadastrarClientes(Cliente cliente) {
        clientesCadastrados.add(cliente);
        System.out.println("Cliente cadastrado com sucesso");
    }

    public List<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }
}
