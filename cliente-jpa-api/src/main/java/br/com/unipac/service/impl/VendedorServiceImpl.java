package br.com.unipac.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.unipac.domain.Vendedor;
import br.com.unipac.domain.repository.VendedorRepository;
import br.com.unipac.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Override
	public Vendedor save(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	@Override
	public List<Vendedor> listAll() {
		return vendedorRepository.findAll();
	}

	@Override
	public Vendedor update(Long id, Vendedor vendedor) {
		vendedor.setId(id);
		return vendedorRepository.save(vendedor);
	}

	@Override
	public Optional<Vendedor> findById(Long id) {
		return vendedorRepository.findById(id);
	}

	@Override
	public void remove(Long id) {
		vendedorRepository.deleteById(id);
	}

	@Override
	public List<Vendedor> findByNome(String name) {
		return vendedorRepository.findByNome(name);
	}

	@Override
	public Page<Vendedor> findAllPageable(Pageable pageable) {
		return vendedorRepository.findAll(pageable);
	}
}
