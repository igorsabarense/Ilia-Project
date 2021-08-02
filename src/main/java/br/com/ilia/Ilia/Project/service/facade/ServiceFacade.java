package br.com.ilia.Ilia.Project.service.facade;

import br.com.ilia.Ilia.Project.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacade {
    @Autowired
    public LancamentoService lancamento;
}
