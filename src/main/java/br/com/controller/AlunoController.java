package br.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.com.entity.Aluno;
import br.com.entity.Turma;
import br.com.repository.AlunoRepository;
import br.com.repository.TurmaRepository;

@Controller
public class AlunoController {
	
	@Autowired
	AlunoRepository dao;
	@Autowired
	TurmaRepository tdao;

	@GetMapping(value="/")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("inicio");
		List<Turma> listaturma = tdao.findAll();
		try {
			mv.addObject("listaturma", listaturma);
		}catch(Exception ex) {
		}
		return mv;
	}	
	
	@GetMapping(value="/adicionarTurma")
	public ModelAndView adicionarTurma() {
		ModelAndView mv = new ModelAndView("turma");
		return mv;
	}
	
	@PostMapping(value="/adicionarTurma")
	public void cadastrarTurma(@RequestParam String nomeTurma, HttpServletResponse response, HttpSession session, HttpServletRequest request) throws Exception{
		session = request.getSession(true);
		Turma t = new Turma(nomeTurma);
		try {
			tdao.save(t);
		response.sendRedirect("/");
		session.setAttribute("msg", "");
		}catch(Exception ex) {
			session.setAttribute("msg", "Nome da turma já existente!");
			response.sendRedirect("/");
			
		}
	}
	
	@PostMapping(value="/cadastrar")
	public void cadastrar(@RequestParam String nome, @RequestParam String nota1, @RequestParam String nota2,
			HttpServletResponse response, HttpSession session, HttpServletRequest request) {
		Aluno a = new Aluno(nome,new Double(nota1),new Double(nota2));
		session = request.getSession(true);
		try {		
			a.setTurma((Turma) session.getAttribute("turma"));
			a.gerarMedia();
			a.gerarSituacao();
			dao.save(a);
			response.sendRedirect("/turma/" + a.getTurma().getIdTurma());
		}catch(Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			session.setAttribute("msg", "Dados não gravados!");
			ex.printStackTrace();
		}		
	}
	
//	@GetMapping(value="/excluir/{idAluno}")
//	public void excluiraluno(@PathVariable Long idAluno, HttpServletResponse response, HttpSession session, HttpServletRequest request) {
//		session = request.getSession(true);
//		try {
//			Aluno a = dao.findById(idAluno).get();
//			dao.delete(a);
//			response.sendRedirect("/turma/"+ a.getTurma().getIdTurma());	
//			a.setTurma((Turma) session.getAttribute("turma"));
//		}catch(Exception ex) {
//		}
//	}
	
	@GetMapping(value="/excluirturma/{idTurma}")
	public void excluir(@PathVariable Integer idTurma, HttpServletResponse response) {
		try {
			Turma t = tdao.findById(idTurma).get();
			tdao.delete(t);
			response.sendRedirect("/");
		}catch(Exception ex) {
		}
	}
	
	@GetMapping(value="/editar")
	public ModelAndView editar(HttpSession session, HttpServletRequest request) {
		session = request.getSession(true);
		ModelAndView mv = new ModelAndView("editar");		
		mv.addObject("aluno", session.getAttribute("aluno"));
		return mv;		
	}
	
	
	@GetMapping(value="/editar/{idAluno}")
	public void editar(@PathVariable Long idAluno, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session = request.getSession(true);
		try {
			Aluno a = dao.findById(idAluno).get();
			session.setAttribute("aluno", a);
			response.sendRedirect("/editar");
		}catch(Exception ex) {}
	}
	
	@GetMapping(value="/turma")
	public ModelAndView initaluno(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession(true);		
		ModelAndView mv = new ModelAndView("sistema");
		try {
			mv.addObject("turma", session.getAttribute("turma"));
			mv.addObject("lista", session.getAttribute("lista"));			
		}catch(Exception ex) {}		
		return mv;						
	}
	
	@GetMapping(value="/turma/{idTurma}")
	public void turma(@PathVariable Integer idTurma, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session = request.getSession(true);		
		try {
			Turma t = tdao.findById(idTurma).get();		
			session.setAttribute("turma", t);
			session.setAttribute("lista", t.getAlunos());				
			response.sendRedirect("/turma");
		}catch(Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			}
	}
	
	@PostMapping(value="/editar")
	public void editar(@RequestParam String idAluno, @RequestParam String nome, @RequestParam String nota1, 
			@RequestParam String nota2,	@RequestParam String media, @RequestParam String situacao, 
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			session = request.getSession(true);
			Aluno a = new Aluno(new Long(idAluno),nome,new Double(nota1), new Double(nota2), new Double(media),situacao);
			try {
				a.setTurma((Turma) session.getAttribute("turma"));				
				a.gerarMedia();
				a.gerarSituacao();
				dao.save(a);
				response.sendRedirect("/turma/" + a.getTurma().getIdTurma());
			}catch(Exception ex) {}
	}
	
}
