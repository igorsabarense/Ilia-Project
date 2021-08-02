package br.com.ilia.Ilia.Project.service;

import br.com.ilia.Ilia.Project.dto.LancamentoDTO;
import br.com.ilia.Ilia.Project.entity.Lancamento;
import br.com.ilia.Ilia.Project.exception.IliaException;

public interface LancamentoService {
    Lancamento save(LancamentoDTO lancamentoDTO) throws IliaException;
    Lancamento update(LancamentoDTO lancamentoDTO);
    void delete(Long id);
}
