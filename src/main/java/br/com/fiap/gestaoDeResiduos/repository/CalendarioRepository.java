package br.com.fiap.gestaoDeResiduos.repository;

import br.com.fiap.gestaoDeResiduos.model.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
    @Query("SELECT c FROM Calendario c WHERE c.nomeDiaColeta = :nomeDiaColeta")
    Optional<Calendario> buscarPorNomeDiaColeta(@Param("nomeDiaColeta") String nomeDiaColeta);

    Optional<Calendario> findByHoraColeta(String horaColeta);

}
