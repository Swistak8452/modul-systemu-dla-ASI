package modul.systemu.asi.frontend;

import modul.systemu.asi.backend.services.NotificationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    NotificationHistoryService notificationHistoryService;

    @RequestMapping("/")
    public String index() {
        notificationHistoryService.returnNotificationHistoryByNotificationId(1);
        return "Greetings from Spring Boot!";
    }

}