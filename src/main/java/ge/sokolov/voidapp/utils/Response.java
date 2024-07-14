package ge.sokolov.voidapp.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Response {

  //    Error responses
  public static String ERROR_EMPTY_CATEGORIES =
      "You don't have any created categories. To create new category use category \"void category name\"\n";
  public static String ERROR_EMPTY_CATEGORY =
      "You need to specify a category name like that: 'category category_name\n";
  public static String ERROR_CATEGORY_EXIST = "Category with the same name: '%s' already exists\n";
  public static String ERROR_CATEGORY_NOT_EXISTS = "Category with the name: '%s' not exists\n";
  public static String ERROR_WRONG_START_COMMAND =
      "You should specify category and task name in format: 'void start work \"daily meeting\"'\n";

  //     Server errors
  public static final String SERVER_ERROR = "Server error\n";
  public static final String ERROR_UPDATE_WAS_INTERRUPTED =
      "Update of task %s of category %s was interrupted. Please start task again\n";

  //    Successful lines
  public static String CATEGORY_LIST = "Your list of Categories:\n";
  public static String SAVED_CATEGORY = "Category was successfully saved: \n%s\n";
  public static String DELETED_CATEGORY = "Category was successfully deleted: \n%s\n";
  public static String TASK_STARTED = "Task %s of category %s started at %s";
  public static String ABSENT_RUNNING_TASKS = "There is no running tasks";
  public static String LIST_OF_STOPPED_TASKS = "Next tasks have been stopped:\n";
}
