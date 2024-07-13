package edu.alura.chalenger_foro.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import edu.alura.chalenger_foro.infra.mis_execpciones.NoExiste;
import edu.alura.chalenger_foro.infra.mis_execpciones.ProblemasGenerarToken;
import edu.alura.chalenger_foro.infra.mis_execpciones.TokenInvalido;
import edu.alura.chalenger_foro.models.usuario.Usuario;

@Service
public class ServiceToken {
    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario) throws NoExiste, ProblemasGenerarToken {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("challenger-foro")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new ProblemasGenerarToken("Usuario no existe");
        }
    }

    public String getSubject(String token) throws TokenInvalido {
        if (token == null) {
            throw new TokenInvalido("Es nulo");
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando firma
            verifier = JWT.require(algorithm)
                    .withIssuer("challenger-foro")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        if (verifier.getSubject() == null) {
            throw new TokenInvalido("Verifier invalido");
        }
        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
