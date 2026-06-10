package org.livraria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 255)
    private String titulo;
    
    @Column(nullable = false, length = 255)
    private String autor;
    
    @Column(nullable = false)
    private Double preco;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @Column(nullable = false)
    private Integer estoque;
    @Column(length = 100)
    private String categoria;
    
    @Column(length = 500)
    private String imagemUrl;
    
    @Column
    private Integer anoPublicacao;
    
    @Column(length = 50)
    private String isbn;
}
