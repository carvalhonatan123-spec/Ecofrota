import exceptions.EmissaoInvalidaException;
import exceptions.AutonomiaInconsistenteException;

public class Viagem {

    private int id;
    private double distanciaPercorrida;
    private String dataViagem;
    private double combustivelConsumido;
    private String placaVeiculo;
    private String nomeMotorista;

    public Viagem(int id, double distanciaPercorrida, String dataViagem, double combustivelConsumido,
                  String placaVeiculo, String nomeMotorista) throws EmissaoInvalidaException, AutonomiaInconsistenteException {

        if (combustivelConsumido <= 0) {
            throw new EmissaoInvalidaException("Erro: O combustivel consumido na viagem deve ser maior que zero.");
        }
        if (distanciaPercorrida <= 0) {
            throw new EmissaoInvalidaException("Erro: A distancia percorrida deve ser maior que zero.");
        }

        // Validação de Autonomia: Impede consumos irreais de digitação (Ex: fazer mais de 40km/L ou menos de 1km/L)
        double autonomiaReal = distanciaPercorrida / combustivelConsumido;
        if (autonomiaReal > 40.0 || autonomiaReal < 1.0) {
            throw new AutonomiaInconsistenteException("Erro: Autonomia calculada (" + String.format("%.1f", autonomiaReal) + " km/L) e inconsistente. Verifique os dados digitados.");
        }

        this.id = id;
        this.distanciaPercorrida = distanciaPercorrida;
        this.dataViagem = dataViagem;
        this.combustivelConsumido = combustivelConsumido;
        this.placaVeiculo = placaVeiculo.trim().toUpperCase().replace("-", "");
        this.nomeMotorista = nomeMotorista;
    }

    public double calcularEmissaoCO2() { return combustivelConsumido * 2.31; }
    public int getId() { return id; }
    public double getDistanciaPercorrida() { return distanciaPercorrida; }
    public String getDataViagem() { return dataViagem; }
    public double getCombustivelConsumido() { return combustivelConsumido; }
    public String getPlacaVeiculo() { return placaVeiculo; }
    public String getNomeMotorista() { return nomeMotorista; }
}