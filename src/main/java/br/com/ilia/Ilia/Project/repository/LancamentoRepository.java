package br.com.ilia.Ilia.Project.repository;

import br.com.ilia.Ilia.Project.entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query(value = "SELECT l FROM Lancamento l WHERE l.funcionario.id = :funcionarioId and DATE(l.creationDate) = :date ")
    List<Lancamento> findByFuncionarioIdAndCreationDate(@Param("funcionarioId") Long id, @Param("date") LocalDate date);

}
