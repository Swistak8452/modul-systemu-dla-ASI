package modul.systemu.asi.backend.dao;

import modul.systemu.asi.frontend.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findById(long id);
}
