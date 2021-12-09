package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;

@JsonInclude(Include.NON_NULL)
public class DetalhesDoTopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dateCriacao;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDto> respostas;

	/**
	 * @param topico Recebe o objeto do tipo topico para construção do retorno
	 *               conforme os atributos da classe
	 * 
	 */
	public DetalhesDoTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dateCriacao = topico.getDataCriacao();
		if (Objects.nonNull(topico.getAutor())) {
			this.nomeAutor = topico.getAutor().getNome();
		}
		this.status = topico.getStatus();

		this.respostas = new ArrayList<>();
		this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
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

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

}
