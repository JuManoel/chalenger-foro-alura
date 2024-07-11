package edu.alura.chalenger_foro.models.respuesta;

import java.time.LocalDateTime;

import edu.alura.chalenger_foro.models.topico.DatosTopico;
import edu.alura.chalenger_foro.models.usuario.DatosUsuario;

public record DatosRespuesta(String mensaje,
        DatosTopico topico,
        LocalDateTime fecha,
        DatosUsuario autor,
        String solucion) {

}
