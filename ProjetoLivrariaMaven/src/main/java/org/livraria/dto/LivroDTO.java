package org.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private Double preco;
    private String descricao;
    private String categoria;
    private String imagemUrl;
    private Integer anoPublicacao;
    private String isbn;
}
