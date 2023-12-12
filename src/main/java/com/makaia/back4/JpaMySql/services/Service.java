package com.makaia.back4.JpaMySql.services;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.entities.Comentario;
import com.makaia.back4.JpaMySql.entities.Publicacion;
import com.makaia.back4.JpaMySql.entities.Usuario;
import com.makaia.back4.JpaMySql.exceptions.RedSocialApiException;
import com.makaia.back4.JpaMySql.publisher.Publisher;
import com.makaia.back4.JpaMySql.repositories.ComentarioRepository;
import com.makaia.back4.JpaMySql.repositories.PublicacionRepository;
import com.makaia.back4.JpaMySql.repositories.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
@Slf4j
public class Service {

    ComentarioRepository repository;
    UsuarioRepository usuarioRepository;

    @Autowired
    Publisher publisher;
    
    @Autowired
    PublicacionRepository publicacionRepository;

    public Service(ComentarioRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public Comentario crear(CrearDTO dto) {
        log.info("Comentario {}", dto);
        if (dto.getFechaComentario()==null || dto.getFechaComentario().equals(null)) {
            dto.setFechaComentario(new Date());
        }
        Usuario usuario = this.usuarioRepository
                .findById(dto.getUsuario_id())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede enviar solicitud"));
        Publicacion publicacion = this.publicacionRepository
                .findById(dto.getPublicacion_id())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede recibir solicitud"));
        Comentario nuevoComentario = new Comentario(dto.getContenido(),dto.getFechaComentario(),usuario, publicacion);

        Comentario comentario = this.repository.save(nuevoComentario);

        log.info("Comentario creado Exitosamente, {}", comentario);

        publisher.send(usuario.getId(), publicacion.getUsuario().getId());

        return comentario;
    }

    public List<Comentario> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }
}
