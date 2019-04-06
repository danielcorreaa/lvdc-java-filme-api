package br.com.lvdc.interfaces.service;

import java.util.List;

import br.com.lvdc.domain.modelo.Filme;

public interface FilmeService {
	
	Filme salvar(Filme filme);
	
	void deletar(Long id);
	
	Filme buscarPorId(final Long id);
	
	List<Filme> list();
	

}
