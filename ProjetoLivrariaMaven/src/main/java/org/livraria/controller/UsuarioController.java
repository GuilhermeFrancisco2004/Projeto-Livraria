package org.livraria.controller;

import org.livraria.model.Usuario;
import org.livraria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/obter-ou-criar")
    public ResponseEntity<Usuario> obterOuCriarUsuario(
            @RequestParam String email,
            @RequestParam String nome) {
        Usuario usuario = usuarioService.obterOuCriarUsuario(email, nome);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obterPorId(id));
    }
}
