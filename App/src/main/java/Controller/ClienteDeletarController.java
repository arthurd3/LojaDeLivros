package Controller;


public class ClienteDeletarController {
    private CadastarClientesController cadastroController;

    public ClienteDeletarController(CadastarClientesController cadastroController) {
        this.cadastroController = cadastroController;

    }

    public void excluirClientes(String clienteExcluir) {
        cadastroController.deletarCliente(clienteExcluir);
    }
}
