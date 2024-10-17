package br.com.fiap.gestaoDeResiduos.repository;

import br.com.fiap.gestaoDeResiduos.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
    @Query("SELECT b FROM Bairro b WHERE b.nomeBairro = :nomeBairro")
    Optional<Bairro> buscarPorNomeBairro(@Param("nomeBairro") String nomeBairro);

    Optional<Bairro> findByNomeCidade(String nomeCidade);

}



