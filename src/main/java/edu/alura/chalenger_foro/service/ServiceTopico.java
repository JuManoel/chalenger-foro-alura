package edu.alura.chalenger_foro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.alura.chalenger_foro.DTO.DatosDTOTopico;
import edu.alura.chalenger_foro.models.topico.DatosActualizarTopico;
import edu.alura.chalenger_foro.models.topico.DatosTopico;
import edu.alura.chalenger_foro.models.topico.Topico;
import edu.alura.chalenger_foro.repository.TopicoRepository;
import jakarta.validation.Valid;

@Service
public class ServiceTopico {
    @Autowired
    private TopicoRepository repository;

    public Page<DatosDTOTopico> getAllTopicos(Pageable page) {
        var datos = repository.findByStatusTrue(page);
        return datos.map(d -> new DatosDTOTopico(d));
    }

    public Topico registrarTopico(@Valid DatosTopico datoTopico) {
        var topico = new Topico(datoTopico);
        repository.save(topico);
        return topico;
    }

    public DatosDTOTopico getTopicoById(Long id) {
        var topico = existe(id);
        return new DatosDTOTopico(topico);
    }

    public DatosDTOTopico updateTopico(Long id, DatosActualizarTopico datosTopico) {
        var topico = existe(id);
        topico.actualizarTopico(datosTopico);
        return new DatosDTOTopico(topico);
    }

    public void deletarTopico(Long id) {
       var topico = existe(id);
       topico.desativar();
    }

    private Topico existe(Long id){
        var topico = repository.findByIdAndStatusTrue(id);
        if(!topico.isPresent())
            throw new IllegalStateException("No existe esse topico");
        return topico.get();
    }
}
