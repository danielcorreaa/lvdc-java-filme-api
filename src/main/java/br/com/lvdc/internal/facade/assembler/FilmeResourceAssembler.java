package br.com.lvdc.internal.facade.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.lvdc.domain.modelo.Filme;
import br.com.lvdc.internal.facade.dto.FilmeDto;
import br.com.lvdc.internal.webapi.FilmeController;

@Component
public class FilmeResourceAssembler extends ResourceAssemblerSupport<Filme, FilmeDto>{
	
	public FilmeResourceAssembler() {
		super(FilmeController.class, FilmeDto.class);
	}

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FilmeDto toResource(Filme entity) {
		FilmeDto filmeDto = createResourceWithId(entity.getId(), entity);
		modelMapper.map(entity, filmeDto);
		return filmeDto;
	}

}
