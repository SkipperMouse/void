package ge.sokolov.voidapp.repository;

import ge.sokolov.voidapp.model.TimeManagementTask;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TimeManagementRepository extends CrudRepository<TimeManagementTask, UUID> {

    @Modifying
    @Query("update time_management set time_in_minutes = time_in_minutes + 1 where id = :id")
    void incrementTaskMinutes(UUID id);

    @Modifying
    @Query("update time_management set status = 'FINISHED'")
    void finishAllTasks();

    @Query("select * from time_management where status in('IN_PROGRESS', 'PAUSE')")
    List<TimeManagementTask> findAllUnfinishedTasks();
}
