package edu.ilp.sisgailp.entity;

import javax.persistence.*;

@Entity
@Table(name = "asignatura")
@Inheritance( strategy = InheritanceType.JOINED )
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasignatura", length = 10)
    private Long idasignatura;

    @Column(name = "sigla", length = 20, nullable = false)
    private String sigla;

    @Column(name = "denominacion", length = 100, nullable = false)
    private String denominacion;

    @Column(name = "credito", length = 20, nullable = false)
    private String credito;

    @Column(name = "hteorica", length = 20, nullable = false)
    private String hteorica;

    @Column(name = "hpractica", length = 20, nullable = false)
    private String hpractica;
}
