package ge.sokolov.voidapp.service;

import ge.sokolov.voidapp.exception.ServerException;
import ge.sokolov.voidapp.exception.ValidationException;
import ge.sokolov.voidapp.model.Category;
import ge.sokolov.voidapp.repository.CategoryRepository;
import ge.sokolov.voidapp.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public Category save(String categoryName) {
        try {
            return repository.save(new Category(categoryName));
        } catch (DbActionExecutionException e) {
            if (e.getCause() instanceof DuplicateKeyException) {
                throw new ValidationException(String.format(Response.ERROR_CATEGORY_EXIST, categoryName));
            }
            throw new ServerException();
        }
    }

    public Set<Category> findAll() {
        return repository.findAll();
    }
}
