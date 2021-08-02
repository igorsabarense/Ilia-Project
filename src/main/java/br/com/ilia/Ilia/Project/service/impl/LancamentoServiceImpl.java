package br.com.ilia.Ilia.Project.service.impl;

import br.com.ilia.Ilia.Project.dto.LancamentoDTO;
import br.com.ilia.Ilia.Project.entity.Funcionario;
import br.com.ilia.Ilia.Project.entity.Lancamento;
import br.com.ilia.Ilia.Project.exception.IliaException;
import br.com.ilia.Ilia.Project.service.LancamentoService;
import br.com.ilia.Ilia.Project.service.facade.Facade;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.List;
import java.util.Set;

@Service
public class LancamentoServiceImpl implements LancamentoService {
    @Autowired
    private Facade facade;

    private final int MAX_LANCAMENTOS_DIA = 4;


    @Override
    public Lancamento save(LancamentoDTO lancamentoDTO) throws IliaException {
        Lancamento lancamento = facade.mapperStruct.lancamento.toEntity(lancamentoDTO);
        lancamento.setFuncionario(new Funcionario(1L)); // id funcionario mockado.

        if(validarLancamento(lancamento, lancamentoDTO)){
            lancamento = facade.repository.lancamento.save(lancamento);
        }

        return lancamento;
    }

    private Boolean validarLancamento(Lancamento lancamento,  LancamentoDTO lancamentoDTO) throws IliaException {
        throwError400(lancamento, lancamentoDTO);
        List<Lancamento> lancamentosAnteriores = facade.repository.lancamento.findByFuncionarioIdAndCreationDate(1L, LocalDateTime.parse(lancamentoDTO.getDataHora()).toLocalDate());
        throwError403(lancamento, lancamentosAnteriores);
        throwError409(lancamento, lancamentosAnteriores);
        return true;
    }

    private void throwError400(Lancamento lancamento, LancamentoDTO lancamentoDTO) {

        try{
            if(lancamentoDTO.getDataHora() == null){
                throw new IliaException("Campo obrigatório não informado", HttpStatus.BAD_REQUEST);
            }else{
                LocalDateTime dateTime = LocalDateTime.parse(lancamentoDTO.getDataHora());
                lancamento.setCreationDate(dateTime);
            }
        }catch (Exception ex){
            throw new IliaException("Data e hora em formato inválido", HttpStatus.BAD_REQUEST);
        }

    }

    private void throwError409(Lancamento lancamento, List<Lancamento> lancamentosAnteriores) {
        if(lancamentosAnteriores.stream().anyMatch(l -> l.getCreationDate().equals(lancamento.getCreationDate()))){
            throw new IliaException("Horários já registrado", HttpStatus.CONFLICT);
        }
    }

    private void throwError403(Lancamento lancamento, List<Lancamento> lancamentosAnteriores) {
        if(lancamentosAnteriores.size() >= MAX_LANCAMENTOS_DIA){
           throw new IliaException("Apenas 4 horários podem ser registrados por dia", HttpStatus.FORBIDDEN);
        }else if(lancamento.getCreationDate().getDayOfWeek().equals(DayOfWeek.SUNDAY) || lancamento.getCreationDate().getDayOfWeek().equals(DayOfWeek.SATURDAY)){
           throw new IliaException("Sábado e domingo não são permitidos como dia de trabalho", HttpStatus.FORBIDDEN);
        }else if(lancamentosAnteriores.size() == 2 && lancamento.getCreationDate().minusHours(1).isBefore(lancamentosAnteriores.get(1).getCreationDate())){
           throw new IliaException("Deve haver no mínimo 1 hora de almoço", HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public Lancamento update(LancamentoDTO lancamentoDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        facade.repository.lancamento.deleteById(id);
    }
}
