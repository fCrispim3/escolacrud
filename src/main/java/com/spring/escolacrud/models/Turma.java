package com.spring.escolacrud.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long iDTurma;
	private String turno;
	private String periodo;
	private String qtdAlunos;
	private String codTurma;
	private String disciplina;
	
	public Turma() {
		// TODO Auto-generated constructor stub
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getPeriodo() {
		return periodo;
	}

	public String getQtdAlunos() {
		return qtdAlunos;
	}

	public String getCodTurma() {
		return codTurma;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setQtdAlunos(String qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getiDTurma() {
		return iDTurma;
	}

	public String getTurno() {
		return turno;
	}


	public void setiDTurma(long iDTurma) {
		this.iDTurma = iDTurma;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}



}
