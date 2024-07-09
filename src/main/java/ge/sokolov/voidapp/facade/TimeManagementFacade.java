package ge.sokolov.voidapp.facade;

public interface TimeManagementFacade {

    String findAllCategories();

    String saveCategory(String categoryName);

    String removeCategory(String categoryName);
}
