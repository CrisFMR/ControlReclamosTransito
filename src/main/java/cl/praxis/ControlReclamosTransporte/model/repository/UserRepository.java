package cl.praxis.ControlReclamosTransporte.model.repository;

import cl.praxis.ControlReclamosTransporte.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}