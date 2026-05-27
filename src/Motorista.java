import exceptions.DadoInvalidoException;

public class Motorista {

    private int id;
    private String nome;
    private String cnh;
    private String telefone;

    public Motorista(int id, String nome, String cnh, String telefone) throws DadoInvalidoException {
        
        // 1. Validação do Nome: Apenas letras e espaços (não pode ser vazio)
        if (nome == null || nome.trim().isEmpty() || !nome.matches("^[a-zA-ZÁ-ú\\s]+$")) {
            throw new DadoInvalidoException("Erro: O nome deve conter apenas letras.");
        }

        // 2. Validação da CNH: Exatamente 9 dígitos numéricos
        if (cnh == null || !cnh.matches("^\\d{9}$")) {
            throw new DadoInvalidoException("Erro: A CNH deve conter exatamente 9 digitos numericos.");
        }

        // 3. Validação do Telefone: Exatamente 11 dígitos numéricos (ex: 21964015921)
        if (telefone == null || !telefone.matches("^\\d{11}$")) {
            throw new DadoInvalidoException("Erro: O telefone deve conter exatamente 11 digitos numericos (com DDD).");
        }

        this.id = id;
        this.nome = nome;
        this.cnh = cnh;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}