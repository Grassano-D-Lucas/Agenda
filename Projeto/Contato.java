package Projeto;

public class Contato {
    private String nome;
    private String telefone;
    private static int totalDeContatos = 0;

    public Contato(String nome, String telefone) {
        this.setNome(nome);
        this.setTelefone(telefone);
        Contato.totalDeContatos++;
    }

    public static int getTotalDeContatos() {
        return Contato.totalDeContatos;
    }

    public boolean setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) return false; 

        this.nome = nome;
        return true;
    }

    public boolean setTelefone(String telefone) {
        if(telefone == null || telefone.length() < 8) return false;

        this.telefone = telefone;
        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    @Override 
    public String toString() {
        return this.nome + " - " + this.telefone;
    }
}
