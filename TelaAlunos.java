import javax.swing.*;
import javax.swing.border.Border;
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
        JTable table = new JTable(data, columnNames);
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
