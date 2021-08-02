package br.com.ilia.Ilia.Project.dto;

import br.com.ilia.Ilia.Project.entity.Funcionario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class LancamentoDTO {

    private Long id;
    private String dataHora;
    private String descricao;
    private String localizacao;
    private Long funcionarioId;
}
