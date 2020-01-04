package modul.systemu.asi.backend.services;

import modul.systemu.asi.backend.dao.NotificationHistoryRepository;
import modul.systemu.asi.backend.model.Notification;
import modul.systemu.asi.backend.model.NotificationHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationHistoryService {

    @Autowired
    NotificationHistoryRepository notificationHistoryRepository;

    public void returnNotificationHistoryByNotificationId(long id){
        Notification notification = new Notification();
        notification.setId(id);
        System.out.println("Jedziem");
        List<NotificationHistory> notificationHistories = notificationHistoryRepository.findByNotificationIsLike(notification);
        for (NotificationHistory notificationHistory: notificationHistories) {
            System.out.println("xxx");
            System.out.println(notificationHistory.getNewDescription());
        }
        System.out.println("Stop");
    }
}
