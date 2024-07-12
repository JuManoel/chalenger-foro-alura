package edu.alura.chalenger_foro.DTO;

import edu.alura.chalenger_foro.models.perfil.Perfil;

public record DatosDTOPerfil(String nombre,
        DatosDTOUsuario usuario) {
            public DatosDTOPerfil(Perfil p){
                this(p.getNombre(),new DatosDTOUsuario(p.getUsuario()));
            }
}
