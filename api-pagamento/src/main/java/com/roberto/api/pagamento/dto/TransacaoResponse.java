package com.roberto.api.pagamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TransacaoResponse {
    private String cartao;
    private String id;
    private DescricaoResponse descricao;
    private FormaPagamento formaPagamento;
}
