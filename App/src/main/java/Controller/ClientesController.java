package Controller;

import Model.Clientes;

public class ClientesController {
    private Clientes cliente;
    private CadastarClientesController cadastroController;

    public ClientesController(Clientes cliente , CadastarClientesController cadastroController) {
        this.cadastroController = cadastroController;
        this.cliente = cliente;
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

        StringBuilder infos = new StringBuilder();
        for (Clientes cliente : cadastroController.getClientesCadastrados()) {
            infos.append(pegarInfos(cliente)).append("\n");
        }
        return infos.length() == 0 ? "Vazio" : infos.toString();
    }

    public boolean buscarClientes(String clienteBusca ) {
        if (cadastroController == null) {
            System.out.println("Erro: cadastroController está nulo!");
            return false;
        }

        for (Clientes clientes : cadastroController.getClientesCadastrados()) {
            return clientes.getNome().equals(clienteBusca);
        }

        System.out.println("erro");
        return false;
    }


    public Clientes buscarClientesObj(String clienteBusca) {
        if (cadastroController == null) {
            System.out.println("Erro: cadastroController está nulo!");
            return null;
        }

        for (Clientes clientes : cadastroController.getClientesCadastrados()) {
            if(clientes.getNome().equals(clienteBusca)){
                return clientes;
            }else{
                return null;
            }
        }

        System.out.println("erro");
        return null;
    }

}
