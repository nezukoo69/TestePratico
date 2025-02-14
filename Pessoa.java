import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int calcularIdade() {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    public String formatarData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formatter);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Data de Nascimento: " + formatarData();
    }
}
