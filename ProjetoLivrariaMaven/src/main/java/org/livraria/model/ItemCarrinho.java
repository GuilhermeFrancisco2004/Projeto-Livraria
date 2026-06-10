package org.livraria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "itens_carrinho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = false)
    private Carrinho carrinho;
    
    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;
    
    @Column(nullable = false)
    private Integer quantidade;
    
    @Column(nullable = false)
    private Double preco;
    
    public Double getSubtotal() {
        return preco * quantidade;
    }
}
