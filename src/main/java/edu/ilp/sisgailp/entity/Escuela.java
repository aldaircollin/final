package edu.ilp.sisgailp.entity;

import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "escuela")
public class Escuela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idescuela;

    private String denominacion;

    private String codigoEscuela;

    //@OneToMany(mappedBy = "escuela")
    //private List<Estudiante> estudiantes;

    public Escuela() {
    }

    public Escuela(Long idescuela) {
        this.idescuela = idescuela;
    }

    public Escuela(Long idescuela, String denominacion, String codigoEscuela) {
        this.idescuela = idescuela;
        this.denominacion = denominacion;
        this.codigoEscuela = codigoEscuela;
    }

    public Long getIdescuela() {
        return idescuela;
    }

    public void setIdescuela(Long idescuela) {
        this.idescuela = idescuela;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getCodigoEscuela() {
        return codigoEscuela;
    }

    public void setCodigoEscuela(String codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }
}
