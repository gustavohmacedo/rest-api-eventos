package com.gft.eventos.services;

import com.gft.eventos.entities.Evento;
import com.gft.eventos.repositories.EventoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EventoService {

    private final EventoRepository eventoRepository;


    public Page<Evento> listarTodosEventos(Pageable pageable) {

        return eventoRepository.findAll(pageable);
    }


    public Evento listarUmEvento(Long id) {

        Optional<Evento> procuraEvento = eventoRepository.findById(id);

        return procuraEvento.orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));

    }


    public Evento salvarEvento(Evento evento) {

        return eventoRepository.save(evento);
    }


    public Evento alterarEvento(Evento evento, Long id) {

        Evento eventoOriginal = this.listarUmEvento(id);

        evento.setId(eventoOriginal.getId());

        return eventoRepository.save(evento);

    }


    public void excluirEvento(Long id) {

        Evento verificaEventoExiste = this.listarUmEvento(id);

        eventoRepository.delete(verificaEventoExiste);

    }
}