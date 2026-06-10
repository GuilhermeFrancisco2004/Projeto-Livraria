package org.livraria.controller;

import org.livraria.dto.CriarPedidoRequest;
import org.livraria.model.Pedido;
import org.livraria.model.Usuario;
import org.livraria.service.PedidoService;
import org.livraria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:5173")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/{usuarioId}")
    public ResponseEntity<Pedido> criarPedido(
            @PathVariable Long usuarioId,
            @RequestBody CriarPedidoRequest request) {
        Usuario usuario = usuarioService.obterPorId(usuarioId);
        Pedido pedido = pedidoService.criarPedido(usuario, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
    
    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Pedido>> obterPedidosDoUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioService.obterPorId(usuarioId);
        return ResponseEntity.ok(pedidoService.obterPedidosDoUsuario(usuario));
    }
    
    @GetMapping("/detalhe/{pedidoId}")
    public ResponseEntity<Pedido> obterPorId(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(pedidoService.obterPorId(pedidoId));
    }
    
    @PutMapping("/{pedidoId}/status")
    public ResponseEntity<Pedido> atualizarStatus(
            @PathVariable Long pedidoId,
            @RequestParam Pedido.StatusPedido status) {
        return ResponseEntity.ok(pedidoService.atualizarStatus(pedidoId, status));
    }
}
