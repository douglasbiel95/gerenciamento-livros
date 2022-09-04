package com.douglasgabriel.gerenciamentolivros.editora;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.douglasgabriel.gerenciamentolivros.livros.Livros;

import lombok.Data;

@Entity
@Data
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nomeEditora;
	
	@Column(nullable = false, unique = true)
	private String codigo;
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDate dataFundacao;
	
	@OneToMany(mappedBy = "editora", fetch = FetchType.LAZY)
	private List<Livros> livrosPublicados;
	
}
