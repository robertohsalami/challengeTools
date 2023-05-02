package com.roberto.api.pagamento.controller;

import com.roberto.api.pagamento.dto.PagamentoRequest;
import com.roberto.api.pagamento.dto.PagamentoResponse;
import com.roberto.api.pagamento.mapper.PagamentoMapper;
import com.roberto.api.pagamento.model.Pagamento;
import com.roberto.api.pagamento.service.IPagamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/pagamento")
@Slf4j
public class PagamentoController {

    @Autowired
    private IPagamentoService pagamentoService;

    @Autowired
    private PagamentoMapper pagamentoMapper;

    @PostMapping
    public ResponseEntity<PagamentoResponse> criarPagamento(@RequestBody PagamentoRequest pagamentoRequest){
        Pagamento pagamento = pagamentoMapper.pagamentoRequestToPagamento(pagamentoRequest);
        Pagamento pagamentoSave = pagamentoService.save(pagamento);
        return new ResponseEntity<>(pagamentoMapper.pagamentoToPagamentoResponse(pagamentoSave), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PagamentoResponse>> consultarTodos(){
        List<Pagamento> pagamentos = pagamentoService.consultarTodos();
        if (pagamentos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<PagamentoResponse> pagamentoResponse = pagamentoMapper.pagamentoListToPagamentoResponseList(pagamentos);
        return new ResponseEntity<>(pagamentoResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponse> consultaPorId(@PathVariable("id") Integer id){
        Optional<Pagamento> pagamento = pagamentoService.consultaPorId(id);
        if (pagamento.isPresent()){
            PagamentoResponse pagamentoResponse = pagamentoMapper.pagamentoToPagamentoResponse(pagamento.get());
            return new ResponseEntity<>(pagamentoResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/estorno/{id}")
    public ResponseEntity<PagamentoResponse> estorno(@PathVariable("id") Integer id){
        Optional<Pagamento> pagamento = pagamentoService.consultaPorId(id);
        if (pagamento.isPresent()){
            Pagamento pagamentoSave = pagamentoService.estornarPagamento(pagamento.get());
            PagamentoResponse pagamentoResponse = pagamentoMapper.pagamentoToPagamentoResponse(pagamentoSave);
            return new ResponseEntity<>(pagamentoResponse, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
