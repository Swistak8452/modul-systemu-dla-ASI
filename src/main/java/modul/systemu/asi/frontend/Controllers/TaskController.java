package modul.systemu.asi.frontend.Controllers;

import modul.systemu.asi.backend.dao.*;
import modul.systemu.asi.backend.services.NotificationService;
import modul.systemu.asi.backend.services.TaskService;
import modul.systemu.asi.frontend.model.Task;
import modul.systemu.asi.frontend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Controller
public class TaskController {

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

    @RequestMapping("/tasks/current-tasks-list")
    public String taskList(WebRequest request, Model model) {
        User user = userRepository.findByEmail(request.getRemoteUser());
        model.addAttribute("tasks", taskService.getAllTasksOfUser(user));
        model.addAttribute("notificationsForLayout", notificationService.getAllActiveNotifications().size());
        model.addAttribute("tasksForLayout", taskService.getAllActiveTasks().size());
        return "task/tasks-list";
    }

    @RequestMapping("/tasks/all-tasks-list")
    public String allTasksList(WebRequest request, Model model) {
        model.addAttribute("tasks", taskService.getAllActiveTasks());
        model.addAttribute("notificationsForLayout", notificationService.getAllActiveNotifications().size());
        model.addAttribute("tasksForLayout", taskService.getAllActiveTasks().size());
        return "task/tasks-list";
    }

    @RequestMapping("/tasks/add-task")
    public String addTask(WebRequest request, Model model) {
        model.addAttribute("priorities", priorityRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("notifications", notificationService.getAllActiveNotifications());
        model.addAttribute("notificationsForLayout", notificationService.getAllActiveNotifications().size());
        model.addAttribute("tasksForLayout", taskService.getAllActiveTasks().size());
        return "task/add-task";
    }

    @RequestMapping("/tasks/archived-tasks")
    public String archivedTasks(WebRequest request, Model model) {
        model.addAttribute("tasks", taskService.getAllArchivedTasks());
        model.addAttribute("notificationsForLayout", notificationService.getAllActiveNotifications().size());
        model.addAttribute("tasksForLayout", taskService.getAllActiveTasks().size());
        return "task/tasks-list";
    }

    @RequestMapping("/tasks/assign-task")
    public String assignTask(WebRequest request, Model model, @RequestParam long taskId) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task/assign-task";
    }

    @RequestMapping("/tasks/task-details")
    public String taskDetails(WebRequest request, Model model, @RequestParam long taskId) {
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task", task);
        model.addAttribute("comments", commentRepository.findAllByTaskOrderByDateAsc(task));
        return "task/task-details";
    }

    @RequestMapping("/tasks/task-history")
    public String taskHistory(WebRequest request, Model model, @RequestParam long taskId) {
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task", taskService.getTaskById(taskId));
        model.addAttribute("taskHistories", taskService.getTaskHistory(task));
        return "task/task-history";
    }

    @RequestMapping("/tasks/update-task")
    public String updateTask(WebRequest request, Model model, @RequestParam long taskId) {
        model.addAttribute("priorities", priorityRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("statuses", statusRepository.findAll());
        model.addAttribute("notifications", notificationService.getAllActiveNotifications());
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task/update-task";
    }

    @RequestMapping("/tasks/add-comment")
    public String addCommentToTask(WebRequest request, Model model, @RequestParam long taskId) {
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task/add-comment";
    }
}
