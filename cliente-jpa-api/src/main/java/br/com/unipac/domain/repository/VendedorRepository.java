package br.com.unipac.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unipac.domain.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
	List<Vendedor> findByNome(String name);
}
