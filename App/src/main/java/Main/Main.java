package Main;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String[] opcoes = {"Cadastrar Cliente", "Listar Clientes", "Deletar Cliente" ,"Sair"};

        while (true) {

            int escolha = JOptionPane.showOptionDialog(
                    null, // Componente pai (null = centro da tela)
                    "Selecione uma opção:", // Mensagem
                    "Menu Principal", // Título da janela
                    JOptionPane.DEFAULT_OPTION, // Tipo de opção
                    JOptionPane.QUESTION_MESSAGE, // Tipo de mensagem
                    null, // Ícone (null = sem ícone)
                    opcoes, // Opções
                    opcoes[0] // Opção padrão
            );
            switch (escolha) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Você escolheu Cadastrar Cliente.");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Você escolheu Listar Clientes.");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0); // Encerra o programa
                    break;
                case 3:
                    break;

                default:
                    System.exit(0);
                    break;
            }
        }
    }
}