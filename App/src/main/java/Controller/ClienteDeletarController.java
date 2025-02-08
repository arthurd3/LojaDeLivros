package Controller;


import Model.Clientes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDeletarController {
    private CadastarClientesController cadastroController;

    public ClienteDeletarController(CadastarClientesController cadastroController) {
        this.cadastroController = cadastroController;

    }

    public void excluirClientes(String clienteExcluir) {
        cadastroController.deletarCliente(clienteExcluir);
    }

    protected List<Clientes> deletarCliente(String nomeField) {

        List<Clientes> clientes = cadastroController.getClientesCadastrados();

        try {
            clientes.removeIf(cliente -> cliente.getNome().equals(nomeField));
            return clientes;

        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return clientes;
    }
}
