package com.roberto.api.pagamento.service.impl;

import com.roberto.api.pagamento.model.Pagamento;
import com.roberto.api.pagamento.model.StatusTransacao;
import com.roberto.api.pagamento.repository.PagamentoRepository;
import com.roberto.api.pagamento.service.IPagamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PagamentoServiceImpl implements IPagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public Pagamento save(Pagamento pagamento) {
        log.info("Persistindo o pagamento no B.D: {}. ", pagamento);
        pagamento.setNsu("1234567890");
        pagamento.setCodigoAutorizacao("147258369");
        pagamento.setStatus(StatusTransacao.AUTORIZADO);
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public List<Pagamento> consultarTodos() {
        log.info("Buscando todos os pagamentos");
        return pagamentoRepository.findAll();
    }

    @Override
    public Optional<Pagamento> consultaPorId(Integer id) {
        log.info("Buscando o pagamento id: {}", id);
        return pagamentoRepository.findById(id);
    }

    @Override
    public Pagamento estornarPagamento(Pagamento pagamento) {
        log.info("Estornando o pagamento id: {}", pagamento);
        pagamento.setStatus(StatusTransacao.CANCELADO);
        return pagamentoRepository.save(pagamento);
    }
}
