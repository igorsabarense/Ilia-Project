package br.com.ilia.Ilia.Project.service.facade;

import br.com.ilia.Ilia.Project.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryFacade {
    @Autowired
    public LancamentoRepository lancamento;
}
