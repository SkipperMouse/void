package ge.sokolov.voidapp.facade;

import ge.sokolov.voidapp.exception.ValidationException;
import ge.sokolov.voidapp.model.Category;
import ge.sokolov.voidapp.service.CategoryService;
import ge.sokolov.voidapp.utils.Response;
import ge.sokolov.voidapp.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InMemoryTimeManagementFacade implements TimeManagementFacade {

    private final CategoryService categoryService;

    @Override
    public String processCategory(String categoryName, String listFlag) {
        if (listFlag == null) {
            return findAllCategories();
        }
        return saveCategory(categoryName);
    }

    public String findAllCategories() {
        Set<String> categories = categoryService.findAll().stream()
                .map(Category::getName)
                .collect(Collectors.toSet());
        if (categories.isEmpty()) {
            throw new ValidationException(Response.ERROR_EMPTY_CATEGORIES);
        }
        return StringUtils.toCategoriesResponse(categories);
    }

    private String saveCategory(String categoryName) {
        if (categoryName == null || categoryName.isEmpty()) {
            return Response.ERROR_EMPTY_CATEGORY;
        }
        String savedName = categoryService.save(categoryName.toLowerCase()).getName();
        return String.format(Response.SAVED_CATEGORY, savedName);
    }
}

