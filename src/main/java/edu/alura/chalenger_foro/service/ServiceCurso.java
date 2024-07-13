package edu.alura.chalenger_foro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.alura.chalenger_foro.DTO.DatosDTOCurso;
import edu.alura.chalenger_foro.models.curso.Curso;
import edu.alura.chalenger_foro.models.curso.DatosActualizarCurso;
import edu.alura.chalenger_foro.models.curso.DatosCurso;
import edu.alura.chalenger_foro.repository.CursoRepository;
import jakarta.validation.Valid;

@Service
public class ServiceCurso {
    @Autowired
    private CursoRepository repository;

    public Page<DatosDTOCurso> getAllCursos(Pageable page) {
        var respuesta = repository.findByActivoTrue(page);
        return respuesta.map(c -> new DatosDTOCurso(c));
    }

    public Curso registrarCurso(@Valid DatosCurso datoCurso) {
        var curso = new Curso(datoCurso);
        repository.save(curso);
        return curso;
    }

    public DatosDTOCurso getCursoById(Long id) {
        var curso = existe(id);
        return new DatosDTOCurso(curso);
    }

    public DatosDTOCurso updateCurso(Long id, DatosActualizarCurso datosCurso) {
        var curso = existe(id);
        curso.ActualizarCurso(datosCurso);
        return new DatosDTOCurso(curso);
    }

    public void deletarCurso(Long id) {
        var curso = existe(id);
        curso.desativar();
    }

    private Curso existe(Long id){
        var curso = repository.findByActivoTrue(id);
        if(!curso.isPresent()){
            throw new IllegalStateException("No existe el curso con id: "+id);
        }
        return curso.get();
    }

    

    

    


    
}
