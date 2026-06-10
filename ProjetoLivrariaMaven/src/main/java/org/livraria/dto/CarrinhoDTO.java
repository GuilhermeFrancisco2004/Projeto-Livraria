package org.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDTO {
    private Long id;
    private Long usuarioId;
    private List<ItemCarrinhoDTO> itens;
    private Double total;
}
