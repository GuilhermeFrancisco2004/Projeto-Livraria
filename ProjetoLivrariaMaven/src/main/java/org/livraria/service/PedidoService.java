package org.livraria.service;

import org.livraria.dto.CriarPedidoRequest;
import org.livraria.model.*;
import org.livraria.repository.CarrinhoRepository;
import org.livraria.repository.ItemCarrinhoRepository;
import org.livraria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    
    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;
    
    @Autowired
    private CarrinhoService carrinhoService;
    
    public Pedido criarPedido(Usuario usuario, CriarPedidoRequest request) {
        Carrinho carrinho = carrinhoRepository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        
        if (carrinho.getItens().isEmpty()) {
            throw new RuntimeException("Carrinho está vazio");
        }
        
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setEndereco(request.getEndereco());
        pedido.setTotal(carrinho.getTotal());
        pedido.setStatus(Pedido.StatusPedido.PENDENTE);
        
        // Copiar itens do carrinho para o pedido
        List<ItemPedido> itensPedido = new ArrayList<>();
        for (ItemCarrinho itemCarrinho : carrinho.getItens()) {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            itemPedido.setLivro(itemCarrinho.getLivro());
            itemPedido.setQuantidade(itemCarrinho.getQuantidade());
            itemPedido.setPreco(itemCarrinho.getPreco());
            itensPedido.add(itemPedido);
        }
        
        pedido.setItens(itensPedido);
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        
        // Limpar carrinho após criar pedido
        carrinhoService.limparCarrinho(usuario);
        
        return pedidoSalvo;
    }
    
    public List<Pedido> obterPedidosDoUsuario(Usuario usuario) {
        return pedidoRepository.findByUsuario(usuario);
    }
    
    public Pedido obterPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
    
    public Pedido atualizarStatus(Long id, Pedido.StatusPedido novoStatus) {
        Pedido pedido = obterPorId(id);
        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);
    }
}
