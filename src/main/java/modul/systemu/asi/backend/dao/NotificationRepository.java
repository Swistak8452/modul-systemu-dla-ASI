package modul.systemu.asi.backend.dao;

import modul.systemu.asi.frontend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByArchivedOrderByDate(boolean isArchived);

    Notification findById(long id);

    List<Notification> findAllByOrderByDate();

}
