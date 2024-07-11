package edu.alura.chalenger_foro.models.respuesta;

import java.time.LocalDateTime;

import edu.alura.chalenger_foro.models.topico.Topico;
import edu.alura.chalenger_foro.models.usuario.DatosUsuario;

public record DatosRespuesta(String mensaje,
        Topico topico,
        LocalDateTime fecha,
        DatosUsuario autor,
        String solucion) {

}
