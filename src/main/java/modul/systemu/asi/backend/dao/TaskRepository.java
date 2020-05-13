package modul.systemu.asi.backend.dao;

import modul.systemu.asi.frontend.model.Notification;
import modul.systemu.asi.frontend.model.Status;
import modul.systemu.asi.frontend.model.Task;
import modul.systemu.asi.frontend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByArchivedOrderByPriorityDesc(boolean isArchived);

    List<Task> findAllByArchivedAndStatusIsNotLikeOrderByPriorityDesc(boolean isArchived, Status status);

    Task findById(long id);

    List<Task> findAllByOrderByPriorityDesc();

    List<Task> findAllByRelatedNotificationIsLikeOrderByDeadlineAsc(Notification notification);

    List<Task> findAllByAssignedPersonIsLikeAndArchivedOrderByDeadlineAsc(User user, boolean isArchived);

    Task findByOrderByIdDesc();
}
