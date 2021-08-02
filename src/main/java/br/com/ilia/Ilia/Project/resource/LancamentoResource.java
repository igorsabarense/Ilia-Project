package br.com.ilia.Ilia.Project.resource;

import br.com.ilia.Ilia.Project.dto.LancamentoDTO;
import br.com.ilia.Ilia.Project.entity.Lancamento;
import br.com.ilia.Ilia.Project.exception.IliaException;
import br.com.ilia.Ilia.Project.service.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batidas")
public class LancamentoResource {

    @Autowired
    private Facade facade;

    @PostMapping
    public ResponseEntity<HttpStatus> lancarPonto(@RequestBody LancamentoDTO lancamentoDTO) throws IliaException {
        facade.service.lancamento.save(lancamentoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LancamentoDTO>> getAllLancamentos(){
        return ResponseEntity.ok(facade.mapperStruct.lancamento.toDto(facade.repository.lancamento.findAll()));
    }
}
