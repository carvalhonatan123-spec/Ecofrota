import exceptions.VeiculoNaoEncontradoException;
import exceptions.PlacaInvalidaException;

public class Veiculo {

    private String placa;
    private String modelo;
    private String combustivel;
    private double consumoMedio;
    private int anoFabricacao;

    public Veiculo(String placa, String modelo, String combustivel,
                   double consumoMedio, int anoFabricacao) throws VeiculoNaoEncontradoException, PlacaInvalidaException {
        
        if (placa == null || placa.trim().isEmpty()) {
            throw new VeiculoNaoEncontradoException("Erro: A placa do veiculo e obrigatoria.");
        }

        // Validação de formato da Placa: Padrão Antigo (ABC-1234) ou Mercosul (ABC1D23)
        String placaLimpa = placa.trim().toUpperCase().replace("-", "");
        if (!placaLimpa.matches("^[A-Z]{3}[0-9]{4}$") && !placaLimpa.matches("^[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}$")) {
            throw new PlacaInvalidaException("Erro: Formato de placa invalido. Use ABC-1234 ou ABC1D23.");
        }

        this.placa = placaLimpa; // Salva a placa padronizada em maiúsculas e sem hífen
        this.modelo = modelo;
        this.combustivel = combustivel;
        this.consumoMedio = consumoMedio;
        this.anoFabricacao = anoFabricacao;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getCombustivel() { return combustivel; }
    public void setCombustivel(String combustivel) { this.combustivel = combustivel; }
    public double getConsumoMedio() { return consumoMedio; }
    public void setConsumoMedio(double consumoMedio) { this.consumoMedio = consumoMedio; }
    public int getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(int anoFabricacao) { this.anoFabricacao = anoFabricacao; }
}