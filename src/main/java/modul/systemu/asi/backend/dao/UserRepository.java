package modul.systemu.asi.backend.dao;

import modul.systemu.asi.frontend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findById(long id);

    List<User> findAll();
}
