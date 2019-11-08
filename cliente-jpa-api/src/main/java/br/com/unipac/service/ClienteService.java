package br.com.unipac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.unipac.domain.Cliente;

public interface ClienteService {
	Cliente save(Cliente cliente);

	List<Cliente> listAll();

	Cliente update(Long id, Cliente cliente);

	Optional<Cliente> findById(Long id);

	void remove(Long id);

	List<Cliente> findByNome(String name);

	Page<Cliente> findAllPageable(Pageable pageable);
}
