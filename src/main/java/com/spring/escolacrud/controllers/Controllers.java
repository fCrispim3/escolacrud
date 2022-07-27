package com.spring.escolacrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.spring.escolacrud.models.Aluno;
import com.spring.escolacrud.models.Professor;
import com.spring.escolacrud.models.Turma;
import com.spring.escolacrud.repository.EscolaSystemRepository;
import com.spring.escolacrud.repository.RepositoryProfessor;
import com.spring.escolacrud.repository.RepositoryTurma;

@Controller
public class Controllers {

	@Autowired
	private EscolaSystemRepository esr; 
	@Autowired
	private RepositoryProfessor esrp; 
	@Autowired
	private RepositoryTurma esrt;
	
	@RequestMapping("/index")
public String index() {
	return "/index";
}
	//cadastrar-dados
	@RequestMapping(value="/cadastrar-aluno", method = RequestMethod.GET)
	public String cadastrarAluno() {
		return "/cadastrar-aluno";
	}
	
	@RequestMapping(value="/cadastrar-aluno", method = RequestMethod.POST)
	public String cadastrarAluno(Aluno aluno) {
		esr.save(aluno);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/cadastrar-professor", method = RequestMethod.GET)
	public String cadastrarProfessor() {
		return "/cadastrar-professor";
	}
	
	@RequestMapping(value="/cadastrar-professor", method = RequestMethod.POST)
	public String cadastrarProfessor(Professor professor) {
		esrp.save(professor);
		return "redirect:/index";
		
	}

	@RequestMapping(value="/cadastrar-turma", method = RequestMethod.GET)
	public String cadastrarTurma() {
		return "/cadastrar-turma";
	}
	
	@RequestMapping(value="/cadastrar-turma", method = RequestMethod.POST)
	public String cadastrarTurma(Turma turma) {
		esrt.save(turma);
		return "redirect:/index";
		
	}
	
	//consultar dados
	@RequestMapping("/consultar-aluno")
	public ModelAndView listarAlunos() {
		ModelAndView mv = new ModelAndView("consultar-aluno");
		Iterable<Aluno> alunos = esr.findAll();
		mv.addObject("alunos", alunos);
		return mv;
}
	@RequestMapping("/consultar-professor")
	public ModelAndView listarProfessores() {
		ModelAndView mv = new ModelAndView("consultar-professor");
		Iterable<Professor> professores = esrp.findAll();
		mv.addObject("professores", professores);
		return mv;
}
	@RequestMapping("/consultar-turma")
	public ModelAndView listarTurmas() {
		ModelAndView mv = new ModelAndView("consultar-turma");
		Iterable<Turma> turmas = esrt.findAll();
		mv.addObject("turmas", turmas);
		return mv;
}
	// alterar dados
	
	@RequestMapping (value="/atualizarAluno/{iDAluno}", method=RequestMethod.GET)
	public ModelAndView atualizarAluno(@PathVariable("iDAluno") long iDAluno) {
		Aluno aluno = esr.findByiDAluno(iDAluno);
		ModelAndView mv = new ModelAndView("atualizar-aluno");
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@RequestMapping(value="/atualizarAluno/{iDAluno}", method=RequestMethod.POST)
	public String alterarAluno(@Validated Aluno aluno, BindingResult result, RedirectAttributes attributes) {
		esr.save(aluno);
		return "redirect:/index";
		
	}
	
	@RequestMapping (value="/atualizarProfessor/{iDProfessor}", method=RequestMethod.GET)
	public ModelAndView atualizarProfessor(@PathVariable("iDProfessor") long iDProfessor) {
		Professor professor = esrp.findByiDProfessor(iDProfessor);
		ModelAndView mv = new ModelAndView("atualizar-professor");
		mv.addObject("professor", professor);
		return mv;
	}
	
	@RequestMapping(value="/atualizarProfessor/{iDProfessor}", method=RequestMethod.POST)
	public String alterarProfessor(@Validated Professor professor, BindingResult result, RedirectAttributes attributes) {
		esrp.save(professor);
		return "redirect:/index";
		
	}
	
	@RequestMapping (value="/atualizarTurma/{iDTurma}", method=RequestMethod.GET)
	public ModelAndView atualizarTurma(@PathVariable("iDTurma") long iDTurma) {
		Turma turma = esrt.findByiDTurma(iDTurma);
		ModelAndView mv = new ModelAndView("atualizar-turma");
		mv.addObject("professor", turma);
		return mv;
	}
	
	@RequestMapping(value="/atualizarTurma/{iDTurma}", method=RequestMethod.POST)
	public String alterarTurma(@Validated Turma turma, BindingResult result, RedirectAttributes attributes) {
		esrt.save(turma);
		return "redirect:/index";
		
	}
	
	//excluir dados
	
	@RequestMapping ("/excluirAluno/{iDAluno}")
	public ModelAndView  excluirAluno(@PathVariable("iDAluno") long iDAluno) {
		Aluno aluno = esr.findByiDAluno(iDAluno);
		ModelAndView mv = new ModelAndView("excluir-aluno");
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@RequestMapping("/deletarAluno")
	public String deletarAluno(long iDAluno){
		Aluno aluno = esr.findByiDAluno(iDAluno);
		esr.delete(aluno);
		return "redirect:/index";
	}
	
	@RequestMapping ("/excluirProfessor/{iDProfessor}")
	public ModelAndView  excluirProfessor(@PathVariable("iDProfessor") long iDProfessor) {
		Professor professor = esrp.findByiDProfessor(iDProfessor);
		ModelAndView mv = new ModelAndView("excluir-professor");
		mv.addObject("professor", professor);
		return mv;
	}
	
	@RequestMapping("/deletarProfessor")
	public String deletarProfessor(long iDProfessor){
		Professor professor = esrp.findByiDProfessor(iDProfessor);
		esrp.delete(professor);
		return "redirect:/index";
	}
	
	@RequestMapping ("/excluirTurma/{iDTurma}")
	public ModelAndView  excluirTurma(@PathVariable("iDTurma") long iDTurma) {
		Turma turma = esrt.findByiDTurma(iDTurma);
		ModelAndView mv = new ModelAndView("excluir-turma");
		mv.addObject("turma", turma);
		return mv;
	}
	
	@RequestMapping("/deletarTurma")
	public String deletarTurma(long iDTurma){
		Turma turma = esrt.findByiDTurma(iDTurma);
		esrt.delete(turma);
		return "redirect:/index";
	}
}
