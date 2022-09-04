package com.douglasgabriel.gerenciamentolivros.usuario;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.douglasgabriel.gerenciamentolivros.livros.Livros;

import lombok.Data;

@Entity
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int idade;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private Genero genero;
	
	@Column(nullable = false, unique = true, length = 70)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDate dataNascimento;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Livros> livrosObtidos;
}
