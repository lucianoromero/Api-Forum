package br.com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

/**
 * @author luciano.luiz.romero Criando a interface de conexão a tabela topico,
 *         quando extedindo de JPA Repository devemos informar qual tabela vai
 *         conectar no caso TOPICO e qual é o tipo do ID (chave primaria) nesse
 *         caso é long private Long id;
 */
public interface TopicoRepository extends JpaRepository<Topico, Long> {

	/**
	 * @param nomeCurso
	 * @return Retorna uma lista dos curso e realiza filtro
	 */
	Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);
}
