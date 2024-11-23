package br.com.fiap.greenenergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.greenenergy.model.Onibus;

@Repository
public interface OnibusRepository extends JpaRepository<Onibus, Long> {

}
