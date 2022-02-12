package com.gft.eventos.services;

import com.gft.eventos.entities.Participante;
import com.gft.eventos.repositories.ParticipanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;


    public Page<Participante> listarTodosParticipantes(Pageable pageable) {

        return participanteRepository.findAll(pageable);
    }


    public Participante listarUmParticipante(Long id) {

        Optional<Participante> procuraParticipante = participanteRepository.findById(id);

        return procuraParticipante.orElseThrow(() -> new EntityNotFoundException("Participante não encontrado"));

    }


    public Participante salvarParticipante(Participante participante) {

        return participanteRepository.save(participante);
    }

    public Participante alterarParticipante(Participante participante, Long id) {

        Participante participanteOriginal = this.listarUmParticipante(id);

        participante.setId(participanteOriginal.getId());

        return participanteRepository.save(participante);

    }

    public void excluirParticipante(Long id) {

        Participante verificaParticipanteExiste = this.listarUmParticipante(id);

        participanteRepository.delete(verificaParticipanteExiste);

    }


}
