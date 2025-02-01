package Main;

import Controller.CadastarClienteController;
import View.CadastroClienteView;

public class Main {
    public static void main(String[] args) {

        CadastarClienteController controller = new CadastarClienteController();
        CadastroClienteView view = new CadastroClienteView(controller);

        view.setVisible(true);
    }
}