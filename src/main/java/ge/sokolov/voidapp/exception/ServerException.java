package ge.sokolov.voidapp.exception;

import ge.sokolov.voidapp.utils.Response;

public class ServerException extends RuntimeException {

  public ServerException() {
    super(Response.SERVER_ERROR);
  }

  public ServerException(String message) {
    super(message);
  }
}
