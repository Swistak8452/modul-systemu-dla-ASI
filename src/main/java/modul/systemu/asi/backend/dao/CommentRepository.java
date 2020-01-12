package modul.systemu.asi.backend.dao;

import modul.systemu.asi.frontend.model.Comment;
import modul.systemu.asi.frontend.model.Notification;
import modul.systemu.asi.frontend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByNotificationOrderByDateAsc(Notification notification);

    List<Comment> findAllByTaskOrderByDateAsc(Task task);
}
