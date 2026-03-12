package br.senai.sp.teste.exception;

public class EntityInUseException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public EntityInUseException(String message) {
        super(message);
    }
    
    public EntityInUseException(String message, Throwable cause) {
        super(message, cause);
    }
}
