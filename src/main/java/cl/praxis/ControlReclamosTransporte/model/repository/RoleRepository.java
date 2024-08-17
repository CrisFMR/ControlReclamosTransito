package cl.praxis.ControlReclamosTransporte.model.repository;

import cl.praxis.ControlReclamosTransporte.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}