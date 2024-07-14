package ge.sokolov.voidapp.service;

import ge.sokolov.voidapp.model.TimeManagementTask;
import ge.sokolov.voidapp.model.enums.Status;
import ge.sokolov.voidapp.repository.TimeManagementRepository;
import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeManagementTaskService {

  private final TimeManagementRepository repository;
  private final Clock clock;

  public TimeManagementTask startTask(String taskName, UUID categoryId) {
    TimeManagementTask timeManagementTask =
        TimeManagementTask.builder()
            .date(LocalDate.now(clock))
            .category(AggregateReference.to(categoryId))
            .task(taskName)
            .timeInMinutes(0L)
            .status(Status.IN_PROGRESS)
            .build();
    repository.finishAllTasks();
    return repository.save(timeManagementTask);
  }

  public Optional<TimeManagementTask> findTaskById(UUID id) {
    return repository.findById(id);
  }

  public void incrementMinutes(UUID id) {
    repository.incrementTaskMinutes(id);
  }

  public List<TimeManagementTask> stopTask() {
    List<TimeManagementTask> unfinishedTasks = repository.findAllUnfinishedTasks();
    unfinishedTasks.forEach(task -> task.setStatus(Status.FINISHED));
    return unfinishedTasks;
  }
}
