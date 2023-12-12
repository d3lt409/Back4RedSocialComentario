package com.makaia.back4.JpaMySql.controllers;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.entities.Comentario;
import com.makaia.back4.JpaMySql.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comentario")
public class Controller {
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Comentario> crearComentario(@RequestBody CrearDTO dto) {
        Comentario comentario = this.service.crear(dto);
        return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);
    }

    @GetMapping()
    public List<Comentario> listarComentario(){
        return  this.service.listar();
    }
}
