import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cadastro_Crud {

    // Método para inserir um novo cadastro no banco de dados
    // Método para inserir um novo cadastro no banco de dados
    public void inserirCadastro(Cadastro cadastro) {
        try (Connection connection = ConexaoFactory.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Cadastro (nome, idade, email, cep, telefone, usuario, senha, curso, observacoes, ativo) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, cadastro.getNome());
            preparedStatement.setInt(2, cadastro.getIdade());
            preparedStatement.setString(3, cadastro.getEmail());
            preparedStatement.setInt(4, cadastro.getCep());
            preparedStatement.setInt(5, cadastro.getTelefone());
            preparedStatement.setString(6, cadastro.getUsuario());
            preparedStatement.setString(7, cadastro.getSenha());
            preparedStatement.setString(8, cadastro.getCurso().name());
            preparedStatement.setString(9, cadastro.getObservacoes());
            preparedStatement.setString(10, cadastro.getAtivo().name());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para editar um cadastro existente no banco de dados
    public void editarCadastro(int id, Cadastro cadastro) {
        try (Connection connection = ConexaoFactory.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE Cadastro SET nome=?, idade=?, email=?, cep=?, telefone=?, usuario=?, senha=?, curso=?, " +
                             "observacoes=?, ativo=? WHERE id=?")) {

            preparedStatement.setString(1, cadastro.getNome());
            preparedStatement.setInt(2, cadastro.getIdade());
            preparedStatement.setString(3, cadastro.getEmail());
            preparedStatement.setInt(4, cadastro.getCep());
            preparedStatement.setInt(5, cadastro.getTelefone());
            preparedStatement.setString(6, cadastro.getUsuario());
            preparedStatement.setString(7, cadastro.getSenha());
            preparedStatement.setString(8, cadastro.getCurso().name());
            preparedStatement.setString(9, cadastro.getObservacoes());
            preparedStatement.setString(10, cadastro.getAtivo().name());
            preparedStatement.setInt(11, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   // Método para excluir um cadastro do banco de dados
   public void excluirCadastro(int id) {
    try (Connection connection = ConexaoFactory.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Cadastro WHERE id=?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 // Método para listar todos os cadastros no banco de dados
 public List<Cadastro> listarTodosCadastros() {
    List<Cadastro> cadastros = new ArrayList<>();

    try (Connection connection = ConexaoFactory.getConexao();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM Cadastro")) {

        while (resultSet.next()) {
            Cadastro cadastro = new Cadastro();
            cadastro.setNome(resultSet.getString("nome"));
            cadastro.setIdade(resultSet.getInt("idade"));
            cadastro.setEmail(resultSet.getString("email"));
            cadastro.setCep(resultSet.getInt("cep"));
            cadastro.setTelefone(resultSet.getInt("telefone"));
            cadastro.setUsuario(resultSet.getString("usuario"));
            cadastro.setSenha(resultSet.getString("senha"));
            cadastro.setCurso(Cadastro.Curso.valueOf(resultSet.getString("curso")));
            cadastro.setObservacoes(resultSet.getString("observacoes"));
            cadastro.setAtivo(Cadastro.Ativo.valueOf(resultSet.getString("ativo")));
            cadastros.add(cadastro);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return cadastros;
    }

}