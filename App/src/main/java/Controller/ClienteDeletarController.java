package Controller;

import Model.Clientes;

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
}
