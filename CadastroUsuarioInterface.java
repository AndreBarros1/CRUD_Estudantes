import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuarioInterface extends JFrame {

    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldTelefone;
    private JTextField textFieldEmail;
    private JTextField textFieldCEP;
    private JTextField textFieldCurso;
    private JTextField textFieldLogin;
    private JPasswordField passwordFieldSenha;
    private JTextArea textAreaObservacoes;

    public CadastroUsuarioInterface() {
        setTitle("Cadastro de Usuário");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(20, 20, 80, 25);
        add(labelNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(120, 20, 200, 25);
        add(textFieldNome);

        JLabel labelIdade = new JLabel("Idade:");
        labelIdade.setBounds(20, 50, 80, 25);
        add(labelIdade);

        textFieldIdade = new JTextField();
        textFieldIdade.setBounds(120, 50, 200, 25);
        add(textFieldIdade);

        // Continue adicionando os outros campos...

        JLabel labelObservacoes = new JLabel("Observações:");
        labelObservacoes.setBounds(20, 280, 100, 25);
        add(labelObservacoes);

        textAreaObservacoes = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaObservacoes);
        scrollPane.setBounds(120, 280, 250, 100);
        add(scrollPane);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(150, 400, 100, 25);
        add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });
    }

    private void cadastrarUsuario() {
        String nome = textFieldNome.getText();
        String idade = textFieldIdade.getText();
        // Obtenha os valores dos outros campos
        String observacoes = textAreaObservacoes.getText();

        // Lógica para cadastrar o usuário no banco de dados ou em algum armazenamento

        // Exemplo: Exibir os dados cadastrados na TextArea
        textAreaObservacoes.append("Nome: " + nome + "\n");
        textAreaObservacoes.append("Idade: " + idade + "\n");
        // Adicione as outras informações na TextArea
        textAreaObservacoes.append("Observações: " + observacoes + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroUsuarioInterface().setVisible(true);
            }
        });
    }
}
