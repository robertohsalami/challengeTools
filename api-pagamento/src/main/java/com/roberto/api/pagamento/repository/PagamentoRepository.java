package com.roberto.api.pagamento.repository;

import com.roberto.api.pagamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
