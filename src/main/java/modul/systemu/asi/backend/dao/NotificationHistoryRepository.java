package modul.systemu.asi.backend.dao;

import modul.systemu.asi.frontend.model.Notification;
import modul.systemu.asi.frontend.model.NotificationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationHistoryRepository extends JpaRepository<NotificationHistory, Long> {

    List<NotificationHistory> findAllByNotificationIsLikeOrderByChangeDateTimeAsc(Notification notification);

    NotificationHistory findTopByNotificationIsLikeOrderByChangeNumberDesc(Notification notification);
}
