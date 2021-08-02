package br.com.ilia.Ilia.Project.service.mapper.impl;
import br.com.ilia.Ilia.Project.dto.LancamentoDTO;
import br.com.ilia.Ilia.Project.entity.Lancamento;
import br.com.ilia.Ilia.Project.service.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface LancamentoMapper extends EntityMapper<LancamentoDTO, Lancamento> {

    @Override
    @Mapping(source = "funcionario.id", target = "funcionarioId")
    @Mapping(source = "creationDate", target = "dataHora")
    LancamentoDTO toDto(Lancamento entity);

    @Override
    @Mapping(source = "funcionarioId" , target = "funcionario.id")
    Lancamento toEntity(LancamentoDTO dto);

    default Lancamento fromId(Long id){
        if(id == null){
            return null;
        }
        Lancamento lancamento = new Lancamento();
        lancamento.setId(id);
        return lancamento;
    }
}
