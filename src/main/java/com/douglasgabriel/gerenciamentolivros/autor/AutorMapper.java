package com.douglasgabriel.gerenciamentolivros.autor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutorMapper {

	// Instancia do AutoMapper, já que ele não é gerenciavel pelo spring
	AutorMapper INSTANCIAAUTOMAPPER = Mappers.getMapper(AutorMapper.class);
	
	// Metodo que retorna uma entidade Autor
	Autor toModel(AutorDTO autorDTO);

	// Metodo que retorna uma entidade AutorDTO
	AutorDTO toDTO(Autor autor);
}
