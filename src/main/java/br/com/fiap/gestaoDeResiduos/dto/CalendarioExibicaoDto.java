package br.com.fiap.gestaoDeResiduos.dto;

import br.com.fiap.gestaoDeResiduos.model.Calendario;

public record CalendarioExibicaoDto(
        Long idCalendario,
        String nomeDiaColeta,
        String horaColeta) {


    public CalendarioExibicaoDto(Calendario calendario) {
        this(
                calendario.getIdCalendario(),
                calendario.getNomeDiaColeta(),
                calendario.getHoraColeta());
    }
}



