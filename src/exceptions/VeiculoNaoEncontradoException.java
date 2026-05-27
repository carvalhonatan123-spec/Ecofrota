package exceptions;

public class VeiculoNaoEncontradoException extends Exception {
    public VeiculoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}