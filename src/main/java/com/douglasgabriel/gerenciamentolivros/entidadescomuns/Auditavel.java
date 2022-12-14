package com.douglasgabriel.gerenciamentolivros.entidadescomuns;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditavel {

	@CreatedDate
	@Column(nullable = false)
	protected LocalDateTime dataCriacao;
	
	@LastModifiedDate
	@Column
	protected LocalDateTime dataUltimaModificacao;
}
