package ge.sokolov.voidapp.exception;

public class ServerException extends RuntimeException {
    private static final String SERVER_ERROR = "Server error";

    public ServerException() {
        super(SERVER_ERROR);
    }

    public ServerException(String message) {
        super(message);
    }
}
