package edu.alura.chalenger_foro.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import edu.alura.chalenger_foro.DTO.DatosDTOTopico;
import edu.alura.chalenger_foro.models.topico.DatosActualizarTopico;
import edu.alura.chalenger_foro.models.topico.DatosTopico;
import edu.alura.chalenger_foro.service.ServiceTopico;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/topico")
public class ControllerTopico {
    @Autowired
    private ServiceTopico service;

    @GetMapping()
    public ResponseEntity<Page<DatosDTOTopico>> showAllTopicos(
            @PageableDefault(size = 3, sort = "titulo") Pageable page) {
        var topicos = service.getAllTopicos(page);
        return ResponseEntity.ok(topicos);
    }

    @PostMapping()
    public ResponseEntity<DatosDTOTopico> registrarTopico(@RequestBody @Valid DatosTopico datoTopico,
            UriComponentsBuilder uriComponentsBuilder) {
        var topico = service.registrarTopico(datoTopico);
        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.id()).toUri();
        return ResponseEntity.created(url).body(topico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDTOTopico> showTopico(@PathVariable Long id) {
        var topico = service.getTopicoById(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping()
    public ResponseEntity<DatosDTOTopico> updateTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datosTopico){
        var topico = service.updateTopico(id,datosTopico);
        return null;
    }

}
