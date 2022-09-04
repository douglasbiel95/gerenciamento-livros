package com.douglasgabriel.gerenciamentolivros.livros;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.douglasgabriel.gerenciamentolivros.autor.Autor;
import com.douglasgabriel.gerenciamentolivros.editora.Editora;
import com.douglasgabriel.gerenciamentolivros.usuario.Usuario;

import lombok.Data;

@Entity
@Data
public class Livros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String isbn;
	
	@Column(columnDefinition = "integer default 0")
	private int numeroPaginas;
	
	@Column(columnDefinition = "integer default 0")
	private int numeroCapitulos;

	@ManyToOne(cascade = {CascadeType.MERGE})
	private Autor autor;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Editora editora;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Usuario usuario;
	
	
}
