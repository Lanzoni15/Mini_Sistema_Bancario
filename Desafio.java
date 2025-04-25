import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner contaBancaria = new Scanner(System.in);
        int opcao = 0;

        // DADOS DO CLIENTE
        System.out.println("**********************************");
        System.out.println("Dados iniciais do cliente:\n");

        String nomeCliente = contaBancaria.nextLine();
        String tipoDeConta = contaBancaria.nextLine();
        double saldo = contaBancaria.nextDouble(); // renomeado para "saldo" para refletir valor atual

        System.out.println("Nome: " + nomeCliente);
        System.out.println("Tipo da Conta: " + tipoDeConta);
        System.out.println("Saldo Inicial: R$ " + saldo);
        System.out.println("\n**********************************\n");

        // MENU DE OPERAÇÕES
        System.out.println("\nOperações\n");

        while (opcao != 4) {

            String menu = """
                    ** Digite a opção desejada: **
                    1- Consultar saldos
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    """;

            System.out.println(menu);
            opcao = contaBancaria.nextInt();

            if (opcao > 4 || opcao <= 0) {
                System.out.println("Opção Inválida\n");
                continue;
            }

            if (opcao == 1) {
                System.out.println("O saldo atual é: R$ " + saldo + "\n");

            } else if (opcao == 2) {
                System.out.println("Informe o valor a receber: ");
                double valorReceber = contaBancaria.nextDouble();

                saldo += valorReceber;
                System.out.println("Saldo atualizado: R$ " + saldo + "\n");

            } else if (opcao == 3) {
                System.out.println("Informe o valor que deseja transferir: ");
                double valorTransferir = contaBancaria.nextDouble();

                if (valorTransferir > saldo) {
                    System.out.println("Não há saldo suficiente para fazer essa transferência.\n");
                } else {
                    saldo -= valorTransferir;
                    System.out.println("Transferência realizada.");
                    System.out.println("Saldo atualizado: R$ " + saldo + "\n");
                }

            } else if (opcao == 4) {
                System.out.println("Sessão finalizada.");
            }
        }

        contaBancaria.close();
    }
}
