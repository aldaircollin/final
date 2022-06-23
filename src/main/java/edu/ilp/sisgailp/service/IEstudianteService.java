package edu.ilp.sisgailp.service;

import edu.ilp.sisgailp.entity.Escuela;
import edu.ilp.sisgailp.entity.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEstudianteService {

    //Este método registra un estudiante
    Estudiante guardarEstudiante(Estudiante estudiante);

    //Lista de estudiantes por escuela
    List<Estudiante> listaEstudiantes(Escuela idescuela);

    //Lista estudiantes por escuela y por páginas
    Page<Estudiante> listaEstudianteByPagina(Pageable pageable, Escuela idescuela);

    //Eliminar un estudiante de la base de datos
    void eliminarEstudiante(Long idestudiante);

    //Obtener estudiante a travéz de su código ó dni
    Estudiante obtenerEstudiante(String coddni);

    //Obtener estudiante mediante su nombre o apellido
    List<Estudiante> listarEstudiantePorApeNombre(String apenombre);

    //Actualizar registro de estudiantes
}
