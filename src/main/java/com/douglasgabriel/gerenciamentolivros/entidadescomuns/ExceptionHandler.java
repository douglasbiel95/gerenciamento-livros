package com.douglasgabriel.gerenciamentolivros.entidadescomuns;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionHandler extends ResponseEntityExceptionHandler {

	
	
	
	
	// Metodo privado que ira criar um responseEntity personalizado
	private ResponseEntity<Object> criaResponseEntityPersonalizado(final HttpStatus httpStatus, final String mensagem, List<String> listaErros) {
		
		// Instancia de um objeto de erro personalizado da api
		ApiError apiError = ApiError.builder()
				.codigoErro(httpStatus.value())
				.statusErro(httpStatus.getReasonPhrase())
				.timestampErro(LocalDateTime.now())
				.mensagemErro(mensagem)
				.erros(listaErros)
				.build();
		
		// retorno do metodo, onde o corpo do status o objeto de erro personalizado.
		return ResponseEntity.status(httpStatus).body(apiError);
	}
}
