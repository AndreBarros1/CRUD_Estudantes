import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlunos {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Alunos Cadastrados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Nome", "Idade", "E-mail", "Endereço", "CEP", "Telefone", "Curso", "Observações", "Ativo"};
        Object[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        Dimension buttonSize = new Dimension(100, 30);
        Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setPreferredSize(buttonSize);
        cadastrarButton.setMaximumSize(buttonSize);
        cadastrarButton.setBorder(border);
        cadastrarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a nova tela (CadastroUsuarioInterface)
                CadastroUsuarioInterface cadastroUsuarioInterface = new CadastroUsuarioInterface();
                cadastroUsuarioInterface.setVisible(true);
            }
        });

        JButton editarButton = new JButton("Editar");
        editarButton.setPreferredSize(buttonSize);
        editarButton.setMaximumSize(buttonSize);
        editarButton.setBorder(border);
        editarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a nova tela (EditarUsuarioInterface)
                EditarUsuarioInterface editarUsuarioInterface = new EditarUsuarioInterface();
                editarUsuarioInterface.setVisible(true);
            }
        });

        JButton removerButton = new JButton("Remover");
        removerButton.setPreferredSize(buttonSize);
        removerButton.setMaximumSize(buttonSize);
        removerButton.setBorder(border);
        removerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém o índice da linha selecionada
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    // Obtém o nome do aluno selecionado
                    String alunoSelecionado = (String) model.getValueAt(selectedRow, 0);

                    // Exibe uma mensagem de confirmação
                    int resposta = JOptionPane.showConfirmDialog(frame,
                            "Tem certeza que deseja remover o aluno: " + alunoSelecionado + "?",
                            "Confirmação de Remoção",
                            JOptionPane.YES_NO_OPTION);

                    // Se o usuário escolher "Sim" (YES_OPTION), remova o aluno
                    if (resposta == JOptionPane.YES_OPTION) {
                        // Remova o aluno (substitua isso pela lógica real de remoção)
                        // Apenas para exemplo, removendo a linha do modelo da tabela
                        model.removeRow(selectedRow);
                    }
                } else {
                    // Se nenhum aluno estiver selecionado, exiba uma mensagem
                    JOptionPane.showMessageDialog(frame, "Selecione um aluno para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        panel.add(cadastrarButton);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(editarButton);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(removerButton);
        frame.add(panel, BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
    }
}
