package edu.ilp.sisgailp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "docente")
@PrimaryKeyJoinColumn(referencedColumnName="IDPERSONA")
public class Docente extends Persona{

    @Column(name = "cod_docente", length = 15)
    private String codDocente;

    @Column(name = "horas_asignadas")
    private Double horasAsignadas;

    public Docente() {
    }

    public Docente(String codDocente, Double horasAsignadas) {
        this.codDocente = codDocente;
        this.horasAsignadas = horasAsignadas;
    }

    public Docente(Long idpersona, String codDocente, Double horasAsignadas) {
        super(idpersona);
        this.codDocente = codDocente;
        this.horasAsignadas = horasAsignadas;
    }

    public Docente(String nombre, String apellido, int edad, String dni, Date fechaNacimiento, String genero, String codDocente, Double horasAsignadas) {
        super(nombre, apellido, edad, dni, fechaNacimiento, genero);
        this.codDocente = codDocente;
        this.horasAsignadas = horasAsignadas;
    }

    public String getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(String codDocente) {
        this.codDocente = codDocente;
    }

    public Double getHorasAsignadas() {
        return horasAsignadas;
    }

    public void setHorasAsignadas(Double horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }
}
