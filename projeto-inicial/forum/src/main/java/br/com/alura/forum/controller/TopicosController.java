package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {
		
		if (nomeCurso == null) {
			List<Topico> topico = topicoRepository.findAll();
			return TopicoDto.converter(topico);
		} else {
			List<Topico> topico = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topico);
		}
	}
}
