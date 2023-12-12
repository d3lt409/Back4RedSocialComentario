package com.makaia.back4.JpaMySql.dtos;

import java.util.Date;
import java.util.Objects;

public class CrearDTO {

    private Long publicacion_id;

    private Long usuario_id;

    private String contenido;

    private Date fechaComentario;


    public CrearDTO() {
    }


    public CrearDTO(Long publicacion_id, Long usuario_id, String contenido) {
        this.publicacion_id = publicacion_id;
        this.usuario_id = usuario_id;
        this.contenido = contenido;
        this.fechaComentario = new Date();
    }

    public Long getPublicacion_id() {
        return this.publicacion_id;
    }

    public void setPublicacion_id(Long publicacion_id) {
        this.publicacion_id = publicacion_id;
    }

    public Long getUsuario_id() {
        return this.usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
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

    public CrearDTO publicacion_id(Long publicacion_id) {
        setPublicacion_id(publicacion_id);
        return this;
    }

    public CrearDTO usuario_id(Long usuario_id) {
        setUsuario_id(usuario_id);
        return this;
    }

    public CrearDTO contenido(String contenido) {
        setContenido(contenido);
        return this;
    }

    public CrearDTO fechaComentario(Date fechaComentario) {
        setFechaComentario(fechaComentario);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CrearDTO)) {
            return false;
        }
        CrearDTO crearDTO = (CrearDTO) o;
        return Objects.equals(publicacion_id, crearDTO.publicacion_id) && Objects.equals(usuario_id, crearDTO.usuario_id) && Objects.equals(contenido, crearDTO.contenido) && Objects.equals(fechaComentario, crearDTO.fechaComentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicacion_id, usuario_id, contenido, fechaComentario);
    }

    @Override
    public String toString() {
        return "{" +
            " publicacion_id='" + getPublicacion_id() + "'" +
            ", usuario_id='" + getUsuario_id() + "'" +
            ", contenido='" + getContenido() + "'" +
            ", fechaComentario='" + getFechaComentario() + "'" +
            "}";
    }


    
}
