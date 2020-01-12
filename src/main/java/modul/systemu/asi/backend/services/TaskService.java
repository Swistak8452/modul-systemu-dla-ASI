package modul.systemu.asi.backend.services;

import modul.systemu.asi.backend.dao.TaskHistoryRepository;
import modul.systemu.asi.backend.dao.TaskRepository;
import modul.systemu.asi.backend.dao.UserRepository;
import modul.systemu.asi.frontend.model.Notification;
import modul.systemu.asi.frontend.model.Task;
import modul.systemu.asi.frontend.model.TaskHistory;
import modul.systemu.asi.frontend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskHistoryRepository taskHistoryRepository;

    @Autowired
    UserRepository userRepository;

    public void addOrUpdateTask(Task task, String editorsEmail){
        User user = userRepository.findByEmail(editorsEmail);
        taskRepository.save(task);
        addNewTaskHistory(task, user);
    }

    public void addNewTask(Task task, String editorsEmail){
        User user = userRepository.findByEmail(editorsEmail);
        taskRepository.save(task);
        addNewTaskHistory(task, user);
    }

    public void updateTask(Task task, String editorsEmail){
        User user = userRepository.findByEmail(editorsEmail);
        taskRepository.save(task);
        addNewTaskHistory(task, user);
    }

    public Task getTaskById(long id){
        Task task = taskRepository.findById(id);
        return task;
    }

    public List<TaskHistory> getTaskHistory(Task task){
        List<TaskHistory> taskHistories = taskHistoryRepository.findAllByTaskIsLikeOrderByChangeDateTimeAsc(task);
        return taskHistories;
    }


    public List<Task> getAllTasks(){
        List<Task> tasks = taskRepository.findAllByOrderByPriorityDesc();
        return tasks;
    }

    public List<Task> getAllActiveTasks(){
        List<Task> tasks = taskRepository.findAllByArchivedOrderByPriorityDesc(false);
        return tasks;
    }

    public List<Task> getAllArchivedTasks(){
        List<Task> tasks = taskRepository.findAllByArchivedOrderByPriorityDesc(true);
        return tasks;
    }

    public List<Task> getAllTasksOfUser(User user){
        List<Task> tasks = taskRepository.findAllByAssignedPersonIsLikeOrderByDeadlineAsc(user);
        return tasks;
    }

    public List<Task> getAllTasksOfNotification(long id){
        Notification notification = new Notification();
        notification.setId(id);
        List<Task> tasks = taskRepository.findAllByRelatedNotificationIsLikeOrderByDeadlineAsc(notification);
        return tasks;
    }

    public void addNewTaskHistory(Task task, User editedByUser){
        TaskHistory previousTaskHistory = getPreviousHistoryOfTask(task);
        TaskHistory taskHistory = new TaskHistory();
        if(previousTaskHistory == null){
            taskHistory.setChangeNumber(0l);
            taskHistory.setPreviousAssignedPerson(null);
            taskHistory.setPreviousDeadline(null);
            taskHistory.setPreviousArchived(false);
            taskHistory.setPreviousDescription(null);
            taskHistory.setPreviousName(null);
            taskHistory.setPreviousPriority(null);
            taskHistory.setPreviousRelatedNotification(null);
            taskHistory.setPreviousStatus(null);
            taskHistory.setPreviousType(null);
        }else{
            taskHistory.setChangeNumber(previousTaskHistory.getChangeNumber()+1);
            taskHistory.setPreviousAssignedPerson(previousTaskHistory.getNewAssignedPerson());
            taskHistory.setPreviousDeadline(previousTaskHistory.getNewDeadline());
            taskHistory.setPreviousArchived(previousTaskHistory.isNewArchived());
            taskHistory.setPreviousDescription(previousTaskHistory.getNewDescription());
            taskHistory.setPreviousName(previousTaskHistory.getNewName());
            taskHistory.setPreviousPriority(previousTaskHistory.getNewPriority());
            taskHistory.setPreviousRelatedNotification(previousTaskHistory.getNewRelatedNotification());
            taskHistory.setPreviousStatus(previousTaskHistory.getNewStatus());
            taskHistory.setPreviousType(previousTaskHistory.getNewType());
        }
        taskHistory.setNewAssignedPerson(task.getAssignedPerson());
        taskHistory.setNewDeadline(task.getDeadline());
        taskHistory.setNewArchived(task.isArchived());
        taskHistory.setNewDescription(task.getDescription());
        taskHistory.setNewName(task.getName());
        taskHistory.setNewPriority(task.getPriority());
        taskHistory.setNewRelatedNotification(task.getRelatedNotification());
        taskHistory.setNewStatus(task.getStatus());
        taskHistory.setNewType(task.getType());
        taskHistory.setEditedBy(editedByUser);
        taskHistory.setTask(task);
        taskHistoryRepository.save(taskHistory);
    }

    public TaskHistory getPreviousHistoryOfTask(Task task) throws NullPointerException{
        Task temporaryTask = new Task();
        temporaryTask.setId(task.getId());
        TaskHistory previousTaskHistory = taskHistoryRepository.findTopByTaskIsLikeOrderByChangeNumberDesc(temporaryTask);
        return  previousTaskHistory;
    }


}
