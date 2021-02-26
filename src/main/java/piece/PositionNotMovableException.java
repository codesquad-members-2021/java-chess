package piece;

public class PositionNotMovableException extends RuntimeException {

    private final int ERR_CODE;

    PositionNotMovableException(String message, int errorCode) {
        super(message);
        ERR_CODE = errorCode;
    }

    PositionNotMovableException(String message) {
        this(message, 316);
    }

    public int getErrCode() {
        return ERR_CODE;
    }
}
