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

import br.com.unipac.domain.Vendedor;
import br.com.unipac.domain.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VendedorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VendedorRepository repository;

    @Test
    public void testFindByName() {

        entityManager.persist(new Vendedor("Jose", "Leonardo"));

        List<Vendedor> vendedor = repository.findByNome("Jose");
        assertEquals(1, vendedor.size());

        assertThat(vendedor).extracting(Vendedor::getNome).containsOnly("Jose");

    }

}