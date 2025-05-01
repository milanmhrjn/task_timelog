package taskandtimetracker.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskandtimetracker.task.model.TaskModel;
import taskandtimetracker.task.service.TaskService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskModel> taskCreate(@RequestBody TaskModel task){
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> allTasks(){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> taskById(@PathVariable int id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @DeleteMapping("/{id}")
    public String taskDelete(@PathVariable int id){
         ResponseEntity.ok(taskService.deleteTask(id));
         return "Task Deleted";
    }




    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateTaskStatus(@PathVariable int id, @RequestBody Map<String, String> statusUpdate) {
        String statusString = statusUpdate.get("status");
        try {
            TaskModel.Status status = TaskModel.Status.valueOf(statusString.toUpperCase());
            TaskModel task = taskService.updateTask(id, status);
            return ResponseEntity.ok(String.valueOf(task));
            }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid status provided");
        }
        }
    }




