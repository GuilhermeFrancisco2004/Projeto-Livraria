package org.livraria.controller;

import org.livraria.dto.LivroDTO;
import org.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174", "http://localhost:5175"})
public class LivroController {
    
    @Autowired
    private LivroService livroService;
    
    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.obterPorId(id));
    }
    
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<LivroDTO>> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(livroService.buscarPorCategoria(categoria));
    }
    
    @GetMapping("/buscar/titulo")
    public ResponseEntity<List<LivroDTO>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(livroService.buscarPorTitulo(titulo));
    }
    
    @GetMapping("/buscar/autor")
    public ResponseEntity<List<LivroDTO>> buscarPorAutor(@RequestParam String autor) {
        return ResponseEntity.ok(livroService.buscarPorAutor(autor));
    }
    
    @PostMapping
    public ResponseEntity<LivroDTO> criarLivro(@RequestBody LivroDTO livroDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.criarLivro(livroDTO));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> atualizarLivro(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        return ResponseEntity.ok(livroService.atualizarLivro(id, livroDTO));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}
