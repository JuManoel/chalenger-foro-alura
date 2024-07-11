package edu.alura.chalenger_foro.models.perfil;

import edu.alura.chalenger_foro.models.usuario.Usuario;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private boolean activo;

    public Perfil(DatosPerfil perfil){
        this.nombre = perfil.nombre();
        this.usuario = new Usuario(perfil.usuario());
        this.activo = true;
    }

    public void desativar(){
        this.activo = false;
    }

}
