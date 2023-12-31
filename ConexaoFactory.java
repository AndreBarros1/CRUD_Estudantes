import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexaoFactory {
    
    private static final String URL = "jdbc:mysql://localhost:3306/crud_ab";    //comando powershell = java -cp ".;./mysql-connector-j-8.2.0.jar" Nome da classe
    private static final String USUARIO = "root";
    private static final String SENHA = "senai";

    private static Connection conexao;

    private ConexaoFactory() {}

    public static Connection getConexao() throws SQLException {
        if (conexao == null) {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        
        return conexao;
    }

}


