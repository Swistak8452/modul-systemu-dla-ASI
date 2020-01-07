package modul.systemu.asi.backend.dao;

import modul.systemu.asi.frontend.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findById(long id);
}
