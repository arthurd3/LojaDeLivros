package Controller;

import Model.Clientes;

public class ClientesController {

    public ClientesController(Clientes cliente) {

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


}
