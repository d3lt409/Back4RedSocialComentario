package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String contenido;

    @Column
    private Date fechaComentario;

    @ManyToOne(optional = false)
    Usuario usuario;

    @ManyToOne(optional = false)
    Publicacion publicacion;

    public Comentario() {
    }


    public Comentario(String contenido, Date fechaComentario, Usuario usuario, Publicacion publicacion) {
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaComentario() {
        return this.fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacion getPublicacion() {
        return this.publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Comentario id(Long id) {
        setId(id);
        return this;
    }

    public Comentario contenido(String contenido) {
        setContenido(contenido);
        return this;
    }

    public Comentario fechaComentario(Date fechaComentario) {
        setFechaComentario(fechaComentario);
        return this;
    }

    public Comentario usuario(Usuario usuario) {
        setUsuario(usuario);
        return this;
    }

    public Comentario publicacion(Publicacion publicacion) {
        setPublicacion(publicacion);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Comentario)) {
            return false;
        }
        Comentario comentario = (Comentario) o;
        return Objects.equals(id, comentario.id) && Objects.equals(contenido, comentario.contenido) && Objects.equals(fechaComentario, comentario.fechaComentario) && Objects.equals(usuario, comentario.usuario) && Objects.equals(publicacion, comentario.publicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contenido, fechaComentario, usuario, publicacion);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", contenido='" + getContenido() + "'" +
            ", fechaComentario='" + getFechaComentario() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", publicacion='" + getPublicacion() + "'" +
            "}";
    }
    
    
}
