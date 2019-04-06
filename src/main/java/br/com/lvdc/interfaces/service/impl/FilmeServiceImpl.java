package br.com.lvdc.interfaces.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lvdc.core.exception.LocadoraBusinessException;
import br.com.lvdc.domain.modelo.Filme;
import br.com.lvdc.interfaces.service.FilmeService;
import br.com.lvdc.repository.FilmeRepository;

@Service
public class FilmeServiceImpl implements FilmeService{
	
	@Autowired
	private FilmeRepository filmeRepository;

	@Override
	public Filme salvar(final Filme filme) {
		if(filme.getTitulo() == null) {
			throw new LocadoraBusinessException("Não é possivel salvar filme, parametros inválidos");
		}
		return filmeRepository.save(filme);
	}

	@Override
	public void deletar(final Long id) {
		Filme filme = buscarPorId(id);
		filmeRepository.delete(filme);
	}
	
	public Filme buscarPorId(final Long id) {
		return filmeRepository.findById(id).orElseThrow(() -> 
			new LocadoraBusinessException("Id não encontrado: "+id) );
	}

	@Override
	public List<Filme> list() {
		return filmeRepository.findAll();
	}

}
