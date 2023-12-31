public class Cadastro {
    private String nome;
    private int idade;
    private String email;
    private int cep;
    private int telefone;
    private String usuario;
    private String senha;
    private Curso curso;
    private String observacoes;
    private Ativo ativo;

    
    public Cadastro() {
    }

    
    public Cadastro(String nome, int idade, String email, int cep, int telefone, String usuario,
                    String senha, Curso curso, String observacoes, Ativo ativo) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cep = cep;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
        this.curso = curso;
        this.observacoes = observacoes;
        this.ativo = ativo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

   
    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

   
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    
    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }


    public enum Curso {
        PROJETO_APLICADO,
        BANCO_DE_DADOS,
        MATEMATICA,
        PROGRAMACAO_ORIENTADA_A_OBJETOS,
        ESTRUTURA_DE_DADOS
    }

    
    public enum Ativo {
        SIM,
        NAO
    }



    
    @Override
    public String toString() {
        return "Cadastro{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", cep=" + cep +
                ", telefone=" + telefone +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", curso=" + curso +
                ", observacoes='" + observacoes + '\'' +
                ", ativo=" + ativo +
                '}';
    }

}
