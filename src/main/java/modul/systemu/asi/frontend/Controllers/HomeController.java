package modul.systemu.asi.frontend.Controllers;

import modul.systemu.asi.backend.dao.UserRepository;
import modul.systemu.asi.backend.services.NotificationService;
import modul.systemu.asi.backend.services.TaskService;
import modul.systemu.asi.frontend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class HomeController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home(WebRequest request, Model model) {
        User user = userRepository.findByEmail(request.getRemoteUser());
        model.addAttribute("user", user);
        model.addAttribute("tasksForLayout", taskService.getAllTasksOfUser(user).size());
        model.addAttribute("notificationsForLayout", notificationService.getAllActiveNotifications().size());
        return "index";
    }
}