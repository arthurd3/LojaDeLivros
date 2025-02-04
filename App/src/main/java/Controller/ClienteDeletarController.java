package Controller;

import Model.Clientes;

import javax.swing.*;

public class ClienteDeletarController {
    private CadastarClientesController cadastroController;
    private ClientesController controller;

    public ClienteDeletarController(CadastarClientesController cadastroController , ClientesController clientesController) {
        this.cadastroController = cadastroController;
        this.controller = clientesController;

    }

    public String mostarClientes() {
        if (cadastroController == null) {
            return "Erro: cadastroController não inicializado.";
        }

        StringBuilder infos = new StringBuilder();
        for (Clientes cliente : cadastroController.getClientesCadastrados()) {
            infos.append(controller.pegarInfos(cliente)).append("\n");
        }
        return infos.length() == 0 ? "Vazio" : infos.toString();
    }

    public boolean buscarClientes(String clienteBusca) {
        if (cadastroController == null) {
            return false;
        }

        for (Clientes cliente : cadastroController.getClientesCadastrados()) {
            return cliente.getNome().equals(clienteBusca);
        }

        return false;
    }

    public void excluirClientes(String clienteExcluir) {
        if (cadastroController == null) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR O CLIENTE");
        }else{
            cadastroController.deletarCliente(clienteExcluir);
        }


    }
}
