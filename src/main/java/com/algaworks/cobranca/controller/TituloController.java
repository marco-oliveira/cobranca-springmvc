package com.algaworks.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.controller.repository.Titulos;
import com.algaworks.cobranca.model.StatusTitulo;
import com.algaworks.cobranca.model.Titulo;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	private final String CADASTRO_VIEW= "CadastroTitulo";
	
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		titulos.save(titulo);
		mv.addObject("mensagem", "Título salvo com sucesso!");
		return 	mv;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView buscar(){
		ModelAndView mv = new ModelAndView("PesquisaTitulo");
		List<Titulo> todosTitulos = titulos.findAll();
		mv.addObject("todosTitulos", todosTitulos);
		return mv;
		
	}
	
	@ModelAttribute("todosStatus")
	public List<StatusTitulo> todosStatus(){
		return Arrays.asList(StatusTitulo.values()); 
	}
	
}
