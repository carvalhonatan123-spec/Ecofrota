public class RelatorioAmbiental {

    private String periodo;
    private double totalEmissao;
    private int quantidadeViagens;

    public RelatorioAmbiental(String periodo, double totalEmissao, int quantidadeViagens) {
        this.periodo = periodo;
        this.totalEmissao = totalEmissao;
        this.quantidadeViagens = quantidadeViagens;
    }

    public void exibirRelatorio() {
        System.out.println("Periodo: " + periodo);
        System.out.println("Total de Emissao: " + totalEmissao + " kg CO2");
        System.out.println("Quantidade de Viagens: " + quantidadeViagens);
    }
}