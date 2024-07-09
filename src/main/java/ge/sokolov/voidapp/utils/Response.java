package ge.sokolov.voidapp.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Response {

//    Error responses
    public static String ERROR_EMPTY_CATEGORIES = "You don't have any created categories. To create new category use category \"category name\"\n";
    public static String ERROR_EMPTY_CATEGORY = "You need to specify a category name like that: 'category category_name\n";
    public static String ERROR_CATEGORY_EXIST = "Category with the same name: '%s' already exists\n";
    public static String ERROR_CATEGORY_NOT_EXISTS = "Category with the name: '%s' not exists\n";

    public static final String SERVER_ERROR = "Server error\n";

//    Successful lines
    public static String CATEGORY_LIST = "Your list of Categories:\n";
    public static String SAVED_CATEGORY = "Category was successfully saved: \n%s\n";
    public static String DELETED_CATEGORY = "Category was successfully deleted: \n%s\n";
}
