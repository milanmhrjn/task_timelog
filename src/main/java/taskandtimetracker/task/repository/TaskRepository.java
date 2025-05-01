package taskandtimetracker.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskandtimetracker.task.model.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Integer> {
}
