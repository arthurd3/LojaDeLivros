package View;

import Model.Cliente;

public class ClienteView {
    private Cliente cliente;

    public ClienteView(Cliente cliente) {
        this.cliente = cliente;
    }


    public void clienteInfos(){
        cliente.toString();

    }


}
