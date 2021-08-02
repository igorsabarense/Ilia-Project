package br.com.ilia.Ilia.Project.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Facade {
    @Autowired
    public MapperStruct mapperStruct;

    @Autowired
    public ServiceFacade service;

    @Autowired
    public RepositoryFacade repository;


}
