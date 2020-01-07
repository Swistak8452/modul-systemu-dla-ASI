package modul.systemu.asi.backend.dao;

import modul.systemu.asi.frontend.model.Task;
import modul.systemu.asi.frontend.model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Long> {

    List<TaskHistory> findAllByTaskIsLikeOrderByChangeDateTimeAsc(Task task);

    TaskHistory findTopByTaskIsLikeOrderByChangeNumberDesc(Task task);

    TaskHistory findById(long id);
}
