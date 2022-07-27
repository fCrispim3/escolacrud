package com.spring.escolacrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.escolacrud.models.Aluno;


public interface EscolaSystemRepository extends CrudRepository<Aluno, String> {

	Aluno findByiDAluno(long iDAluno);
	Aluno deleteByiDAluno(long iDAluno);

}

