package org.livraria.service;

import org.livraria.dto.LivroDTO;
import org.livraria.model.Livro;
import org.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;
    
    public List<LivroDTO> listarTodos() {
        return livroRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public LivroDTO obterPorId(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return convertToDTO(livro);
    }
    
    public List<LivroDTO> buscarPorCategoria(String categoria) {
        return livroRepository.findByCategoria(categoria).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<LivroDTO> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<LivroDTO> buscarPorAutor(String autor) {
        return livroRepository.findByAutorContainingIgnoreCase(autor).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public LivroDTO criarLivro(LivroDTO livroDTO) {
        Livro livro = convertToEntity(livroDTO);
        Livro salvo = livroRepository.save(livro);
        return convertToDTO(salvo);
    }
    
    public LivroDTO atualizarLivro(Long id, LivroDTO livroDTO) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setPreco(livroDTO.getPreco());
        livro.setDescricao(livroDTO.getDescricao());
        livro.setCategoria(livroDTO.getCategoria());
        livro.setImagemUrl(livroDTO.getImagemUrl());
        livro.setAnoPublicacao(livroDTO.getAnoPublicacao());
        livro.setIsbn(livroDTO.getIsbn());
        
        Livro atualizado = livroRepository.save(livro);
        return convertToDTO(atualizado);
    }
    
    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
    
    private LivroDTO convertToDTO(Livro livro) {
        return new LivroDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getPreco(),
                livro.getDescricao(),
                livro.getCategoria(),
                livro.getImagemUrl(),
                livro.getAnoPublicacao(),
                livro.getIsbn()
        );
    }
    
    private Livro convertToEntity(LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setPreco(livroDTO.getPreco());
        livro.setDescricao(livroDTO.getDescricao());
        // Default estoque to 1 since stock tracking is not used in the frontend
        livro.setEstoque(1);
        livro.setCategoria(livroDTO.getCategoria());
        livro.setImagemUrl(livroDTO.getImagemUrl());
        livro.setAnoPublicacao(livroDTO.getAnoPublicacao());
        livro.setIsbn(livroDTO.getIsbn());
        return livro;
    }
}
