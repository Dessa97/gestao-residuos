package br.com.fiap.gestaoDeResiduos.dto;

import br.com.fiap.gestaoDeResiduos.model.Bairro;
import jakarta.validation.constraints.NotBlank;

public record BairroCadastroDto(
        Long idBairro,
        @NotBlank(message = "O nome do bairro é obrigatório!")
        String nomeBairro,
        @NotBlank(message = "O nome da cidade é obrigatório!")
        String nomeCidade,
        @NotBlank(message = "O número do CEP é obrigatório!")
        String numeroCep
) {
    public BairroCadastroDto(Bairro bairro) {
        this(
                bairro.getIdBairro(),
                bairro.getNomeBairro(),
                bairro.getNomeCidade(),
                bairro.getNumeroCep());
    }
}


