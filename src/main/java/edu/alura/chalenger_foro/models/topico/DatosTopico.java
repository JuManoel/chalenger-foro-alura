package edu.alura.chalenger_foro.models.topico;

import java.time.LocalDateTime;
import java.util.List;

import edu.alura.chalenger_foro.models.curso.DatosCurso;
import edu.alura.chalenger_foro.models.respuesta.DatosRespuesta;
import edu.alura.chalenger_foro.models.usuario.Usuario;

public record DatosTopico(
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Usuario autor,
        DatosCurso curso,
        List<DatosRespuesta> respuestas) {

}
