package br.com.unipac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.unipac.domain.Vendedor;

public interface VendedorService {
	Vendedor save(Vendedor vendedor);

	List<Vendedor> listAll();

	Vendedor update(Long id, Vendedor vendedor);

	Optional<Vendedor> findById(Long id);

	void remove(Long id);

	List<Vendedor> findByNome(String name);

	Page<Vendedor> findAllPageable(Pageable pageable);
}
