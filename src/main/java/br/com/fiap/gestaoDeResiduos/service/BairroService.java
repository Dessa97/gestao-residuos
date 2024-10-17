package br.com.fiap.gestaoDeResiduos.service;

import br.com.fiap.gestaoDeResiduos.dto.BairroCadastroDto;
import br.com.fiap.gestaoDeResiduos.dto.BairroExibicaoDto;
import br.com.fiap.gestaoDeResiduos.model.Bairro;
import br.com.fiap.gestaoDeResiduos.repository.BairroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {
    @Autowired
    private BairroRepository bairroRepository;

    public BairroCadastroDto salvarBairro(BairroCadastroDto bairroCadastroDto) {
        Bairro bairro = new Bairro();
        BeanUtils.copyProperties(bairroCadastroDto, bairro);
        Bairro bairroSalvo = bairroRepository.save(bairro);
        return new BairroCadastroDto(bairroSalvo);
    }

    public List<BairroExibicaoDto> listarTodos() {
        return bairroRepository.findAll()
                .stream()
                .map(BairroExibicaoDto::new)
                .toList();
    }

    public BairroExibicaoDto buscarPorId(Long id) {
        return bairroRepository.findById(id)
                .map(BairroExibicaoDto::new)
                .orElseThrow(() -> new RuntimeException("Bairro não existe!"));
    }

    public BairroExibicaoDto buscarPorNomeBairro(String nomeBairro) {
        return bairroRepository.buscarPorNomeBairro(nomeBairro)
                .map(BairroExibicaoDto::new)
                .orElseThrow(() -> new RuntimeException("Bairro não existe!"));
    }

    public BairroExibicaoDto buscarPorNomeCidade(String nomeCidade) {
        return bairroRepository.findByNomeCidade(nomeCidade)
                .map(BairroExibicaoDto::new)
                .orElseThrow(() -> new RuntimeException("Cidade não existe!"));
    }

    public void excluir(Long id) {
        Optional<Bairro> bairroOptional =
                bairroRepository.findById(id);

        if (bairroOptional.isPresent()) {
            bairroRepository.delete(bairroOptional.get());
        } else {
            throw new RuntimeException("Bairro não encontrado!");
        }
    }

    public Bairro atualizar(Bairro bairro) {
        Optional<Bairro> bairroOptional =
                bairroRepository.findById(bairro.getIdBairro());

        if (bairroOptional.isPresent()) {
            return bairroRepository.save(bairro);
        } else {
            throw new RuntimeException("Bairro não encontrado!");
        }
    }

}
