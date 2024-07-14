package ge.sokolov.voidapp.utils;

import jakarta.validation.constraints.NotEmpty;
import java.util.Collection;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

  /**
   * @param firstString - First line of the new String
   * @param stringCollection - Receive not empty collection strings which will be concatenated with
   *     first string
   * @return formatted String separated with new lines
   */
  public String concatenateWithNewLines(
      String firstString, @NotEmpty Collection<String> stringCollection) {
    return firstString + String.join(System.lineSeparator(), stringCollection);
  }
}
