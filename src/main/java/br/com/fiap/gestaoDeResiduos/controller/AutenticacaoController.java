package br.com.fiap.gestaoDeResiduos.controller;

import br.com.fiap.gestaoDeResiduos.dto.TokenDto;
import br.com.fiap.gestaoDeResiduos.model.Usuario;
import br.com.fiap.gestaoDeResiduos.service.TokenService;
import br.com.fiap.gestaoDeResiduos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;


    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity logar(@RequestBody Usuario usuario) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword());

        Authentication autentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = tokenService.gerarToken((Usuario) autentication.getPrincipal());
        return ResponseEntity.ok(new TokenDto(token))
                ;
    }

    @PostMapping("/users")
    public ResponseEntity cadastrar(@RequestBody Usuario usuario) {
        Usuario usuario1 = usuarioService.salvar(usuario);
        return ResponseEntity.ok(usuario1);
    }
}
