package br.com.fiap.gestaoDeResiduos.controller;

import br.com.fiap.gestaoDeResiduos.dto.CalendarioCadastroDto;
import br.com.fiap.gestaoDeResiduos.dto.CalendarioExibicaoDto;
import br.com.fiap.gestaoDeResiduos.model.Calendario;
import br.com.fiap.gestaoDeResiduos.service.CalendarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalendarioController {
    @Autowired
    private CalendarioService calendarioService;

    @PostMapping("/calendario")
    @ResponseStatus(HttpStatus.CREATED)
    public CalendarioCadastroDto salvar(@RequestBody @Valid CalendarioCadastroDto calendarioColeta) {
        return calendarioService.salvarCalendario(calendarioColeta);
    }

    @GetMapping("/calendario")
    @ResponseStatus(HttpStatus.OK)
    public List<CalendarioExibicaoDto> litarTodos() {
        return calendarioService.listarTodos();
    }

    @GetMapping("/calendario/{calendarioId}")
    public ResponseEntity<CalendarioExibicaoDto> buscarPorId(@PathVariable Long calendarioId) {
        CalendarioExibicaoDto calendarioExibicaoDto = calendarioService.buscarPorId(calendarioId);
        return ResponseEntity.ok(calendarioExibicaoDto);
    }

    @GetMapping("/calendario/nome/{nomeDiaColeta}")
    public ResponseEntity<CalendarioExibicaoDto> buscarPorNomeDiaColeta(@PathVariable String nomeDiaColeta) {
        CalendarioExibicaoDto calendarioExibicaoDto = calendarioService.buscarPorNomeDiaColeta(nomeDiaColeta);
        return ResponseEntity.ok(calendarioExibicaoDto);
    }

    @RequestMapping(value = "/calendario", params = "horaColeta")
    public ResponseEntity<CalendarioExibicaoDto> buscarPorHoraColeta(@RequestParam String horaColeta) {
        CalendarioExibicaoDto calendarioExibicaoDto = calendarioService.buscarPorHoraColeta(horaColeta);
        return ResponseEntity.ok(calendarioExibicaoDto);
    }

    @DeleteMapping("/calendario/{calendarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long calendarioId) {
        calendarioService.excluir(calendarioId);
    }

    @PutMapping("/calendario")
    @ResponseStatus(HttpStatus.OK)
    public Calendario atualizar(@RequestBody Calendario calendario) {
        return calendarioService.atualizar(calendario);
    }

}
