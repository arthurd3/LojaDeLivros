package Main;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        startMainApp();
    }
    
    public static void startMainApp(){
        App app = new App();

        String[] opcoes = {"Cadastrar Cliente", "Listar Clientes", "Deletar Cliente" ,"Editar Cliente"};
        int escolha = JOptionPane.showOptionDialog(
                null, // Componente pai (null = centro da tela)
                "Selecione uma opção:", // Mensagem
                "Menu Principal", // Título da janela
                JOptionPane.DEFAULT_OPTION, // Tipo de opção
                JOptionPane.QUESTION_MESSAGE, // Tipo de mensagem
                null,
                opcoes, // Opções
                opcoes[0] // Opção padrão
        );

        switch (escolha) {
            case 0:
                app.startApp(0);
                break;
            case 1:
                app.startApp(1);
                break;
            case 2:
                app.startApp(2);
                break;
            case 3:
                app.startApp(3);
                break;
            case 4:
                app.startApp(4);
                break;
            default:
                System.exit(0);
                break;
        }
    }
}