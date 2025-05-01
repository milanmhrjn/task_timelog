package taskandtimetracker.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskandtimetracker.task.model.TimeLogModel;

import java.util.List;

public interface TimeLogRepository extends JpaRepository<TimeLogModel,Integer> {
    List<TimeLogModel> findByTaskId(int taskId);
}
