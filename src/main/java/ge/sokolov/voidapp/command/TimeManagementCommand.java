package ge.sokolov.voidapp.command;

import ge.sokolov.voidapp.facade.TimeManagementFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

@Command(group = "Time management")
@RequiredArgsConstructor
public class TimeManagementCommand {
  private final TimeManagementFacade timeManagementFacade;

  @Command(command = "start", description = "Start tracking time for a task in category")
  public String start(
      @Option(description = "category name") String categoryName,
      @Option(description = "task name") String taskName) {
    return timeManagementFacade.startTask(taskName, categoryName);
  }

  @Command(command = "stop", description = "Stops any running or paused task")
  public String stop() {
    return timeManagementFacade.stopTask();
  }
}
