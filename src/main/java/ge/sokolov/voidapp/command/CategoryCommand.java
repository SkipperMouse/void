package ge.sokolov.voidapp.command;

import ge.sokolov.voidapp.facade.TimeManagementFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

@Command(
    command = "category",
    alias = "c",
    group = "Categories",
    description = "Work with categories of tasks")
@RequiredArgsConstructor
public class CategoryCommand {

  private final TimeManagementFacade timeManagementFacade;

  @Command(
      command = "--list",
      alias = {"-l", "ls"},
      description = "List of all categories")
  public String getListOfCategories() {
    return timeManagementFacade.findAllCategories();
  }

  @Command(command = "", alias = "", description = "Save new category")
  public String saveNewCategory(@Option(description = "Name of the category") String categoryName) {
    return timeManagementFacade.saveCategory(categoryName);
  }

  @Command(command = "rm", alias = "rm", description = "Remove category")
  public String removeCategory(@Option(description = "Name of the category") String categoryName) {
    return timeManagementFacade.removeCategory(categoryName);
  }
}
