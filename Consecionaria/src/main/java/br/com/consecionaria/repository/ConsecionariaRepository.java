package br.com.consecionaria.repository;

import br.com.consecionaria.model.Consecionaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsecionariaRepository extends JpaRepository <Consecionaria, Long> {
}
