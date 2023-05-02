package com.roberto.api.pagamento.model;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pagamento {

    @Id
    private Integer id;

    private String cartao;

    private double valor;

    private String dataHora;

    private String estabelecimento;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    private int parcelas;

    private String nsu;

    private String codigoAutorizacao;

    @Enumerated(EnumType.STRING)
    private StatusTransacao status;

}
