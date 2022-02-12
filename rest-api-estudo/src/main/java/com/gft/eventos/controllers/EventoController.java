package com.gft.eventos.controllers;

import com.gft.eventos.dto.evento.ConsultaEventoDTO;
import com.gft.eventos.dto.evento.EventoMapper;
import com.gft.eventos.dto.evento.RegistroEventoDTO;
import com.gft.eventos.entities.Evento;
import com.gft.eventos.services.EventoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/v1")
@Api(value = "API REST Eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    private final EventoService eventoService;

    @PostMapping("/eventos")
    @ApiOperation(value = "Salva um evento")
    public ResponseEntity<ConsultaEventoDTO> cadastraEvento(@RequestBody @Valid RegistroEventoDTO dto) {

        Evento evento = eventoService.salvarEvento(EventoMapper.fromDTO(dto));

        return new ResponseEntity<>((EventoMapper.fromEntity(evento)), HttpStatus.CREATED);

    }

    @GetMapping("/eventos")
    @ApiOperation(value = "Retorna uma lista de eventos")
    public ResponseEntity<Page<ConsultaEventoDTO>> buscaEventos(@PageableDefault Pageable pageable) {


        return new ResponseEntity<>(eventoService.listarTodosEventos(pageable)
                .map(EventoMapper::fromEntity), HttpStatus.OK);

    }

    @GetMapping("/eventos/{id}")
    @ApiOperation(value = "Retorna um evento")
    public ResponseEntity<ConsultaEventoDTO> buscaEventoPorId(@PathVariable(value = "id") Long id) {

        Evento evento = eventoService.listarUmEvento(id);

        return new ResponseEntity<>(EventoMapper.fromEntity(evento), HttpStatus.OK);

    }

    @PutMapping("/eventos/{id}")
    @ApiOperation(value = "Atualiza um evento")
    public ResponseEntity<ConsultaEventoDTO> atualizaEvento(@RequestBody @Valid RegistroEventoDTO dto,
                                                            @PathVariable(value = "id") Long id) {

        Evento evento = eventoService.alterarEvento(EventoMapper.fromDTO(dto), id);

        return ResponseEntity.ok(EventoMapper.fromEntity(evento));

    }

    @DeleteMapping("/eventos/{id}")
    @ApiOperation(value = "Apaga um evento")
    public ResponseEntity<?> excluirEvento(@PathVariable(value = "id") Long id) {

        eventoService.excluirEvento(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}

