package ge.sokolov.voidapp.facade;

import ge.sokolov.voidapp.exception.ValidationException;
import ge.sokolov.voidapp.model.Category;
import ge.sokolov.voidapp.model.TimeManagementTask;
import ge.sokolov.voidapp.service.AsyncService;
import ge.sokolov.voidapp.service.CategoryService;
import ge.sokolov.voidapp.service.TimeManagementTaskService;
import ge.sokolov.voidapp.utils.Response;
import ge.sokolov.voidapp.utils.StringUtils;
import ge.sokolov.voidapp.utils.ValidationUtils;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InMemoryTimeManagementFacade implements TimeManagementFacade {

  private final CategoryService categoryService;
  private final TimeManagementTaskService timeManagementTaskService;
  private final AsyncService asyncService;

  @Override
  public String findAllCategories() {
    Set<String> categories = categoryService.getCategoriesNames();
    if (categories.isEmpty()) {
      throw new ValidationException(Response.ERROR_EMPTY_CATEGORIES);
    }
    return StringUtils.concatenateWithNewLines(Response.CATEGORY_LIST, categories);
  }

  @Override
  public String saveCategory(@NotNull String categoryName) {
    ValidationUtils.validateSaveOrRemoveCategoryCommand(categoryName);
    String savedName = categoryService.save(categoryName.toLowerCase()).getName();
    return String.format(Response.SAVED_CATEGORY, savedName);
  }

  @Override
  public String removeCategory(@NotNull String categoryName) {
    ValidationUtils.validateSaveOrRemoveCategoryCommand(categoryName);
    categoryService.deleteByName(categoryName);
    return String.format(Response.DELETED_CATEGORY, categoryName);
  }

  @Override
  public String startTask(String taskName, String categoryName) {
    ValidationUtils.validateStartCommand(taskName, categoryName);
    taskName = taskName.toLowerCase();
    categoryName = categoryName.toLowerCase();
    Optional<Category> category = categoryService.findByName(categoryName);
    if (category.isEmpty()) {
      throw new ValidationException(
          String.format(Response.ERROR_CATEGORY_NOT_EXISTS, categoryName));
    }
    TimeManagementTask task = timeManagementTaskService.startTask(taskName, category.get().getId());
    asyncService.updateTask(task);
    return String.format(Response.TASK_STARTED, task.getTask(), categoryName, task.getCreatedAt());
  }

  @Override
  public String stopTask() {
    List<TimeManagementTask> stoppedTasks = timeManagementTaskService.stopTask();
    if (stoppedTasks.isEmpty()) {
      return Response.ABSENT_RUNNING_TASKS;
    }
    return StringUtils.concatenateWithNewLines(
        Response.LIST_OF_STOPPED_TASKS,
        stoppedTasks.stream().map(TimeManagementTask::getTask).toList());
  }
}
