package ge.sokolov.voidapp.utils;

import ge.sokolov.voidapp.exception.ValidationException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationUtils {

  public void validateSaveOrRemoveCategoryCommand(String categoryName) {
    if (categoryName == null || categoryName.isEmpty()) {
      throw new ValidationException(Response.ERROR_EMPTY_CATEGORY);
    }
  }

  public void validateStartCommand(String taskName, String categoryName) {
    if (categoryName == null || categoryName.isEmpty() || taskName == null || taskName.isEmpty()) {
      throw new ValidationException(Response.ERROR_WRONG_START_COMMAND);
    }
  }
}
