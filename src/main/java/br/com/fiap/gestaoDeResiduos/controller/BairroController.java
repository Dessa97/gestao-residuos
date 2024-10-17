package br.com.fiap.gestaoDeResiduos.controller;

import br.com.fiap.gestaoDeResiduos.dto.BairroCadastroDto;
import br.com.fiap.gestaoDeResiduos.dto.BairroExibicaoDto;
import br.com.fiap.gestaoDeResiduos.model.Bairro;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.gestaoDeResiduos.service.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BairroController {
    @Autowired
    private BairroService bairroService;

    @PostMapping("/bairro")
    @ResponseStatus(HttpStatus.CREATED)
    public BairroCadastroDto salvar(@RequestBody @Valid BairroCadastroDto bairro) {
        return bairroService.salvarBairro(bairro);
    }

    @GetMapping("/bairro")
    @ResponseStatus(HttpStatus.OK)
    public List<BairroExibicaoDto> litarTodos() {

        return bairroService.listarTodos();
    }

    @GetMapping("/bairro/{bairroId}")
    public ResponseEntity<BairroExibicaoDto> buscarPorId(@PathVariable Long bairroId) {
        BairroExibicaoDto bairroExibicaoDto = bairroService.buscarPorId(bairroId);
        return ResponseEntity.ok(bairroExibicaoDto);
    }

    @GetMapping("/bairro/nome/{nomeBairro}")
    public ResponseEntity<BairroExibicaoDto> buscarPorNomeBairro(@PathVariable String nomeBairro) {
        BairroExibicaoDto bairroExibicaoDto = bairroService.buscarPorNomeBairro(nomeBairro);
        return ResponseEntity.ok(bairroExibicaoDto);
    }

    @RequestMapping(value = "/bairro", params = "nomeCidade")
    public ResponseEntity<BairroExibicaoDto> buscarPorNomeCidade(@RequestParam String nomeCidade) {
        BairroExibicaoDto bairroExibicaoDto = bairroService.buscarPorNomeCidade(nomeCidade);
        return ResponseEntity.ok(bairroExibicaoDto);
    }


    @DeleteMapping("/bairro/{bairroId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long bairroId) {
        bairroService.excluir(bairroId);
    }

    @PutMapping("/bairro")
    @ResponseStatus(HttpStatus.OK)
    public Bairro atualizar(@RequestBody Bairro bairro) {
        return bairroService.atualizar(bairro);
    }

}
