package modul.systemu.asi.frontend.Controllers;

import modul.systemu.asi.backend.services.NotificationService;
import modul.systemu.asi.backend.services.TaskService;
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

    @RequestMapping("/")
    public String home(WebRequest request, Model model) {
        String user = request.getRemoteUser();
        model.addAttribute("tasksForLayout", taskService.getAllActiveTasks().size());
        model.addAttribute("notificationsForLayout", notificationService.getAllActiveNotifications().size());
        return "index";
    }
}