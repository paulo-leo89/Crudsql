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

import br.com.unipac.domain.Cliente;
import br.com.unipac.service.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResources {
	
	@Autowired
	private ClienteService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<Cliente>> getAll() {
		List<Cliente> clientes = service.listAll();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> add(@Valid @RequestBody Cliente cliente) {
		Cliente result = service.save(cliente);
		return new ResponseEntity<Cliente>(result, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> change(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente result = service.update(id, cliente);
		return new ResponseEntity<Cliente>(result, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> remove(@PathVariable Long id) {
		service.remove(id);
		return new ResponseEntity<>("Dados Deletados!", HttpStatus.OK);
	}

	@GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Cliente>> getUserByUsername(@PathVariable("name") String name) {
		List<Cliente> clientes = service.findByNome(name);

		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
}
