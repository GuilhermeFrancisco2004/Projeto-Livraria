package org.livraria.service;

import org.livraria.model.Usuario;
import org.livraria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario obterOuCriarUsuario(String email, String nome) {
        return usuarioRepository.findByEmail(email)
                .orElseGet(() -> {
                    Usuario novoUsuario = new Usuario();
                    novoUsuario.setEmail(email);
                    novoUsuario.setNome(nome);
                    novoUsuario.setSenha("123456"); // Padrão para novo usuário
                    return usuarioRepository.save(novoUsuario);
                });
    }
    
    public Usuario obterPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
