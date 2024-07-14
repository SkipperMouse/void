package ge.sokolov.voidapp.repository;

import ge.sokolov.voidapp.model.Category;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, UUID> {

  @Override
  @SuppressWarnings("NullableProblems")
  Set<Category> findAll();

  @Modifying
  @Query("delete from category where name = :categoryName")
  int deleteByName(String categoryName);

  Optional<Category> findByName(String categoryName);
}
