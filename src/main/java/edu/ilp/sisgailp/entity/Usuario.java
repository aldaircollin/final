package edu.ilp.sisgailp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "contraseña", nullable = false, length = 356)
    private String contrasenia;

    @OneToOne
    @JoinColumn(name = "idpersona",referencedColumnName = "idpersona")
    private Persona persona;

    @ManyToMany
    @JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name = "idusuario"),
    inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(String username, String contrasenia, Persona persona) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.persona = persona;
    }

    public Usuario(Long idusuario, String username, String contrasenia, Persona persona, Set<Rol> roles) {
        this.idusuario = idusuario;
        this.username = username;
        this.contrasenia = contrasenia;
        this.persona = persona;
        this.roles = roles;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
