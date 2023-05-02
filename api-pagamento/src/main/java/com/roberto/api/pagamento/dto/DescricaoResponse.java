package com.roberto.api.pagamento.dto;

import com.roberto.api.pagamento.model.StatusTransacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class DescricaoResponse {
    private String valor;
    private String dataHora;
    private String estabelecimento;
    private String nsu;
    private String codigoAutorizacao;
    private StatusTransacao status;

}
