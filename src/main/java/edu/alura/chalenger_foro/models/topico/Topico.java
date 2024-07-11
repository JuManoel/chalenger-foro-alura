package edu.alura.chalenger_foro.models.topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.alura.chalenger_foro.models.curso.Curso;
import edu.alura.chalenger_foro.models.respuesta.Respuesta;
import edu.alura.chalenger_foro.models.usuario.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean status; // Activo o Inactivo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;

    public Topico(DatosTopico topico){
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
        this.fecha = topico.fecha();
        this.autor = new Usuario(topico.autor());
        this.curso = new Curso(topico.curso());
        if(topico.respuestas() == null)
            this.respuestas = new ArrayList<>();//considero caso de no tener ningua respuesta
        else
            this.respuestas = topico.respuestas().stream().map(r -> new Respuesta(r)).toList();
        this.status = true;
    }

    public void desativar(){
        this.status = false;
    }

}
