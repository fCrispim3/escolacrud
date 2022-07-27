package com.spring.escolacrud.repository;

import org.springframework.data.repository.CrudRepository;


import com.spring.escolacrud.models.Turma;

public interface RepositoryTurma extends CrudRepository<Turma, String> {
	
	Turma findByiDTurma(long iDTurma);
	Turma deleteByiDTurma(long iDTurma);
	

}
