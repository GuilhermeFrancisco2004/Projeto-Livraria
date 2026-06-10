package org.livraria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();
    
    @Column(nullable = false)
    private Double total;
    
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataPedido;
    
    @Column
    private LocalDateTime dataEntrega;
    
    @Column(columnDefinition = "TEXT")
    private String endereco;
    
    @PrePersist
    protected void onCreate() {
        dataPedido = LocalDateTime.now();
        if (status == null) {
            status = StatusPedido.PENDENTE;
        }
    }
    
    public enum StatusPedido {
        PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE, CANCELADO
    }
}
