package View;

import Controller.CadastarClientesController;
import Controller.ClientesController;
import Model.Clientes;

public class ClientesView {
    private ClientesController controller;
    private CadastarClientesController cadastroController;

    public ClientesView(ClientesController controller , CadastarClientesController cadastroController) {
        this.controller = controller;
        this.cadastroController = cadastroController;
    }

    public void clienteInfos(){
        for (Clientes cliente : cadastroController.getClientesCadastrados()) {
            String infos = controller.pegarInfos(cliente);
            System.out.println(infos);
        }
    }



}
