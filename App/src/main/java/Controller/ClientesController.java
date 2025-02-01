package Controller;

import Model.Clientes;


public class ClientesController {

    private Clientes cliente;

    public ClientesController(Clientes cliente) {
        this.cliente = cliente;
    }

    public String pegarInfos(Clientes cliente) {

        StringBuilder infos = new StringBuilder();
        infos.append("Nome: ").append(cliente.getNome()).append("\n");
        infos.append("Telefone: ").append(cliente.getTelefone()).append("\n");
        infos.append("Email: ").append(cliente.getEmail()).append("\n");
        infos.append("Endereço: ").append(cliente.getNumeroRua()).append(", ")
                .append(cliente.getBairro()).append(", ")
                .append(cliente.getCidade()).append(", ")
                .append(cliente.getEstado()).append(" - ")
                .append(cliente.getCep()).append("\n");

        return infos.toString();

    }


}
