# Projeto EcoFrota

### Integrante:
* Nome: Natan de Oliveira Carvalho dos Santos
* Matrícula: 1250215786

---

## 1. Contextualização do Mini-mundo
O EcoFrota gerencia o impacto ambiental de frotas, monitorando o consumo de combustível e calculando as emissões de CO2 por viagem. O sistema identifica os maiores emissores da frota e recomenda a compensação ambiental necessária através do cálculo de Créditos de Carbono e do plantio de árvores nativas.

---

## 2. Atores do Sistema
* Gestor da Frota: Operador do sistema responsável por gerenciar os cadastros, viagens, abastecimentos e emitir os relatórios de ecoeficiência.

---

## 3. Mapeamento de Requisitos e Casos de Uso

### Requisitos Funcionais (RF)
* RF01: Permitir o cadastro de veículos e motoristas.
* RF02: Registrar viagens e abastecimentos.
* RF03: Calcular as emissões de CO2 com base no combustível consumido.
* RF04: Gerar relatório ambiental consolidado.
* RF05: Identificar o maior emissor e sugerir a compensação ambiental correspondente.

### Requisitos Não Funcionais (RNF)
* RNF01: O sistema deve ser desenvolvido em linguagem Java orientado a objetos.
* RNF02: O armazenamento dos dados deve ser feito em memória utilizando vetores limitado a 100 posições.
* RNF03: Validar os formatos de dados inseridos através do tratamento de exceções customizadas.

### Casos de Uso (UC)
* UC01: Cadastrar Veículo
* UC02: Cadastrar Motorista
* UC03: Registrar Viagem
* UC04: Gerar Relatório Ambiental e de Compensação

---

## 4. Modelagem UML

### Diagrama de Casos de Uso
```mermaid
graph TD
    Gestor[Gestor da Frota] --> UC1(Cadastrar Veículo)
    Gestor --> UC2(Cadastrar Motorista)
    Gestor --> UC3(Registrar Viagem)
    Gestor --> UC4(Gerar Relatório Ambiental e Compensação)

    classDiagram
    class Veiculo {
        -String placa
        -String modelo
        -String combustivel
        -double consumoMedio
        -int anoFabricacao
    }
    class Motorista {
        -int id
        -String nome
        -String cnh
        -String telefone
    }
    class Viagem {
        -int id
        -double distanciaPercorrida
        -String dataViagem
        -double combustivelConsumido
        -String placaVeiculo
        -String nomeMotorista
    }
    class Abastecimento {
        -int id
        -String dataAbastecimento
        -double quantidadeLitros
        -double valorTotal
        -String placaVeiculo
    }
    class Empresa {
        -int id
        -String nome
        -String cnpj
    }
    Viagem --> Veiculo
    Viagem --> Motorista
    Abastecimento --> Veiculo
