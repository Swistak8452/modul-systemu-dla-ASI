package modul.systemu.asi.backend.dao;

import modul.systemu.asi.frontend.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

    Priority findById(long id);
}
