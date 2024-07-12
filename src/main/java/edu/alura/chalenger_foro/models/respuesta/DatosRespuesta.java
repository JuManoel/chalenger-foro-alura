package edu.alura.chalenger_foro.models.respuesta;

import java.time.LocalDateTime;

import edu.alura.chalenger_foro.models.topico.DatosTopico;
import edu.alura.chalenger_foro.models.usuario.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuesta(
        @NotNull @NotBlank String mensaje,
        @NotNull @Valid DatosTopico topico,
        @NotNull @FutureOrPresent LocalDateTime fecha,
        @NotNull @Valid DatosUsuario autor,
        @NotBlank @NotNull String solucion) {

}
