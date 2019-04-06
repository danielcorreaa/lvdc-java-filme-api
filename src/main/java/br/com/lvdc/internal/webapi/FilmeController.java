package br.com.lvdc.internal.webapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lvdc.internal.facade.FilmeFacade;
import br.com.lvdc.internal.facade.dto.FilmeDto;
import br.com.lvdc.internal.facade.dto.FilmeDtoRequest;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("filme")
public class FilmeController {
	
	@Autowired
	private FilmeFacade filmeFacade;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody final FilmeDtoRequest request) throws URISyntaxException{
		FilmeDto filmeDto = filmeFacade.salvar(request);
		return ResponseEntity.created(new URI(filmeDto.getTitulo())).build();	
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody final FilmeDtoRequest request) {
		FilmeDto filmeDto = filmeFacade.salvar(request);
		return ResponseEntity.ok(filmeDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") final Long id){
		filmeFacade.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable("id") final Long id){
		FilmeDto filmeDto = filmeFacade.findById(id);
		return ResponseEntity.ok(filmeDto);
	}
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		List<FilmeDto> filmeDto = filmeFacade.listAll();
		return ResponseEntity.ok(filmeDto);
	}
	
	

}
