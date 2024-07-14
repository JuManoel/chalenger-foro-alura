package edu.alura.chalenger_foro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.alura.chalenger_foro.DTO.DatosDTORespuesta;
import edu.alura.chalenger_foro.infra.mis_execpciones.NoExiste;
import edu.alura.chalenger_foro.models.respuesta.DatosActualizarRespuesta;
import edu.alura.chalenger_foro.models.respuesta.DatosRespuesta;
import edu.alura.chalenger_foro.models.respuesta.Respuesta;
import edu.alura.chalenger_foro.repository.RespuestaRepository;
import jakarta.validation.Valid;

@Service
public class ServiceRespuesta {
    @Autowired
    private RespuestaRepository repository;

    public Page<DatosDTORespuesta> getAllRespuestas(Pageable page) {
        var respuesta = repository.findByActivoTrue(page);
        return respuesta.map(r -> new DatosDTORespuesta(r));
    }

    public Respuesta registrarRespuesta(@Valid DatosRespuesta datoRespuesta) {
        var resp = new Respuesta(datoRespuesta);
        repository.save(resp);
        return resp;
    }

    public DatosDTORespuesta getRespuestaById(Long id) throws NoExiste {
        var resp = existe(id);
        return new DatosDTORespuesta(resp);
    }

    public DatosDTORespuesta updateRespuesta(Long id, DatosActualizarRespuesta datosRespuesta) throws NoExiste {
        var resp = existe(id);
        resp.actualizarRespuesta(datosRespuesta);
        return new DatosDTORespuesta(resp);
    }

    public void deletarRespuesta(Long id) throws NoExiste {
        var resp = existe(id);
        resp.desativar();
    }

    private Respuesta existe(Long id) throws NoExiste{
        var resp = repository.findByIdAndActivoTrue(id);
        if(!resp.isPresent()){
            throw new NoExiste("No existe esa respuesta");
        }
        return resp.get();
    }

    
}
