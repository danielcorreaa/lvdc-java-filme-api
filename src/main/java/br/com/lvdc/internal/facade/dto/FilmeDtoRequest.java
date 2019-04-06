package br.com.lvdc.internal.facade.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class FilmeDtoRequest {
	
	private Long id;
	private String titulo;
	private Double preco;
	private Boolean disponivel;
	private String img;


}
