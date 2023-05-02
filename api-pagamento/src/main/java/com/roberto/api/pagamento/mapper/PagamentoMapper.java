package com.roberto.api.pagamento.mapper;

import com.roberto.api.pagamento.dto.*;
import com.roberto.api.pagamento.model.Pagamento;
import com.roberto.api.pagamento.model.TipoPagamento;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PagamentoMapper {

    public Pagamento pagamentoRequestToPagamento(PagamentoRequest pagamentoRequest){
        return Pagamento.builder()
                .id(Integer.parseInt(pagamentoRequest.getTransacao().getId()))
                .cartao(pagamentoRequest.getTransacao().getCartao())
                .valor(Double.parseDouble(pagamentoRequest.getTransacao().getDescricao().getValor()))
                .dataHora(pagamentoRequest.getTransacao().getDescricao().getDataHora())
                .estabelecimento(pagamentoRequest.getTransacao().getDescricao().getEstabelecimento())
                .tipoPagamento(TipoPagamento.valueOf(pagamentoRequest.getTransacao().getFormaPagamento().getTipo()))
                .parcelas(Integer.parseInt(pagamentoRequest.getTransacao().getFormaPagamento().getParcelas()))
                .build();
    }

    public PagamentoResponse pagamentoToPagamentoResponse(Pagamento pagamento){
        return preenchePagamentoResponse(pagamento);
    }

    public List<PagamentoResponse> pagamentoListToPagamentoResponseList(List<Pagamento> pagamentos){
        List<PagamentoResponse> pagamentoResponse = new ArrayList<>();
        for (Pagamento pagamento : pagamentos) {
            pagamentoResponse.add(preenchePagamentoResponse(pagamento));
        }
        return pagamentoResponse;
    }

    private PagamentoResponse preenchePagamentoResponse(Pagamento pagamento) {
        return PagamentoResponse.builder()
                .transacao(TransacaoResponse.builder()
                        .cartao(pagamento.getCartao())
                        .id(pagamento.getId().toString())
                        .descricao(DescricaoResponse.builder()
                                .valor(String.valueOf(pagamento.getValor()))
                                .dataHora(pagamento.getDataHora())
                                .estabelecimento(pagamento.getEstabelecimento())
                                .nsu(pagamento.getNsu())
                                .codigoAutorizacao(pagamento.getCodigoAutorizacao())
                                .status(pagamento.getStatus())
                                .build())
                        .formaPagamento(FormaPagamento.builder()
                                .tipo(pagamento.getTipoPagamento().toString())
                                .parcelas(String.valueOf(pagamento.getParcelas()))
                                .build())
                        .build())
                .build();
    }

}
