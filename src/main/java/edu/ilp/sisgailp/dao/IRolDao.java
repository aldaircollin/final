package edu.ilp.sisgailp.dao;

import edu.ilp.sisgailp.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRolDao extends JpaRepository<Rol, Long> {

    Rol findByNombrerol(String roleName);

    @Query("SELECT r FROM Rol r WHERE r.idrol = :idrol")
    Rol findByIdrol(@Param("idrol") Long idrol);
}
