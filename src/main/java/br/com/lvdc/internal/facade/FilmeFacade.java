package br.com.lvdc.internal.facade;

import java.util.List;

import br.com.lvdc.internal.facade.dto.FilmeDto;
import br.com.lvdc.internal.facade.dto.FilmeDtoRequest;

public interface FilmeFacade {	
	
	FilmeDto salvar(FilmeDtoRequest request);
	
	void excluir(Long id);
	
	List<FilmeDto> listAll();
	
	FilmeDto findById(Long id);
	
	

}
