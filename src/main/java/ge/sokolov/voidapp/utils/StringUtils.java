package ge.sokolov.voidapp.utils;

import jakarta.validation.constraints.NotEmpty;
import lombok.experimental.UtilityClass;

import java.util.Collection;

@UtilityClass
public class StringUtils {

    /**
     *
     * @param categories - Receive not empty collection of categories
     * @return formatted String of user categories
     */
    public String toCategoriesResponse(@NotEmpty Collection<String> categories) {
        return Response.CATEGORY_LIST +
               String.join(System.lineSeparator(), categories) +
               System.lineSeparator();
    }
}
