package br.com.lvdc.internal.facade.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lvdc.domain.modelo.Filme;
import br.com.lvdc.interfaces.service.FilmeService;
import br.com.lvdc.internal.facade.FilmeFacade;
import br.com.lvdc.internal.facade.assembler.FilmeResourceAssembler;
import br.com.lvdc.internal.facade.dto.FilmeDto;
import br.com.lvdc.internal.facade.dto.FilmeDtoRequest;

@Component
public class FilmeFacadeImpl implements FilmeFacade {
	
	@Autowired
	private FilmeService filmeService;
	
	@Autowired
	private FilmeResourceAssembler assembler;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public FilmeDto salvar(final FilmeDtoRequest request) {
		Filme filme = modelMapper.map(request, Filme.class);
		Filme filmeToSave = filmeService.salvar(filme);
		FilmeDto filmeDto = modelMapper.map(filmeToSave, FilmeDto.class);
		return filmeDto;
	}

	@Override
	public void excluir(final Long id) {
		filmeService.deletar(id);
	}

	@Override
	public List<FilmeDto> listAll() {
		List<Filme> list = filmeService.list();
		List<FilmeDto> listDto = assembler.toResources(list);
		return listDto;
	}

	@Override
	public FilmeDto findById(Long id) {
		Filme filme = filmeService.buscarPorId(id);
		FilmeDto filmeDto = assembler.toResource(filme);
		return filmeDto;
	}

}
