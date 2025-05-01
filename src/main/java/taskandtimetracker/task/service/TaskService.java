package taskandtimetracker.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskandtimetracker.task.model.TaskModel;
import taskandtimetracker.task.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskModel createTask(TaskModel task){
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public List<TaskModel> getAllTask(){
        return taskRepository.findAll();
    }

    public TaskModel getTaskById(int id){
        return taskRepository.findById(id).orElse(null);
    }

    public String deleteTask(int id){
         TaskModel tasks = taskRepository.findById(id).orElse(null);
         if(tasks!=null){
             taskRepository.deleteById(id);
         }
        return "Task is not available";
    }

public TaskModel updateTask(int id, TaskModel.Status status) {
    TaskModel task = taskRepository.findById(id).orElse(null);

    if (task != null) {
        task.setStatus(status);
        task.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(task);
    }

    return task;
}
}
