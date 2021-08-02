package br.com.ilia.Ilia.Project.service.mapper;

import java.util.List;
import java.util.Set;

public interface DtoToEntityMapper<D,E>{
    E toEntity(D dto);
    List<E> toEntity(List<D> dtoList);
    Set<E> toEntity(Set<D> dtoSet);

}
