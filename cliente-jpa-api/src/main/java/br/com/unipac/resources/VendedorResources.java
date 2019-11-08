package br.com.unipac.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipac.domain.Vendedor;
import br.com.unipac.service.VendedorService;

@RestController
@RequestMapping(path = "/vendedor")
public class VendedorResources {
	
	@Autowired
	private VendedorService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<Vendedor>> getAll() {
		List<Vendedor> vendedor = service.listAll();
		return new ResponseEntity<>(vendedor, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Vendedor> add(@Valid @RequestBody Vendedor vendedor) {
		Vendedor result = service.save(vendedor);
		return new ResponseEntity<Vendedor>(result, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Vendedor> change(@PathVariable Long id, @RequestBody Vendedor vendedor) {
		Vendedor result = service.update(id, vendedor);
		return new ResponseEntity<Vendedor>(result, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> remove(@PathVariable Long id) {
		service.remove(id);
		return new ResponseEntity<>("Dados Deletados!", HttpStatus.OK);
	}

	@GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Vendedor>> getUserByUsername(@PathVariable("name") String name) {
		List<Vendedor> vendedor = service.findByNome(name);

		return new ResponseEntity<List<Vendedor>>(vendedor, HttpStatus.OK);
	}
}
