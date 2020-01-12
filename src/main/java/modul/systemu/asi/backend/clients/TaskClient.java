package modul.systemu.asi.backend.clients;

import modul.systemu.asi.backend.dao.*;
import modul.systemu.asi.backend.services.NotificationService;
import modul.systemu.asi.backend.services.TaskService;
import modul.systemu.asi.frontend.model.Comment;
import modul.systemu.asi.frontend.model.Task;
import modul.systemu.asi.frontend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class TaskClient {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PriorityRepository priorityRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/tasks/save-task")
    public String saveTask(@RequestParam(defaultValue = "-1") long id,
                           @RequestParam boolean archived,
                           @RequestParam String deadline,
                           @RequestParam String description,
                           @RequestParam String name,
                           @RequestParam long assignedPersonId,
                           @RequestParam long priorityId,
                           @RequestParam long relatedNotificationId,
                           @RequestParam long statusId,
                           @RequestParam long typeId,
                           @RequestParam String editorsEmail
    ) {
        Task task;
        if (id == -1) {
            task = new Task();
        } else {
            task = taskService.getTaskById(id);
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dateInString = deadline + " 00:00:00";
            Date date = sdf.parse(dateInString);
            task.setDeadline(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        task.setArchived(archived);
        task.setDescription(description);
        task.setName(name);
        task.setAssignedPerson(userRepository.findById(assignedPersonId));
        task.setPriority(priorityRepository.findById(priorityId));
        task.setRelatedNotification(notificationService.getNotificationById(relatedNotificationId));
        task.setStatus(statusRepository.findById(statusId));
        task.setType(typeRepository.findById(typeId));
        taskService.addOrUpdateTask(task, editorsEmail);
        return "task/save-task";
    }

    @GetMapping("/tasks/save-updated-task")
    public String saveUpdatedTask(@RequestParam boolean archived,
                                  @RequestParam String deadline,
                                  @RequestParam String description,
                                  @RequestParam String name,
                                  @RequestParam long assignedPersonId,
                                  @RequestParam long priorityId,
                                  @RequestParam long relatedNotificationId,
                                  @RequestParam long statusId,
                                  @RequestParam long typeId,
                                  @RequestParam String editorsEmail,
                                  @RequestParam long taskId
    ) {
        Task task = taskService.getTaskById(taskId);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dateInString = deadline + " 00:00:00";
            Date date = sdf.parse(dateInString);
            task.setDeadline(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        task.setArchived(archived);
        task.setDescription(description);
        task.setName(name);
        task.setAssignedPerson(userRepository.findById(assignedPersonId));
        task.setPriority(priorityRepository.findById(priorityId));
        task.setRelatedNotification(notificationService.getNotificationById(relatedNotificationId));
        task.setStatus(statusRepository.findById(statusId));
        task.setType(typeRepository.findById(typeId));
        taskService.updateTask(task, editorsEmail);
        return "task/save-task";
    }

    @GetMapping("/tasks/change-field-archived-in-task")
    public String saveUpdatedTask(@RequestParam long taskId,
                                  @RequestParam String editorsEmail) {
        Task task = taskService.getTaskById(taskId);
        boolean isArchived = task.isArchived();
        task.setArchived(!isArchived);
        taskService.updateTask(task, editorsEmail);
        return "task/save-task";
    }

    @GetMapping("/tasks/assign-user-to-task")
    public String saveUpdatedTask(@RequestParam long taskId,
                                  @RequestParam String editorsEmail,
                                  @RequestParam long assignedPersonId) {
        Task task = taskService.getTaskById(taskId);
        task.setAssignedPerson(userRepository.findById(assignedPersonId));
        taskService.updateTask(task, editorsEmail);
        return "task/save-task";
    }

    @GetMapping("/tasks/add-comment-to-task")
    public String saveUpdatedTask(@RequestParam long taskId,
                                  @RequestParam String editorsEmail,
                                  @RequestParam String text) {
        Task task = taskService.getTaskById(taskId);
        User user = userRepository.findByEmail(editorsEmail);
        Comment comment = new Comment();
        comment.setTask(task);
        comment.setUser(user);
        comment.setText(text);
        commentRepository.save(comment);
        return "task/save-task";
    }
}
