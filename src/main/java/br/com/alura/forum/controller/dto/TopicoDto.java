package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Topico;

public class TopicoDto {
    
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dateCriacao;

	//Fazendo referencia para receber um objeto do tipo topico e retornar apenas o que ele quer padrao DTO
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dateCriacao = topico.getDataCriacao();
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDateCriacao() {
		return dateCriacao;
	}

	//Metodo que faz o papel de conveter
	public static List<TopicoDto> converter(List<Topico> topicos) {
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
	}

}
