package edu.alura.chalenger_foro.models.perfil;

import edu.alura.chalenger_foro.models.usuario.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosPerfil(
        @NotBlank @NotNull String nombre,
        @NotNull  @Valid DatosUsuario usuario) {

}
