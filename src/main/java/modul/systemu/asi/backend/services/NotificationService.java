package modul.systemu.asi.backend.services;

import modul.systemu.asi.backend.dao.NotificationHistoryRepository;
import modul.systemu.asi.backend.dao.NotificationRepository;
import modul.systemu.asi.backend.dao.UserRepository;
import modul.systemu.asi.frontend.model.Notification;
import modul.systemu.asi.frontend.model.NotificationHistory;
import modul.systemu.asi.frontend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationHistoryRepository notificationHistoryRepository;

    @Autowired
    UserRepository userRepository;

    public void addNewNotification(Notification notification, String editorsEmail){
        User user = userRepository.findByEmail(editorsEmail);
        notificationRepository.save(notification);
        addNewNotificationHistory(notification, user);
    }

    public void updateNotification(Notification notification, String editorsEmail){
        User user = userRepository.findByEmail(editorsEmail);
        notificationRepository.save(notification);
        addNewNotificationHistory(notification, user);
    }

    public Notification getNotificationById(long id){
        Notification notification = notificationRepository.findById(id);
        return notification;
    }

    public List<Notification> getAllNotifications(){
        List<Notification> notifications = notificationRepository.findAllByOrderByDate();
        return notifications;
    }

    public List<Notification> getAllNotrificationsOfUser(User user){
        List<Notification> notifications = notificationRepository.findAllByOrderByDate();
        return notifications;
    }

    public List<Notification> getAllActiveNotifications(){
        List<Notification> notifications = notificationRepository.findAllByArchivedOrderByDate(false);
        return notifications;
    }

    public List<Notification> getAllArchivedNotifications(){
        List<Notification> notifications = notificationRepository.findAllByArchivedOrderByDate(true);
        return notifications;
    }

    public List<NotificationHistory> getHistoryOfNotification(long id){
        Notification notification = new Notification();
        notification.setId(id);
        List<NotificationHistory> notificationHistories =
                notificationHistoryRepository.findAllByNotificationIsLikeOrderByChangeDateTimeAsc(notification);
        return notificationHistories;
    }

    public void addNewNotificationHistory(Notification notification, User editedByUser){
        NotificationHistory previousNotificationHistory = getPreviousHistoryOfNotification(notification);
        NotificationHistory notificationHistory = new NotificationHistory();
        if(previousNotificationHistory == null){
            System.out.println("Brak historii");
            notificationHistory.setChangeNumber(0l);
            notificationHistory.setPreviousDate(null);
            notificationHistory.setPreviousArchived(false);
            notificationHistory.setPreviousDescription(null);
            notificationHistory.setPreviousName(null);
        }else {
            notificationHistory.setChangeNumber(previousNotificationHistory.getChangeNumber()+1);
            notificationHistory.setPreviousDate(previousNotificationHistory.getNewDate());
            notificationHistory.setPreviousArchived(previousNotificationHistory.isNewArchived());
            notificationHistory.setPreviousDescription(previousNotificationHistory.getNewDescription());
            notificationHistory.setPreviousName(previousNotificationHistory.getNewName());
        }
        notificationHistory.setEditedBy(editedByUser);
        notificationHistory.setNotification(notification);
        notificationHistory.setNewArchived(notification.isArchived());
        notificationHistory.setNewDate(notification.getDate());
        notificationHistory.setNewDescription(notification.getDescription());
        notificationHistory.setNewName(notification.getName());
        notificationHistoryRepository.save(notificationHistory);
    }

    public NotificationHistory getPreviousHistoryOfNotification(Notification notification) throws NullPointerException{
        Notification temporaryNotification = new Notification();
        temporaryNotification.setId(notification.getId());
        NotificationHistory previousNotificationHistory =
                notificationHistoryRepository.findTopByNotificationIsLikeOrderByChangeNumberDesc(temporaryNotification);
        return previousNotificationHistory;
    }

}
