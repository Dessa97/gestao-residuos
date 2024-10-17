package br.com.fiap.gestaoDeResiduos.service;

import br.com.fiap.gestaoDeResiduos.model.Usuario;
import br.com.fiap.gestaoDeResiduos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public Usuario salvar(Usuario usuario) {
        String senhaCripto = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setSenha(senhaCripto);
        return usuarioRepository.save(usuario);
    }
}
