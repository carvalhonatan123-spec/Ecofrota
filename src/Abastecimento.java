import exceptions.EmissaoInvalidaException;

public class Abastecimento {

    private int id;
    private String dataAbastecimento;
    private double quantidadeLitros;
    private double valorTotal;
    private String placaVeiculo;

    public Abastecimento(
            int id,
            String dataAbastecimento,
            double quantidadeLitros,
            double valorTotal,
            String placaVeiculo) throws EmissaoInvalidaException {

        if (quantidadeLitros <= 0) {
            throw new EmissaoInvalidaException("Erro: A quantidade de litros deve ser maior que zero.");
        }
        if (valorTotal <= 0) {
            throw new EmissaoInvalidaException("Erro: O valor total do abastecimento deve ser maior que zero.");
        }

        this.id = id;
        this.dataAbastecimento = dataAbastecimento;
        this.quantidadeLitros = quantidadeLitros;
        this.valorTotal = valorTotal;
        this.placaVeiculo = placaVeiculo;
    }

    public double calcularCustoPorLitro() {
        return valorTotal / quantidadeLitros;
    }

    public int getId() {
        return id;
    }

    public String getDataAbastecimento() {
        return dataAbastecimento;
    }

    public double getQuantidadeLitros() {
        return quantidadeLitros;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }
}