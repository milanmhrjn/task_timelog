package taskandtimetracker.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskandtimetracker.task.model.TimeLogModel;
import taskandtimetracker.task.repository.TimeLogRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TimeLogService {
    @Autowired
    private TimeLogRepository timeLogRepository;

    public String createTimeLog(TimeLogModel timeLog){
        if(timeLog.getEndTime().isBefore(timeLog.getStartTime())){
            return "end time must be after start time";
        }
        else{
          TimeLogModel  createLogTime =  timeLogRepository.save(timeLog);
          return "time log created";
        }
    }

    public List<TimeLogModel> getAllTimeLog(int id){
        return timeLogRepository.findByTaskId(id);
    }

    public void deleteTimeLog(int id) {
        timeLogRepository.deleteById(id);
    }

}
