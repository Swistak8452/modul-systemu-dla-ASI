package modul.systemu.asi.frontend.Controllers;

import modul.systemu.asi.backend.services.NotificationService;
import modul.systemu.asi.backend.services.TaskService;
import modul.systemu.asi.frontend.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TaskService taskService;

    @RequestMapping("/notifications/notification-list")
    public String notificationList(WebRequest request, Model model) {
        model.addAttribute("notifications", notificationService.getAllActiveNotifications());
        model.addAttribute("notificationsForLayout", notificationService.getAllActiveNotifications().size());
        model.addAttribute("tasksForLayout", taskService.getAllActiveTasks().size());
        return "notification/notification-list";
    }

    @RequestMapping("/notifications/add-notification")
    public String addNotifications(WebRequest request, Model model) {
        Notification notification = new Notification();
        model.addAttribute("notificationsForLayout", notificationService.getAllActiveNotifications().size());
        model.addAttribute("tasksForLayout", taskService.getAllActiveTasks().size());
        return "notification/add-notification";
    }

    @RequestMapping("/notifications/archived-notifications")
    public String archivedNotifications(WebRequest request, Model model) {
        model.addAttribute("notifications", notificationService.getAllArchivedNotifications());
        model.addAttribute("notificationsForLayout", notificationService.getAllActiveNotifications().size());
        model.addAttribute("tasksForLayout", taskService.getAllActiveTasks().size());
        return "notification/notification-list";
    }

    @RequestMapping("/notifications/notification-details")
    public String notificationDetails(WebRequest request, Model model, @RequestParam long notificationId) {
        model.addAttribute("notification", notificationService.getNotificationById(notificationId));
        return "notification/notification-details";
    }

    @RequestMapping("/notifications/notification-history")
    public String notificationHistory(WebRequest request, Model model, @RequestParam long notificationId) {
        model.addAttribute("notification", notificationService.getNotificationById(notificationId));
        model.addAttribute("notificationHistory", notificationService.getHistoryOfNotification(notificationId));
        return "notification/notification-history";
    }

    @RequestMapping("/notifications/update-notification")
    public String updateNotification(WebRequest request, Model model, @RequestParam long notificationId) {
        model.addAttribute("notification", notificationService.getNotificationById(notificationId));
        return "notification/update-notification";
    }
}
