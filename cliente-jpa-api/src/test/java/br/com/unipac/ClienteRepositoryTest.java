package br.com.unipac;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.unipac.domain.Cliente;
import br.com.unipac.domain.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClienteRepository repository;

    @Test
    public void testFindByName() {

        entityManager.persist(new Cliente("Rogerio", "Fontes"));

        List<Cliente> clientes = repository.findByNome("Rogerio");
        assertEquals(1, clientes.size());

        assertThat(clientes).extracting(Cliente::getNome).containsOnly("Rogerio");

    }

}