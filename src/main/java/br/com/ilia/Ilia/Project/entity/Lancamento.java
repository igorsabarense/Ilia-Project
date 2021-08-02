package br.com.ilia.Ilia.Project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 6524560251526772839L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date" , nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "localizacao")
    private String localizacao;

    @ManyToOne
    @JoinColumn(name="funcionario_id", nullable=false)
    private Funcionario funcionario;

    @PrePersist
    public void prePersist() {
        if(creationDate == null){
            creationDate = LocalDateTime.now();
        }
    }
}

