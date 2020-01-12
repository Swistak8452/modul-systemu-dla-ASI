package modul.systemu.asi.backend.clients;

import modul.systemu.asi.backend.dao.CommentRepository;
import modul.systemu.asi.backend.dao.UserRepository;
import modul.systemu.asi.backend.services.NotificationService;
import modul.systemu.asi.frontend.model.Comment;
import modul.systemu.asi.frontend.model.Notification;
import modul.systemu.asi.frontend.model.User;
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

    @Autowired
    private CommentRepository commentRepository;

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

    @GetMapping("/notifications/save-updated-notification")
    public String saveUpdatedNotification(@RequestParam boolean archived,
                                          @RequestParam String name,
                                          @RequestParam String description,
                                          @RequestParam String editorsEmail,
                                          @RequestParam long notificationId) {
        Notification notification = notificationService.getNotificationById(notificationId);
        notification.setArchived(archived);
        notification.setName(name);
        notification.setDescription(description);
        notificationService.updateNotification(notification, editorsEmail);
        return "notification/save-notification";
    }

    @GetMapping("/notifications/change-field-archived-in-notification")
    public String saveUpdatedNotification(@RequestParam long notificationId,
                                          @RequestParam String editorsEmail) {
        Notification notification = notificationService.getNotificationById(notificationId);
        boolean isArchived = notification.isArchived();
        notification.setArchived(!isArchived);
        notificationService.updateNotification(notification, editorsEmail);
        return "notification/save-notification";
    }

    @GetMapping("/notifications/add-comment-to-notification")
    public String saveUpdatedTask(@RequestParam long notificationId,
                                  @RequestParam String editorsEmail,
                                  @RequestParam String text) {
        Notification notification = notificationService.getNotificationById(notificationId);
        User user = userRepository.findByEmail(editorsEmail);
        Comment comment = new Comment();
        comment.setNotification(notification);
        comment.setUser(user);
        comment.setText(text);
        commentRepository.save(comment);
        return "notification/save-notification";
    }

}
