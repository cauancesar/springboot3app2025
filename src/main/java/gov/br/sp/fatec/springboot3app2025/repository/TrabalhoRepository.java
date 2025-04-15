package gov.br.sp.fatec.springboot3app2025.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.br.sp.fatec.springboot3app2025.entity.Trabalho;
// criar interface vazia e dar mvn test
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{
    //mvn test para testar
    public List<Trabalho> findByTituloContainsAndNotaGreaterThan(String titulo, Integer nota);
}
