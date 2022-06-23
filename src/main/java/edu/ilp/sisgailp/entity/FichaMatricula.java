package edu.ilp.sisgailp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fichamatricula")
@PrimaryKeyJoinColumn(referencedColumnName="IDASIGNATURA")
public class FichaMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfichamatricula;

    @Column(name = "semestre", nullable = false, length = 50)
    private String semestre;

    @Column(name = "añoacademico", nullable = false, length = 50)
    private String añoacademico;

    @Column(name = "fmatricula", nullable = false, length = 50)
    private String fmatricula;

    @OneToOne
    @JoinColumn(name = "idasignatura",referencedColumnName = "idasignatura")
    private Asignatura asignatura;

    @ManyToOne
    private Estudiante estudiante;








}
