package br.com.ilia.Ilia.Project.service.facade;

import br.com.ilia.Ilia.Project.service.mapper.impl.LancamentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapperStruct {

    @Autowired
    public LancamentoMapper lancamento;
}
