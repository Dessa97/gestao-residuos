package br.com.fiap.gestaoDeResiduos.service;

import br.com.fiap.gestaoDeResiduos.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    Algorithm algorithm = Algorithm.HMAC256("fiap_secreto");

    public String gerarToken(Usuario usuario) {
        //Algorithm algorithm = Algorithm.HMAC256("fiap_secreto");

        String token = JWT
                .create()
                .withIssuer("fiap")
                .withSubject(usuario.getUsername())
                .withExpiresAt(gerarDataExpiracaoToken())
                .sign(algorithm);

        return token;
    }

    public String validarToken(String token) {
        try {
            return JWT.require(algorithm)
                    .withIssuer("fiap")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant gerarDataExpiracaoToken() {
        return LocalDateTime
                .now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
