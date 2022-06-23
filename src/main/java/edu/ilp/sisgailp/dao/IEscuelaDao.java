package edu.ilp.sisgailp.dao;

import edu.ilp.sisgailp.entity.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEscuelaDao extends JpaRepository<Escuela,Long> {

    //Obtiene una escuela a travéz de su código
    Escuela findByCodigoEscuela(String codigo);

    @Query("SELECT e FROM Escuela e WHERE e.codigoEscuela = ?1")
    Escuela obtenerEscuelaPorCodigo(String codigo);

    @Query("SELECT e FROM Escuela e WHERE e.codigoEscuela = :codigo")
    Escuela obtenerEscuelaPorParam(@Param("codigo") String codigo);

    //Obtiene una escuela a través de su id y denominación
    Escuela findByIdescuelaAndDenominacion(Long idescuela, String denominacion);

}
