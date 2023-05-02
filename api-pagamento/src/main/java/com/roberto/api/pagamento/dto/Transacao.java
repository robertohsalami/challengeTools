package com.roberto.api.pagamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Transacao {
    private String cartao;
    private String id;
    private Descricao descricao;
    private FormaPagamento formaPagamento;
}
