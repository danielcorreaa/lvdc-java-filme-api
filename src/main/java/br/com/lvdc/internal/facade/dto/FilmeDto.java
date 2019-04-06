package br.com.lvdc.internal.facade.dto;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FilmeDto extends ResourceSupport {	
	
	private String titulo;
	private Double preco;
	private Boolean disponivel;
	private String img;

}
