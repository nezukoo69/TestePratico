import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        //inserir todos os funcionários
        funcionarios.add(new Funcionario("João", LocalDate.of(1985, 5, 15), 3000.00, "Analista"));
        funcionarios.add(new Funcionario("Maria", LocalDate.of(1990, 8, 25), 3500.00, "Desenvolvedor"));
        funcionarios.add(new Funcionario("Carlos", LocalDate.of(1978, 10, 3), 4000.00, "Gerente"));
        funcionarios.add(new Funcionario("Ana", LocalDate.of(1982, 12, 1), 2500.00, "Assistente"));
        
        //remover o funcionário João
        funcionarios.removeIf(func -> func.getNome().equals("João"));
        
        //imprimir todos os funcionários com suas informações
        System.out.println("Funcionários:");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        //atualizar os salários com 10% de aumento
        for (Funcionario f : funcionarios) {
            f.setSalario(f.getSalario() * 1.10);
        }

        //agrupar funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        //imprimir funcionários agrupados por função
        System.out.println("\nFuncionários agrupados por função:");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("\nFunção: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }

        //imprimir funcionários com aniversário no mês 10 e 12
        System.out.println("\nFuncionários com aniversário em Outubro ou Dezembro:");
        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12) {
                System.out.println(f);
            }
        }

        //imprimir o funcionário com a maior idade
        Funcionario maisVelho = Collections.max(funcionarios, Comparator.comparingInt(Funcionario::calcularIdade));
        System.out.println("\nFuncionário com maior idade:");
        System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + maisVelho.calcularIdade());

        //imprimir a lista de funcionários em ordem alfabética
        System.out.println("\nFuncionários em ordem alfabética:");
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        funcionarios.forEach(System.out::println);

        //imprimir o total dos salários dos funcionários
        double totalSalarios = funcionarios.stream()
                .mapToDouble(Funcionario::getSalario)
                .sum();
        System.out.println("\nTotal dos salários: " + String.format("%,.2f", totalSalarios).replace(',', ' ').replace('.', ','));

        //imprimir quantos salários mínimos cada funcionário ganha
        final double salarioMinimo = 1212.00;
        System.out.println("\nFuncionários e quantos salários mínimos ganham:");
        for (Funcionario f : funcionarios) {
            double salariosMinimos = f.getSalario() / salarioMinimo;
            System.out.println(f.getNome() + " ganha " + String.format("%,.2f", salariosMinimos).replace(',', ' ').replace('.', ',') + " salários mínimos.");
        }
    }
}
