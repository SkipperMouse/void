package ge.sokolov.voidapp.command;

import ge.sokolov.voidapp.exception.ValidationException;
import ge.sokolov.voidapp.facade.TimeManagementFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.rmi.ServerException;

@ShellComponent
@RequiredArgsConstructor
public class CategoryCommand {

    private final TimeManagementFacade timeManagementFacade;

    @ShellMethod(key = "category", value = "Work with categories of tasks")
    public String processCategoryCommand(
            @ShellOption(value = {"-l", "--list"}, help = "List of all categories", defaultValue = "") String listFlag,
            @ShellOption(value = {"-n", "--name"}, help = "Name of the new category", defaultValue = "") String categoryName) {
        return timeManagementFacade.processCategory(categoryName, listFlag);
    }

    @ExceptionResolver({ValidationException.class})
    String handleApplicationException(ValidationException e) {
        return e.getMessage();
    }

    @ExceptionResolver({ServerException.class})
    String handleApplicationException(ServerException e) {
        return e.getMessage();
    }

    @ExceptionResolver({Exception.class})
    CommandHandlingResult handleOtherException(RuntimeException e) {
        return CommandHandlingResult.of(e.getMessage());
    }
}