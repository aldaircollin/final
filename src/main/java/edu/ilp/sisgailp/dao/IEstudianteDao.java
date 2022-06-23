package edu.ilp.sisgailp.dao;

import edu.ilp.sisgailp.entity.Escuela;
import edu.ilp.sisgailp.entity.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEstudianteDao extends JpaRepository<Estudiante, Long> {

    //Lista estudiantes por escuela
    List<Estudiante> findByEscuela(Escuela idescuela);

    //Lista estudiantes por escuela por páginas
    @Query("SELECT e FROM Estudiante e WHERE e.escuela = :idescuela ")
    Page<Estudiante> listaEstudiantes(Pageable pageable, @Param("idescuela")Escuela idescuela);

    //Obtener estudiante por dni o codigo
    @Query("SELECT e FROM Estudiante e WHERE e.codigo = :coddni OR e.dni = :coddni")
    Estudiante obtenerEstudiante(@Param("coddni") String coddni);

    //Lista estudiante por apellido o nombre
    @Query("SELECT e FROM Estudiante e WHERE e.nombre LIKE CONCAT('%',:appnombre,'%') OR e.apellido LIKE CONCAT('%',:appnombre,'%') ")
    List<Estudiante> listarEstudiantesByAppNombre(@Param("appnombre") String appnombre);
}
