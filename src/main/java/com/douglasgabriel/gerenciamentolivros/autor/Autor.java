package com.douglasgabriel.gerenciamentolivros.autor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.douglasgabriel.gerenciamentolivros.entidadescomuns.Auditavel;
import com.douglasgabriel.gerenciamentolivros.livros.Livros;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Autor extends Auditavel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nomeAutor;
	
	@Column(columnDefinition = "integer default 0")
	private int idadeAutor;
	
	@OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
	private List<Livros> livrosEscritos;
}
