package taskandtimetracker.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskandtimetracker.task.model.TimeLogModel;
import taskandtimetracker.task.service.TimeLogService;

import java.util.List;

@RestController
@RequestMapping("/timelog")
public class TimeLogController {
    @Autowired
    TimeLogService timeLogService;
    
    @PostMapping
    public ResponseEntity<String> createLog(@RequestBody TimeLogModel timeLogModel){
        return ResponseEntity.ok(timeLogService.createTimeLog(timeLogModel));
    }
    
    @GetMapping("/{taskId}")
    public List<TimeLogModel> getAllTimeLog(@PathVariable int taskId){
        return timeLogService.getAllTimeLog(taskId);
    }


    @DeleteMapping("/{id}")
    public void deleteTimeLog(@PathVariable int id) {
        timeLogService.deleteTimeLog(id);
    }
}
