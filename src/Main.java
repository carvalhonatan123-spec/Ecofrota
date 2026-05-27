import java.util.Scanner;
import java.util.InputMismatchException;
import exceptions.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Veiculo[] veiculos = new Veiculo[100];
        Motorista[] motoristas = new Motorista[100];
        Viagem[] viagens = new Viagem[100];
        Abastecimento[] abastecimentos = new Abastecimento[100];

        int qtdVeiculos = 0; int qtdMotoristas = 0; int qtdViagens = 0; int qtdAbastecimentos = 0;
        int opcao = -1;

        do {
            System.out.println("\n===== ECOFROTA (PROTEGIDO) =====");
            System.out.println("1 - Cadastrar Veiculo");
            System.out.println("2 - Listar Veiculos");
            System.out.println("3 - Cadastrar Motorista");
            System.out.println("4 - Listar Motoristas");
            System.out.println("5 - Registrar Viagem");
            System.out.println("6 - Listar Viagens");
            System.out.println("7 - Registrar Abastecimento");
            System.out.println("8 - Listar Abastecimentos");
            System.out.println("9 - Gerar Relatorio Ambiental");
            System.out.println("10 - Veiculo com Maior Emissao de CO2 (e Recomendacao de Compensacao)");
            System.out.println("11 - Veiculo com Maior Consumo de Combustivel");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            try {
                opcao = sc.nextInt(); sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro: A opcao do menu deve ser um numero inteiro.");
                sc.nextLine(); continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        if (qtdVeiculos >= 100) throw new CapacidadeExcedidaException("Erro: Limite maximo de 100 veiculos atingido.");
                        
                        System.out.print("Placa (ABC-1234 ou ABC1D23): "); String placa = sc.nextLine().trim().toUpperCase().replace("-", "");
                        
                        for (int i = 0; i < qtdVeiculos; i++) {
                            if (veiculos[i].getPlaca().equalsIgnoreCase(placa)) throw new RegistroDuplicadoException("Erro: Ja existe um veiculo cadastrado com esta placa.");
                        }

                        System.out.print("Modelo: "); String modelo = sc.nextLine();
                        System.out.print("Combustivel: "); String combustivel = sc.nextLine();
                        System.out.print("Consumo Medio (km/L): "); double consumo = sc.nextDouble();
                        System.out.print("Ano Fabricacao: "); int ano = sc.nextInt(); sc.nextLine();

                        veiculos[qtdVeiculos] = new Veiculo(placa, modelo, combustivel, consumo, ano);
                        qtdVeiculos++;
                        System.out.println("Veiculo cadastrado com sucesso!");
                    } catch (VeiculoNaoEncontradoException | PlacaInvalidaException | CapacidadeExcedidaException | RegistroDuplicadoException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Consumo e Ano de Fabricacao devem ser numericos."); sc.nextLine();
                    }
                    break;

                case 2:
                    if (qtdVeiculos == 0) { System.out.println("Nenhum veiculo cadastrado."); } 
                    else {
                        System.out.println("\n=== VEICULOS CADASTRADOS ===");
                        for (int i = 0; i < qtdVeiculos; i++) {
                            System.out.println("Placa: " + veiculos[i].getPlaca() + " | Modelo: " + veiculos[i].getModelo() + " | Combustivel: " + veiculos[i].getCombustivel());
                        }
                    }
                    break;

                case 3:
                    try {
                        if (qtdMotoristas >= 100) throw new CapacidadeExcedidaException("Erro: Limite maximo de 100 motoristas atingido.");
                        
                        System.out.print("ID do Motorista (apenas numeros): "); int idMot = sc.nextInt(); sc.nextLine();
                        
                        for (int i = 0; i < qtdMotoristas; i++) {
                            if (motoristas[i].getId() == idMot) throw new RegistroDuplicadoException("Erro: Ja existe um motorista cadastrado com este ID.");
                        }

                        System.out.print("Nome (apenas letras): "); String nome = sc.nextLine();
                        System.out.print("CNH (9 digitos numericos): "); String cnh = sc.nextLine();
                        
                        for (int i = 0; i < qtdMotoristas; i++) {
                            if (motoristas[i].getCnh().equals(cnh)) throw new RegistroDuplicadoException("Erro: Ja existe um motorista cadastrado com esta CNH.");
                        }

                        System.out.print("Telefone (11 digitos com DDD): "); String telefone = sc.nextLine();

                        motoristas[qtdMotoristas] = new Motorista(idMot, nome, cnh, telefone);
                        qtdMotoristas++;
                        System.out.println("Motorista cadastrado com sucesso!");
                    } catch (DadoInvalidoException | CapacidadeExcedidaException | RegistroDuplicadoException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: O ID do motorista deve ser um numero inteiro."); sc.nextLine();
                    }
                    break;

                case 4:
                    if (qtdMotoristas == 0) { System.out.println("Nenhum motorista cadastrado."); } 
                    else {
                        System.out.println("\n=== MOTORISTAS CADASTRADOS ===");
                        for (int i = 0; i < qtdMotoristas; i++) {
                            System.out.println("ID: " + motoristas[i].getId() + " | Nome: " + motoristas[i].getNome() + " | CNH: " + motoristas[i].getCnh() + " | Tel: " + motoristas[i].getTelefone());
                        }
                    }
                    break;

                case 5:
                    try {
                        if (qtdViagens >= 100) throw new CapacidadeExcedidaException("Erro: Limite maximo de 100 viagens atingido.");
                        
                        System.out.print("ID da Viagem (apenas numeros): "); int idViagem = sc.nextInt();
                        
                        for (int i = 0; i < qtdViagens; i++) {
                            if (viagens[i].getId() == idViagem) throw new RegistroDuplicadoException("Erro: Ja existe uma viagem registrada com este ID.");
                        }

                        System.out.print("Distancia Percorrida (km): "); double distancia = sc.nextDouble();
                        System.out.print("Combustivel Consumido (L): "); double combViagem = sc.nextDouble(); sc.nextLine();
                        System.out.print("Data da Viagem (DD/MM/AAAA): "); String dataViagem = sc.nextLine();
                        System.out.print("Placa do Veiculo: "); String placaV = sc.nextLine().trim().toUpperCase().replace("-", "");
                        
                        boolean veiculoExiste = false;
                        for (int i = 0; i < qtdVeiculos; i++) {
                            if (veiculos[i].getPlaca().equalsIgnoreCase(placaV)) { veiculoExiste = true; break; }
                        }
                        if (!veiculoExiste) throw new VeiculoNaoEncontradoException("Erro: Nao e possivel registrar viagem. Veiculo com a placa " + placaV + " nao cadastrado.");

                        System.out.print("Nome do Motorista: "); String nomeM = sc.nextLine();

                        viagens[qtdViagens] = new Viagem(idViagem, distancia, dataViagem, combViagem, placaV, nomeM);
                        qtdViagens++;
                        System.out.println("Viagem registrada com sucesso!");
                    } catch (EmissaoInvalidaException | AutonomiaInconsistenteException | CapacidadeExcedidaException | RegistroDuplicadoException | VeiculoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: ID, Distancia e Combustivel devem ser valores numericos."); sc.nextLine();
                    }
                    break;

                case 6:
                    if (qtdViagens == 0) { System.out.println("Nenhuma viagem registrada."); } 
                    else {
                        System.out.println("\n=== VIAGENS REGISTRADAS ===");
                        for (int i = 0; i < qtdViagens; i++) {
                            System.out.println("ID: " + viagens[i].getId() + " | Veiculo: " + viagens[i].getPlacaVeiculo() + " | Emissao: " + viagens[i].calcularEmissaoCO2() + " kg CO2");
                        }
                    }
                    break;

                case 7:
                    try {
                        if (qtdAbastecimentos >= 100) throw new CapacidadeExcedidaException("Erro: Limite maximo de 100 abastecimentos atingido.");
                        
                        System.out.print("ID do Abastecimento (apenas numeros): "); int idAbast = sc.nextInt(); sc.nextLine();
                        
                        for (int i = 0; i < qtdAbastecimentos; i++) {
                            if (abastecimentos[i].getId() == idAbast) throw new RegistroDuplicadoException("Erro: Ja existe um abastecimento registrado com este ID.");
                        }

                        System.out.print("Data (DD/MM/AAAA): "); String dataAbast = sc.nextLine();
                        System.out.print("Quantidade (Litros): "); double litros = sc.nextDouble();
                        System.out.print("Valor Total (R$): "); double valor = sc.nextDouble(); sc.nextLine();
                        System.out.print("Placa do Veiculo: "); String placaA = sc.nextLine().trim().toUpperCase().replace("-", "");

                        abastecimentos[qtdAbastecimentos] = new Abastecimento(idAbast, dataAbast, litros, valor, placaA);
                        qtdAbastecimentos++;
                        System.out.println("Abastecimento registrado com sucesso!");
                    } catch (EmissaoInvalidaException | CapacidadeExcedidaException | RegistroDuplicadoException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: ID, Litros e Valor Total devem ser valores numericos."); sc.nextLine();
                    }
                    break;

                case 8:
                    if (qtdAbastecimentos == 0) { System.out.println("Nenhum abastecimento registrado."); } 
                    else {
                        System.out.println("\n=== ABASTECIMENTOS REGISTRADOS ===");
                        for (int i = 0; i < qtdAbastecimentos; i++) {
                            System.out.println("ID: " + abastecimentos[i].getId() + " | Veiculo: " + abastecimentos[i].getPlacaVeiculo() + " | Litros: " + abastecimentos[i].getQuantidadeLitros() + "L" + " | Custo/Litro: R$ " + String.format("%.2f", abastecimentos[i].calcularCustoPorLitro()));
                        }
                    }
                    break;

                case 9:
                    if (qtdViagens == 0) { System.out.println("Sem dados suficientes de viagens para gerar o relatorio."); } 
                    else {
                        double totalCombustivel = 0; double totalEmissoes = 0;
                        for (int i = 0; i < qtdViagens; i++) {
                            totalCombustivel += viagens[i].getCombustivelConsumido();
                            totalEmissoes += viagens[i].calcularEmissaoCO2();
                        }
                        System.out.println("\n===== RELATORIO AMBIENTAL =====");
                        System.out.println("Quantidade de viagens: " + qtdViagens);
                        System.out.println("Combustivel consumido total: " + totalCombustivel + " litros");
                        System.out.println("Emissao total de GEE: " + String.format("%.2f", totalEmissoes) + " kg CO2");
                        System.out.println("Media de emissao por viagem: " + String.format("%.2f", (totalEmissoes / qtdViagens)) + " kg CO2");
                    }
                    break;

                case 10:
                    if (qtdViagens == 0) { System.out.println("Nenhuma viagem registrada para calcular."); } 
                    else {
                        String maiorEmissorPlaca = ""; double maiorEmissaoValor = -1;
                        for (int i = 0; i < qtdVeiculos; i++) {
                            String placaAtual = veiculos[i].getPlaca(); double somaEmissaoDesteVeiculo = 0;
                            for (int j = 0; j < qtdViagens; j++) {
                                if (viagens[j].getPlacaVeiculo().equalsIgnoreCase(placaAtual)) {
                                    somaEmissaoDesteVeiculo += viagens[j].calcularEmissaoCO2();
                                }
                            }
                            if (somaEmissaoDesteVeiculo > maiorEmissaoValor) {
                                maiorEmissaoValor = somaEmissaoDesteVeiculo;
                                maiorEmissorPlaca = placaAtual;
                            }
                        }
                        if (maiorEmissorPlaca.isEmpty() || maiorEmissaoValor == 0) { System.out.println("Nenhuma emissao calculada para os veiculos cadastrados."); } 
                        else {
                            System.out.println("\n===== MAIOR EMISSOR =====");
                            System.out.println("Placa do Veiculo: " + maiorEmissorPlaca);
                            System.out.println("Total de Emissoes: " + String.format("%.2f", maiorEmissaoValor) + " kg CO2");
                            
                            // IMPLEMENTAÇÃO DO MINI-MUNDO: Recomendação de Compensação Ambiental
                            System.out.println("\n>>> RECOMENDACAO DE COMPENSACAO AMBIENTAL <<<");
                            
                            // Calcula créditos de carbono (1 crédito = 1000 kg de CO2)
                            double creditosNecessarios = maiorEmissaoValor / 1000.0;
                            // Calcula árvores necessárias (1 árvore absorve ~15kg de CO2 por ano)
                            int arvoresNecessarias = (int) Math.ceil(maiorEmissaoValor / 15.0);
                            
                            System.out.println("Para mitigar o impacto ambiental deste veiculo, a empresa deve:");
                            System.out.printf("- Adquirir: %.4f Creditos de Carbono (Mercado de Carbono Compulsorio)%n", creditosNecessarios);
                            System.out.println("- Ou plantar: " + arvoresNecessarias + " arvores nativas para neutralizacao anual.");
                        }
                    }
                    break;

                case 11:
                    if (qtdViagens == 0) { System.out.println("Nenhuma viagem registrada para calcular."); } 
                    else {
                        String maiorConsumoPlaca = ""; double maiorConsumoValor = -1;
                        for (int i = 0; i < qtdVeiculos; i++) {
                            String placaAtual = veiculos[i].getPlaca(); double somaConsumoDesteVeiculo = 0;
                            for (int j = 0; j < qtdViagens; j++) {
                                if (viagens[j].getPlacaVeiculo().equalsIgnoreCase(placaAtual)) {
                                    somaConsumoDesteVeiculo += viagens[j].getCombustivelConsumido();
                                }
                            }
                            if (somaConsumoDesteVeiculo > maiorConsumoValor) {
                                maiorConsumoValor = somaConsumoDesteVeiculo;
                                maiorConsumoPlaca = placaAtual;
                            }
                        }
                        if (maiorConsumoPlaca.isEmpty() || maiorConsumoValor == 0) { System.out.println("Nenhum consumo calculado para os veiculos cadastrados."); } 
                        else {
                            System.out.println("\n===== MAIOR CONSUMO =====");
                            System.out.println("Placa do Veiculo: " + maiorConsumoPlaca);
                            System.out.println("Total Consumido: " + maiorConsumoValor + " litros");
                        }
                    }
                    break;

                case 0: System.out.println("Sistema encerrado."); break;
                default: System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
        sc.close();
    }
}