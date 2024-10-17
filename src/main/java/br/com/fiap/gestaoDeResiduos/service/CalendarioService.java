package br.com.fiap.gestaoDeResiduos.service;

import br.com.fiap.gestaoDeResiduos.dto.CalendarioCadastroDto;
import br.com.fiap.gestaoDeResiduos.dto.CalendarioExibicaoDto;
import br.com.fiap.gestaoDeResiduos.model.Calendario;
import br.com.fiap.gestaoDeResiduos.repository.CalendarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {
    @Autowired
    private CalendarioRepository calendarioRepository;

    public CalendarioCadastroDto salvarCalendario(CalendarioCadastroDto calendarioCadastroDto) {
        Calendario calendario = new Calendario();
        BeanUtils.copyProperties(calendarioCadastroDto, calendario);
        Calendario calendarioSalvo = calendarioRepository.save(calendario);
        return new CalendarioCadastroDto(calendarioSalvo);
    }

    public CalendarioExibicaoDto buscarPorId(Long id) {
        return calendarioRepository.findById(id)
                .map(CalendarioExibicaoDto::new)
                .orElseThrow(() -> new RuntimeException("Calendário não existe!"));
    }

    public CalendarioExibicaoDto buscarPorNomeDiaColeta(String nomeDiaColeta) {
        return calendarioRepository.buscarPorNomeDiaColeta(nomeDiaColeta)
                .map(CalendarioExibicaoDto::new)
                .orElseThrow(() -> new RuntimeException("Dia de coleta não existe!"));
    }

    public CalendarioExibicaoDto buscarPorHoraColeta(String horaColeta) {
        return calendarioRepository.findByHoraColeta(horaColeta)
                .map(CalendarioExibicaoDto::new)
                .orElseThrow(() -> new RuntimeException("Hora de coleta não existe!"));
    }

    public List<CalendarioExibicaoDto> listarTodos() {
        return calendarioRepository.findAll()
                .stream()
                .map(CalendarioExibicaoDto::new)
                .toList();
    }

    public void excluir(Long id) {
        Optional<Calendario> calendarioColetaOptional =
                calendarioRepository.findById(id);

        if (calendarioColetaOptional.isPresent()) {
            calendarioRepository.delete(calendarioColetaOptional.get());
        } else {
            throw new RuntimeException("Calendário não encontrado!");
        }
    }

    public Calendario atualizar(Calendario calendario) {
        Optional<Calendario> calendarioColetaOptional =
                calendarioRepository.findById(calendario.getIdCalendario());

        if (calendarioColetaOptional.isPresent()) {
            return calendarioRepository.save(calendario);
        } else {
            throw new RuntimeException("Calendário não encontrado!");
        }
    }

}
