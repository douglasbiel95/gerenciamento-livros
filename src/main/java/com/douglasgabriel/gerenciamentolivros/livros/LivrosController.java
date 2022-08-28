package com.douglasgabriel.gerenciamentolivros.livros;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/livros")
public class LivrosController {

	@ApiOperation(value = "Teste")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Sucesso")
	})
	@GetMapping
	public String teste() {
		return "Teste";
	}
}
