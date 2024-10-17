package br.com.fiap.gestaoDeResiduos.dto;

import br.com.fiap.gestaoDeResiduos.model.Calendario;
import jakarta.validation.constraints.NotBlank;

public record CalendarioCadastroDto(
        Long idCalendario,
        @NotBlank(message = "O dia da coleta é obrigatório!")
        String nomeDiaColeta,
        @NotBlank(message = "O horário da coleta é obrigatório!")
        String horaColeta) {


    public CalendarioCadastroDto(Calendario calendario) {
        this(
                calendario.getIdCalendario(),
                calendario.getNomeDiaColeta(),
                calendario.getHoraColeta());
    }
}


