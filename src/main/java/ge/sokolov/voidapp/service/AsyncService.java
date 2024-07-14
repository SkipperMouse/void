package ge.sokolov.voidapp.service;

import ge.sokolov.voidapp.exception.ServerException;
import ge.sokolov.voidapp.model.TimeManagementTask;
import ge.sokolov.voidapp.model.enums.Status;
import ge.sokolov.voidapp.utils.Response;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

  private final TimeManagementTaskService timeManagementTaskService;
  private final Clock clock;

  @Async
  public void updateTask(TimeManagementTask taskToUpdate) {
    LocalDate taskCreationDate = taskToUpdate.getDate();
    try {
      do {
        Optional<TimeManagementTask> task =
            timeManagementTaskService.findTaskById(taskToUpdate.getId());
        if (!isReadyToUpdate(task)) {
          return;
        }
        if (taskCreationDate.equals(LocalDate.now(clock))) {
          timeManagementTaskService.incrementMinutes(taskToUpdate.getId());
        } else {
          timeManagementTaskService.stopTask();
          taskToUpdate =
              timeManagementTaskService.startTask(
                  taskToUpdate.getTask(), taskToUpdate.getCategory().getId());
        }

        // todo move task to executor instead of Thread.sleep
        long oneMinuteInMillis = 60000;
        Thread.sleep(oneMinuteInMillis);
      } while (true);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ServerException(Response.ERROR_UPDATE_WAS_INTERRUPTED);
    }
  }

  private boolean isReadyToUpdate(Optional<TimeManagementTask> task) {
    if (task.isEmpty()) {
      return false;
    }
    Status status = task.get().getStatus();
    return status != Status.FINISHED && status != Status.PAUSE;
  }
}
