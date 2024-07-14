package ge.sokolov.voidapp.exception;

import ge.sokolov.voidapp.utils.Response;
import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.command.CommandHandlingResult;

public class ShellExceptionResolver implements CommandExceptionResolver {

  @Override
  public CommandHandlingResult resolve(Exception ex) {
    if (ex instanceof ValidationException
        || ex instanceof ApiException
        || ex instanceof ServerException) {
      return CommandHandlingResult.of(ex.getMessage());
    }
    return CommandHandlingResult.of(Response.SERVER_ERROR);
  }
}
