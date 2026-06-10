package org.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinhoDTO {
    private Long id;
    private Long livroId;
    private String titulos;
    private Double preco;
    private Integer quantidade;
    private Double subtotal;
}
