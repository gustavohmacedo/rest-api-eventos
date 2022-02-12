package com.gft.eventos.services;

import com.gft.eventos.entities.Tecnologia;
import com.gft.eventos.repositories.TecnologiaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TecnologiaService {

    private final TecnologiaRepository tecnologiaRepository;


    public Tecnologia salvarTecnologia(Tecnologia tecnologia) {

        return tecnologiaRepository.save(tecnologia);
    }


    public Tecnologia listarUmaTecnologia(Long id) {

        Optional<Tecnologia> procuraTecnologia = tecnologiaRepository.findById(id);

        return procuraTecnologia.orElseThrow(() -> new EntityNotFoundException("Tecnologia não encontrada"));
    }


    public Page<Tecnologia> listarTodasTecnologias(Pageable pageable) {

        return tecnologiaRepository.findAll(pageable);
    }


    public Tecnologia alterarTecnologia(Tecnologia tecnologia, Long id) {

        Tecnologia tecnologiaOriginal = this.listarUmaTecnologia(id);

        tecnologia.setId(tecnologiaOriginal.getId());

        return tecnologiaRepository.save(tecnologia);

    }

    public void excluirTecnologia(Long id) {

        Tecnologia verificaTecnologiaExiste = this.listarUmaTecnologia(id);

        tecnologiaRepository.delete(verificaTecnologiaExiste);

    }
}
