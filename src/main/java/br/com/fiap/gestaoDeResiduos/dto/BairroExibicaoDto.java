package br.com.fiap.gestaoDeResiduos.dto;

import br.com.fiap.gestaoDeResiduos.model.Bairro;

public record BairroExibicaoDto(
        Long idBairro,
        String nomeBairro,
        String nomeCidade,
        String numeroCep
) {

    public BairroExibicaoDto(Bairro bairro) {
        this(
                bairro.getIdBairro(),
                bairro.getNomeBairro(),
                bairro.getNomeCidade(),
                bairro.getNumeroCep());
    }
}

