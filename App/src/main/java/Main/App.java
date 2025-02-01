package Main;

import Controller.CadastarClienteController;
import View.CadastroClienteView;


public class App {
    public void startApp(int opcao) {

        switch(opcao){

            case 0:
                CadastarClienteController controller = new CadastarClienteController();
                CadastroClienteView view = new CadastroClienteView(controller);
                view.setVisible(true);
                break;

            default:
                System.exit(0);
                break;
        }
    }
}
