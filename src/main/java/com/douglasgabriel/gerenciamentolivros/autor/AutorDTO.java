package com.douglasgabriel.gerenciamentolivros.autor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {

	private Long id;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String nomeAutor;

	@NotNull
	@Max(128)
	private int idadeAutor;
}
