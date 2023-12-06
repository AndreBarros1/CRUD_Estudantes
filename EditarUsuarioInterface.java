import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class EditarUsuarioInterface extends JFrame {

    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldTelefone;
    private JTextField textFieldEmail;
    private JTextField textFieldEndereco;
    private JTextField textFieldCEP;
    private JComboBox<String> comboBoxCurso;
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldSenha;
    private JTextArea textAreaObservacoes;
    private JComboBox<String> comboBoxAtivo;


    public EditarUsuarioInterface() {
        setTitle("Cadastro de Usuário");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

//Campo Nome 1
        JLabel labelNome = new JLabel("Nome*:");
        labelNome.setBounds(20, 20, 80, 25);
        add(labelNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(120, 20, 200, 25);
        add(textFieldNome);


        JLabel labelIdade = new JLabel("Idade*:");
        labelIdade.setBounds(20, 50, 80, 25);
        add(labelIdade);

        textFieldIdade = new JTextField();
        textFieldIdade.setBounds(120, 50, 200, 25);
        add(textFieldIdade);
        ((AbstractDocument) textFieldIdade.getDocument()).setDocumentFilter(new NumericFilter());

//Campo Email 3
        JLabel labelEmail = new JLabel("E-mail*:");
        labelEmail.setBounds(20, 80, 80, 25);
        add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(120, 80, 200, 25);
        add(textFieldEmail);

        JLabel labelEndereco = new JLabel("Endereço*:");
        labelEndereco.setBounds(20, 110, 80, 25);
        add(labelEndereco);

        textFieldEndereco = new JTextField();
        textFieldEndereco.setBounds(120, 110, 200, 25);
        add(textFieldEndereco);

        JLabel labelCEP = new JLabel("CEP:");
        labelCEP.setBounds(20, 140, 80, 25);
        add(labelCEP);

        textFieldCEP = new JTextField();
        textFieldCEP.setBounds(120, 140, 200, 25);
        add(textFieldCEP);
        ((AbstractDocument) textFieldCEP.getDocument()).setDocumentFilter(new NumericFilter());

        JLabel labelTelefone = new JLabel("Telefone:");
        labelTelefone.setBounds(20, 170, 80, 25);
        add(labelTelefone);

        textFieldTelefone = new JTextField();
        textFieldTelefone.setBounds(120, 170, 200, 25);
        add(textFieldTelefone);
        ((AbstractDocument) textFieldTelefone.getDocument()).setDocumentFilter(new NumericFilter());

// Adicionando o campo de seleção para o curso
        JLabel labelCurso = new JLabel("Curso*: ");
        labelCurso.setBounds(20, 260, 80, 25);
        add(labelCurso);

        String[] opcoesCurso = {"", "Projeto Aplicado", "Banco de Dados", "Matemática", "Programação orientada objetos", "Estrutura de Dados"}; // Substitua com suas opções
        comboBoxCurso = new JComboBox<>(opcoesCurso);
        comboBoxCurso.setBounds(120, 260, 200, 25);
        comboBoxCurso.setBackground(Color.WHITE);
        add(comboBoxCurso);

//Campo Usuario
        JLabel labelUsuario = new JLabel("Usuário*:");
        labelUsuario.setBounds(20, 200, 80, 25);
        add(labelUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(120, 200, 200, 25);
        add(textFieldUsuario);

//Campo Senha

        JLabel labelSenha = new JLabel("Senha*:");
        labelSenha.setBounds(20, 230, 80, 25);
        add(labelSenha);

        passwordFieldSenha = new JPasswordField();
        passwordFieldSenha.setBounds(120, 230, 200, 25);
        add(passwordFieldSenha);

//Ativo
        JLabel labelAtivo = new JLabel("Ativo*: ");
        labelAtivo.setBounds(20, 415, 80, 25);
        add(labelAtivo);

        String[] opcoesAtivo = {"", "Sim", "Não"}; // Substitua com suas opções
        comboBoxAtivo = new JComboBox<>(opcoesAtivo);
        comboBoxAtivo.setBounds(120, 415, 200, 25);
        comboBoxAtivo.setBackground(Color.WHITE);
        add(comboBoxAtivo);



        // Continue adicionando os outros campos...

        JLabel labelObservacoes = new JLabel("Observações:");
        labelObservacoes.setBounds(20, 300, 100, 25);
        add(labelObservacoes);

        textAreaObservacoes = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaObservacoes);
        scrollPane.setBounds(120, 300, 250, 100);
        add(scrollPane);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(115, 475, 100, 25);
        add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (camposObrigatoriosPreenchidos()) {
                    cadastrarUsuario();
                } else {
                    JOptionPane.showMessageDialog(EditarUsuarioInterface.this,
                            "Preencha todos os campos obrigatórios marcados com '*'.",
                            "Campos Obrigatórios",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(220, 475, 100, 25);
        add(btnCancelar);

        btnCancelar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         int confirmacao = JOptionPane.showConfirmDialog(EditarUsuarioInterface.this,
                "Tem certeza que deseja cancelar?",
                "Cancelar Cadastro",
                JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Fecha a janela atual
            EditarUsuarioInterface.this.dispose();

           
        }
    }
});





    }
    private boolean camposObrigatoriosPreenchidos() {
    return !textFieldNome.getText().isEmpty() &&
            !textFieldIdade.getText().isEmpty() &&
            !textFieldEmail.getText().isEmpty() &&
            !textFieldEndereco.getText().isEmpty() &&
            !textFieldUsuario.getText().isEmpty() &&
            !String.valueOf(passwordFieldSenha.getPassword()).isEmpty() &&
            !comboBoxCurso.getSelectedItem().toString().isEmpty() &&
            !comboBoxAtivo.getSelectedItem().toString().isEmpty();

    // Adicione verificações para outros campos obrigatórios, se necessário
}

 private void cadastrarUsuario() {
        String nome = textFieldNome.getText();
        String idade = textFieldIdade.getText();
        String telefone = textFieldTelefone.getText();
        String email = textFieldEmail.getText();
        String cep = textFieldCEP.getText();
        String endereco = textFieldEndereco.getText();
        String senha = String.valueOf(passwordFieldSenha.getPassword());
        // Obtenha os valores dos outros campos
        String observacoes = textAreaObservacoes.getText();
        // Lógica para cadastrar o usuário no banco de dados ou em algum armazenamento

        // Exemplo: Exibir os dados cadastrados na TextArea
        textAreaObservacoes.append("Nome: " + nome + "\n");
        textAreaObservacoes.append("Idade: " + idade + "\n");
        textAreaObservacoes.append("E-mail: " + email + "\n");
        textAreaObservacoes.append("Endereço: " + endereco + "\n");
        textAreaObservacoes.append("CEP: " + cep + "\n");
        textAreaObservacoes.append("Telefone: " + telefone + "\n");
        textAreaObservacoes.append("Usuário: " + textFieldUsuario.getText() + "\n");
        textAreaObservacoes.append("Senha: " + senha + "\n");
        textAreaObservacoes.append("Curso: " + comboBoxCurso.getSelectedItem() + "\n");
        textAreaObservacoes.append("Ativo: " + comboBoxAtivo.getSelectedItem() + "\n");
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

    // Filtro de documento para aceitar apenas caracteres numéricos
    private class NumericFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            super.insertString(fb, offset, string.replaceAll("\\D", ""), attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            super.replace(fb, offset, length, text.replaceAll("\\D", ""), attrs);
        }
    }
}