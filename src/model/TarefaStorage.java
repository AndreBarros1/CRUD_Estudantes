package model;

import java.util.ArrayList;
import java.util.List;

public class TarefaStorage {

	public static void inserir(Tarefa tarefa) {
		String query = "INSERT INTO tarefa (nome, descricao) VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConexaoFactory.getConexao(); TODO: conectar 
			stmt = conn.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, tarefa.getNome());
			stmt.setString(2, tarefa.getDescricao());
			stmt.execute();

			rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				tarefa.setid(rs.getInt(1));
			}

			}catch (Exception e) {
				e.printStackTrace();
			}

	} //fim inserir

	public static void atualizar(Tarefa tarefa) {
		String query = "UPDATE tarefa SET nome = ?, descricao = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConexaoFactory.getConexao(); TODO: conectar 
			stmt = conn.preparedStatement(query);
			stmt.setString(1, tarefa.getNome());
			stmt.setString(2, tarefa.getDescricao());
			stmt.setInt(3, tarefa.getId());
			stmt.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}

	} //fim att

	public static void remover(Tarefa tarefa) {
		String query = "DELETE FROM tarefa WHERE id = ? ";

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConexaoFactory.getConexao(); TODO: conectar 
			stmt = conn.preparedStatement(query);
			stmt.setInt(1, tarefa.getId());
			stmt.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}
	}// fim remover

	public static List<Tarefa> listar() {
		ArrayList<Tarefa> tarefas = new  ArrayList<>();

		String query = "SELECT id, nome, descricao FROM tarefa ORDER BY id";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConexaoFactory.getConexao(); TODO: conectar

			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while(rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getInt("id"));
				tarefa.setNome(rs.getString("nome"));
				tarefa.setDescricao(rs.getString("descricao"));

				tarefas.add(tarefa);

			}
		}catch (Exception e) {
			e.printStackTrace();

		}
				return tarefas;
	} //fim listar
}
