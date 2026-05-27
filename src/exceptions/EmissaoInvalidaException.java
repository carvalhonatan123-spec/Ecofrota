package exceptions;

public class EmissaoInvalidaException extends Exception {
    public EmissaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}