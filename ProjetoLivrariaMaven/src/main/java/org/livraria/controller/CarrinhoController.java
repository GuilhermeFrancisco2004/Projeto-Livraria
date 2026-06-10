package org.livraria.controller;

import org.livraria.dto.AddCarrinhoRequest;
import org.livraria.dto.CarrinhoDTO;
import org.livraria.model.Usuario;
import org.livraria.service.CarrinhoService;
import org.livraria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrinho")
@CrossOrigin(origins = "http://localhost:5173")
public class CarrinhoController {
    
    @Autowired
    private CarrinhoService carrinhoService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/{usuarioId}")
    public ResponseEntity<CarrinhoDTO> obterCarrinho(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.obterPorId(usuarioId);
        return ResponseEntity.ok(carrinhoService.obterCarrinhoPorUsuario(usuario));
    }
    
    @PostMapping("/{usuarioId}/adicionar")
    public ResponseEntity<CarrinhoDTO> adicionarAoCarrinho(
            @PathVariable Long usuarioId,
            @RequestBody AddCarrinhoRequest request) {
        Usuario usuario = usuarioService.obterPorId(usuarioId);
        return ResponseEntity.ok(carrinhoService.adicionarAoCarrinho(usuario, request));
    }
    
    @PutMapping("/{usuarioId}/item/{itemId}")
    public ResponseEntity<CarrinhoDTO> atualizarQuantidade(
            @PathVariable Long usuarioId,
            @PathVariable Long itemId,
            @RequestParam Integer quantidade) {
        Usuario usuario = usuarioService.obterPorId(usuarioId);
        return ResponseEntity.ok(carrinhoService.atualizarQuantidade(usuario, itemId, quantidade));
    }
    
    @DeleteMapping("/{usuarioId}/item/{itemId}")
    public ResponseEntity<CarrinhoDTO> removerDoCarrinho(
            @PathVariable Long usuarioId,
            @PathVariable Long itemId) {
        Usuario usuario = usuarioService.obterPorId(usuarioId);
        return ResponseEntity.ok(carrinhoService.removerDoCarrinho(usuario, itemId));
    }
    
    @DeleteMapping("/{usuarioId}/limpar")
    public ResponseEntity<Void> limparCarrinho(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.obterPorId(usuarioId);
        carrinhoService.limparCarrinho(usuario);
        return ResponseEntity.noContent().build();
    }
}
