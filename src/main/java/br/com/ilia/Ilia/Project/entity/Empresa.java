package br.com.ilia.Ilia.Project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 3960436649365666213L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Funcionario> funcionarios;



    @PrePersist
    public void prePersist() {
        creationDate = LocalDate.now();

    }

    @PreUpdate
    public void preUpdate() {
        updateDate = LocalDate.now();
    }


}