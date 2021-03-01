package piece;

public class PositionNotMovableException extends RuntimeException {

    private final int errorCode;

    PositionNotMovableException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    PositionNotMovableException(String message) {
        this(message, 316);
    }

    public int getErrCode() {
        return errorCode;
    }
}

