package modul.systemu.asi.backend.dao;

import modul.systemu.asi.backend.model.Notification;
import modul.systemu.asi.backend.model.NotificationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationHistoryRepository extends JpaRepository<NotificationHistory, Long> {

    List<NotificationHistory> findByNotificationIsLike(Notification specialNotification);
}
