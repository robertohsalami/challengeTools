package com.roberto.api.pagamento.service;

import com.roberto.api.pagamento.model.Pagamento;

import java.util.List;
import java.util.Optional;

public interface IPagamentoService {
    Pagamento save(Pagamento pagamento);
    List<Pagamento> consultarTodos();
    Optional<Pagamento> consultaPorId(Integer id);
    Pagamento estornarPagamento(Pagamento pagamento);
}
