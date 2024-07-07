package ge.sokolov.voidapp.repository;

import ge.sokolov.voidapp.model.TimeManagement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeManagementRepository extends CrudRepository<TimeManagement, UUID> {
}
