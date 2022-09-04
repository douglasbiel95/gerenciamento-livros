package com.douglasgabriel.gerenciamentolivros.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genero {

	FEMININO("Feminino"),
	MASCULINO("Masculino");
	
	private String descricao;
	
}
