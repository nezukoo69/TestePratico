public class Funcionario extends Pessoa {
    private double salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, double salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public String formatarSalario() {
        return String.format("%,.2f", salario).replace(',', ' ').replace('.', ',');
    }

    @Override
    public String toString() {
        return super.toString() + ", Função: " + funcao + ", Salário: " + formatarSalario();
    }
}
