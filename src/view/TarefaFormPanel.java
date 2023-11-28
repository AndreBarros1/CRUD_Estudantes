package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Tarefa;
import model.TarefaStorage;

public class TarefaFormPanel extends JPanel {
	private static final Insets FIELD_INSETS = new Insets(5, 10, 0, 0);

	private Tarefa tarefa;

	private AppFrame frame;

	private GridBagLayout layout;
	private GridBagConstraints constraints;

	private JTextField idTxt;
	private JTextField nomeTxt;
	private JTextArea descricaoTxt;
	private JButton salvarBtn;
	private JButton cancelarBtn;

	public TarefaFormPanel(AppFrame appFrame) {
		frame = appFrame;

		tarefa = null;

		layout = new GridBagLayout();
		constraints = new GridBagConstraints();

		setLayout(layout);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if (tarefa == null) {
					idTxt.setText("");
					nomeTxt.setText("");
					descricaoTxt.setText("");
				} else {
					idTxt.setText(Integer.toString(tarefa.getId()));
					nomeTxt.setText(tarefa.getNome());
					descricaoTxt.setText(tarefa.getDescricao());
				}
			}
		});

		criarForm();
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	private void criarForm() {
		JLabel rotulo;

		rotulo = new JLabel("Id");
		adicionarComponente(rotulo, 0, 0);
		idTxt = new JTextField(5);
		idTxt.setEditable(false);
		adicionarComponente(idTxt, 0, 1);

		rotulo = new JLabel("Nome");
		adicionarComponente(rotulo, 1, 0);
		nomeTxt = new JTextField(30);
		nomeTxt.setDocument(new MaxCharDocument(30));
		adicionarComponente(nomeTxt, 1, 1);

		rotulo = new JLabel("Descrição");
		adicionarComponente(rotulo, 2, 0);
		descricaoTxt = new JTextArea(5, 30);
		JScrollPane scrollPane = new JScrollPane(descricaoTxt);
		adicionarComponente(scrollPane, 2, 1, 1, 5);

		criarBotoes();
	}

	private void criarBotoes() {
		JPanel btnPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		criarSalvarBtn(btnPanel);
		criarCancelarBtn(btnPanel);

		adicionarComponente(btnPanel, 7, 1, 2, 1);
	}

	private void criarSalvarBtn(JPanel panel) {
		salvarBtn = new JButton("Salvar");
		salvarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tarefa == null) {
					tarefa = new Tarefa();
					tarefa.setNome(nomeTxt.getText());
					tarefa.setDescricao(descricaoTxt.getText());
					TarefaStorage.inserir(tarefa);
				} else {
					tarefa.setId(Integer.parseInt(idTxt.getText()));
					tarefa.setNome(nomeTxt.getText());
					tarefa.setDescricao(descricaoTxt.getText());
					TarefaStorage.atualizar(tarefa);
				}

				JOptionPane.showMessageDialog(TarefaFormPanel.this, "Tarefa salva com sucesso!", AppFrame.titulo,
						JOptionPane.INFORMATION_MESSAGE);

				frame.mostrarListaTarefas();
			}
		});
		panel.add(salvarBtn);
	}

	private void criarCancelarBtn(JPanel panel) {
		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.mostrarListaTarefas();
			}
		});
		panel.add(cancelarBtn);
	}

	private void adicionarComponente(JComponent componente, int linha, int coluna) {
		adicionarComponente(componente, linha, coluna, 1, 1);
	}

	private void adicionarComponente(JComponent componente, int linha, int coluna, int largura, int altura) {
		constraints.gridx = coluna;
		constraints.gridy = linha;
		constraints.gridwidth = largura;
		constraints.gridheight = altura;

		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = FIELD_INSETS;

		layout.setConstraints(componente, constraints);
		add(componente);
	}
} // fim da classe TarefaFormPanel
