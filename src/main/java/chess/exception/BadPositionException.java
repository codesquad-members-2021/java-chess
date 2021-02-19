package chess.exception;

public class BadPositionException extends RuntimeException {
    public BadPositionException(String message) {
        super(message);
    }
}
