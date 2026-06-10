package org.livraria.service;

import org.livraria.dto.AddCarrinhoRequest;
import org.livraria.dto.CarrinhoDTO;
import org.livraria.dto.ItemCarrinhoDTO;
import org.livraria.model.*;
import org.livraria.repository.CarrinhoRepository;
import org.livraria.repository.ItemCarrinhoRepository;
import org.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CarrinhoService {
    
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    
    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;
    
    @Autowired
    private LivroRepository livroRepository;
    
    public CarrinhoDTO obterCarrinhoPorUsuario(Usuario usuario) {
        Carrinho carrinho = carrinhoRepository.findByUsuario(usuario)
                .orElseGet(() -> {
                    Carrinho novoCarrinho = new Carrinho();
                    novoCarrinho.setUsuario(usuario);
                    return carrinhoRepository.save(novoCarrinho);
                });
        
        return convertToDTO(carrinho);
    }
    
    public CarrinhoDTO adicionarAoCarrinho(Usuario usuario, AddCarrinhoRequest request) {
        Carrinho carrinho = carrinhoRepository.findByUsuario(usuario)
                .orElseGet(() -> {
                    Carrinho novoCarrinho = new Carrinho();
                    novoCarrinho.setUsuario(usuario);
                    return carrinhoRepository.save(novoCarrinho);
                });
        
        Livro livro = livroRepository.findById(request.getLivroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        
        // Verificar se o livro já está no carrinho
        ItemCarrinho itemExistente = carrinho.getItens().stream()
                .filter(item -> item.getLivro().getId().equals(livro.getId()))
                .findFirst()
                .orElse(null);
        
        if (itemExistente != null) {
            itemExistente.setQuantidade(itemExistente.getQuantidade() + request.getQuantidade());
            itemCarrinhoRepository.save(itemExistente);
        } else {
            ItemCarrinho novoItem = new ItemCarrinho();
            novoItem.setCarrinho(carrinho);
            novoItem.setLivro(livro);
            novoItem.setQuantidade(request.getQuantidade());
            novoItem.setPreco(livro.getPreco());
            itemCarrinhoRepository.save(novoItem);
            carrinho.getItens().add(novoItem);
        }
        
        carrinhoRepository.save(carrinho);
        return convertToDTO(carrinho);
    }
    
    public CarrinhoDTO atualizarQuantidade(Usuario usuario, Long itemId, Integer quantidade) {
        Carrinho carrinho = carrinhoRepository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        
        ItemCarrinho item = itemCarrinhoRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        
        if (quantidade <= 0) {
            removerDoCarrinho(usuario, itemId);
        } else {
            item.setQuantidade(quantidade);
            itemCarrinhoRepository.save(item);
        }
        
        carrinho = carrinhoRepository.findByUsuario(usuario).get();
        return convertToDTO(carrinho);
    }
    
    public CarrinhoDTO removerDoCarrinho(Usuario usuario, Long itemId) {
        Carrinho carrinho = carrinhoRepository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        
        ItemCarrinho item = itemCarrinhoRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        
        carrinho.getItens().remove(item);
        itemCarrinhoRepository.deleteById(itemId);
        carrinhoRepository.save(carrinho);
        
        return convertToDTO(carrinho);
    }
    
    public void limparCarrinho(Usuario usuario) {
        Carrinho carrinho = carrinhoRepository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        
        itemCarrinhoRepository.deleteAll(carrinho.getItens());
        carrinho.getItens().clear();
        carrinhoRepository.save(carrinho);
    }
    
    private CarrinhoDTO convertToDTO(Carrinho carrinho) {
        CarrinhoDTO dto = new CarrinhoDTO();
        dto.setId(carrinho.getId());
        dto.setUsuarioId(carrinho.getUsuario().getId());
        dto.setItens(carrinho.getItens().stream()
                .map(item -> new ItemCarrinhoDTO(
                        item.getId(),
                        item.getLivro().getId(),
                        item.getLivro().getTitulo(),
                        item.getPreco(),
                        item.getQuantidade(),
                        item.getSubtotal()
                ))
                .collect(Collectors.toList())
        );
        dto.setTotal(carrinho.getTotal());
        return dto;
    }
}
