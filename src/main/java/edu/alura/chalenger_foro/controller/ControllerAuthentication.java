package edu.alura.chalenger_foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.alura.chalenger_foro.models.DatosToken;
import edu.alura.chalenger_foro.models.usuario.DatosUsuario;
import edu.alura.chalenger_foro.models.usuario.Usuario;
import edu.alura.chalenger_foro.service.ServiceToken;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/login")
public class ControllerAuthentication {
    @Autowired
    private ServiceToken service;
    @Autowired
    private AuthenticationManager manager;


    @PostMapping
    public ResponseEntity<DatosToken> autenticarUsuario(@RequestBody @Valid DatosUsuario usuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuario.nombre(),
        usuario.contrasena());
        var usuarioAutenticado = manager.authenticate(authToken);
        var JWTtoken = service.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosToken(JWTtoken));
    }
}
