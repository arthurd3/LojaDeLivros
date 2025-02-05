package Controller;

import Model.Clientes;

public class ClientesController {
    private Clientes cliente;
    private CadastarClientesController cadastroController;

    public ClientesController(Clientes cliente ,CadastarClientesController cadastroController  ) {
        this.cliente = cliente;
        this.cadastroController = cadastroController;
    }

    public String pegarInfos(Clientes cliente) {

        String infos =
                "Id: " + cliente.getId() + "\n" +
                "Nome: " + cliente.getNome() + "\n" +
                "Estado: " + cliente.getEstado() + "\n" +
                "Cep: " + cliente.getCep() + "\n" +
                "CPF: " + cliente.getCpf() + "\n" +
                "Nascimento: " + cliente.getDataNascimento() + "\n" +
                "Telefone: " + cliente.getTelefone() + "\n" +
                "Email: " + cliente.getEmail() + "\n" +
                "Endereço: " + cliente.getNumeroRua() + ", " +
                cliente.getBairro() + ", " +
                cliente.getCidade() + ", " +
                cliente.getEstado() + " - " +
                cliente.getCep() + "\n";

        return infos;

    }


    public String mostarClientes() {
        if (cadastroController == null) {
            return "Erro: cadastroController não inicializado.";
        }

        StringBuilder infos = new StringBuilder();
        for (Clientes cliente : cadastroController.getClientesCadastrados()) {
            infos.append(pegarInfos(cliente)).append("\n");
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

}
