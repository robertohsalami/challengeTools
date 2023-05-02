package com.roberto.api.pagamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Descricao {
    private String valor;
    private String dataHora;
    private String estabelecimento;
}
