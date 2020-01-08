package modul.systemu.asi.backend.clients;

import modul.systemu.asi.backend.dao.UserRepository;
import modul.systemu.asi.backend.services.NotificationService;
import modul.systemu.asi.frontend.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotificationClient {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/notifications/save-notification")
    public String saveNotification(@RequestParam boolean archived,
                                   @RequestParam String name,
                                   @RequestParam String description,
                                   @RequestParam String editorsEmail) {
        Notification notification = new Notification();
        notification.setArchived(archived);
        notification.setName(name);
        notification.setDescription(description);
        notificationService.addNewNotification(notification, editorsEmail);
        return "notification/save-notification";
    }
}
