package org.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCarrinhoRequest {
    private Long livroId;
    private Integer quantidade;
}
