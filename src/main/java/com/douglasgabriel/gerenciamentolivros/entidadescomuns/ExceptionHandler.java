package com.douglasgabriel.gerenciamentolivros.entidadescomuns;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.douglasgabriel.gerenciamentolivros.entidadescomuns.excecoes.EntidadeExistenteException;
import com.douglasgabriel.gerenciamentolivros.entidadescomuns.excecoes.EntidadeNaoEncontradaException;

public class ExceptionHandler extends ResponseEntityExceptionHandler {

		
	private static final String ERRO_NA_VALIDAÇÃO_DOS_ARGUMENTOS_INFORMADOS = "Erro na validação dos argumentos informados";

	
	// Metodo herdado que lida com argumentos invalidos
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> listaErros = new ArrayList<>();
		
		// Adiciona na lista de erros possiveis erros relacionados as informacoes adicionadas nos campos
		exception.getBindingResult().getFieldErrors().forEach(erroCampo -> listaErros.add(
				"Campo: " + erroCampo.getField().toUpperCase() + " " + erroCampo.getDefaultMessage()));
		
		// Adiciona na lista erros globais
		exception.getBindingResult().getGlobalErrors().forEach(errosGlobais -> listaErros.add(
				"Objeto: " + errosGlobais.getObjectName().toUpperCase() + " " + errosGlobais.getDefaultMessage()));
		
		return criaResponseEntityPersonalizado(HttpStatus.BAD_REQUEST, ERRO_NA_VALIDAÇÃO_DOS_ARGUMENTOS_INFORMADOS, listaErros);
	}

	// Metodo que lida com entidades nao encontradas na aplicacao
	@org.springframework.web.bind.annotation.ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handleEntidadeNaoEncontradaException(final EntidadeNaoEncontradaException exception) {
		return criaResponseEntityPersonalizado(HttpStatus.NOT_FOUND, exception.getMessage(),
				Collections.singletonList(exception.getMessage()));
	}
	
	// Metodo que lida com entidades existentes na aplicacao
	@org.springframework.web.bind.annotation.ExceptionHandler(EntidadeExistenteException.class)
	public ResponseEntity<Object> handleEntidadeExistenteException(final EntidadeExistenteException exception) {
		return criaResponseEntityPersonalizado(HttpStatus.BAD_REQUEST, exception.getMessage(),
				Collections.singletonList(exception.getMessage()));
	}

	// Metodo privado que ira criar um responseEntity personalizado
	private ResponseEntity<Object> criaResponseEntityPersonalizado(final HttpStatus httpStatus, final String mensagem,
			List<String> listaErros) {

		// Instancia de um objeto de erro personalizado da api
		ApiError apiError = ApiError.builder().codigoErro(httpStatus.value()).statusErro(httpStatus.getReasonPhrase())
				.timestampErro(LocalDateTime.now()).mensagemErro(mensagem).erros(listaErros).build();

		// retorno do metodo, onde o corpo do status o objeto de erro personalizado.
		return ResponseEntity.status(httpStatus).body(apiError);
	}
}
