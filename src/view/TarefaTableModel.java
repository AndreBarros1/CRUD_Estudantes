package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Tarefa;

public class TarefaTableModel extends AbstractTableModel {
	private List<Tarefa> tarefas = new ArrayList<Tarefa>();
	private String[] colunas = new String[] { "Id", "Nome", "Descrição" };

	public TarefaTableModel(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public int getRowCount() {
		return tarefas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String columnName = null;

		if (columnIndex >= 0 && columnIndex < colunas.length) {
			columnName = colunas[columnIndex];
		}
		return columnName;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = null;

		if (rowIndex >= 0 && rowIndex < tarefas.size()) {
			Tarefa tarefa = tarefas.get(rowIndex);

			switch (columnIndex) {
			case 0:
				value = Integer.toString(tarefa.getId());
				break;
			case 1:
				value = tarefa.getNome();
				break;
			case 2:
				value = tarefa.getDescricao();
				break;
			default:
				System.err.printf("[ERRO] Índice de coluna inválido: %d\n", columnIndex);
			}
		}

		return value;
	}

	public Tarefa getTarefa(int rowIndex) {
		Tarefa tarefa = null;

		if (rowIndex >= 0 && rowIndex < tarefas.size()) {
			tarefa = tarefas.get(rowIndex);
		}

		return tarefa;
	}

	public void carregar(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
		fireTableDataChanged();
	}

	public void remover(Tarefa tarefa) {
		tarefas.remove(tarefa);
		fireTableDataChanged();
	}

} // fim da classe TarefaTabelaModel
