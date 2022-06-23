package edu.ilp.sisgailp.dao;

import edu.ilp.sisgailp.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona, Long> {
}
