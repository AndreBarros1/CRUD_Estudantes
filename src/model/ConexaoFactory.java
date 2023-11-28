import java.sql.Connection;

public class ConexaoFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    private static final String USER = "root";
    private static final String PASS = "senai";

    private static Connection conexao;

    private ConexaoFactory(){}

    public static Connection getConexao() throws SQLException{
        if (conexao == null){
            conexao = DriverManager.getConnection(URL, USER, PASS);
        }
        return conexao;
    }

    //java -cp ".;./mysql-connector" Todoapp

} //fim classe ConexaoFactory