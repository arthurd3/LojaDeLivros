package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    public void conexaoBanco() throws SQLException {
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja","root","");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver do Banco de Dados nao Localizado");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao Banco de Dados");
        } finally {
            if(connection != null){
                connection.close();
            }
        }
    }
}
