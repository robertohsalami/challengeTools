package com.roberto.api.pagamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FormaPagamento {
    private String tipo;
    private String parcelas;
}
