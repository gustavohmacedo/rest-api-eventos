package com.gft.eventos.controllers;

import com.gft.eventos.dto.tecnologia.ConsultaTecnologiaDTO;
import com.gft.eventos.dto.tecnologia.RegistroTecnologiaDTO;
import com.gft.eventos.dto.tecnologia.TecnologiaMapper;
import com.gft.eventos.entities.Tecnologia;
import com.gft.eventos.services.TecnologiaService;
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
@RequestMapping("v1/tecnologias")
@Api(value = "API REST Eventos")
@CrossOrigin(origins = "*")
public class TecnologiaController {

    private final TecnologiaService tecnologiaService;


    @PostMapping
    @ApiOperation(value = "Salva uma tecnologia")
    public ResponseEntity<ConsultaTecnologiaDTO> cadastraTecnologia(@RequestBody @Valid RegistroTecnologiaDTO dto) {

        Tecnologia tecnologia = tecnologiaService.salvarTecnologia(TecnologiaMapper.fromDTO(dto));

        return new ResponseEntity<>((TecnologiaMapper.fromEntity(tecnologia)), HttpStatus.CREATED);

    }


    @GetMapping
    @ApiOperation(value = "Retorna uma lista de tecnologias")
    public ResponseEntity<Page<ConsultaTecnologiaDTO>> buscaTecnologias(@PageableDefault Pageable pageable) {

        return new ResponseEntity<>(tecnologiaService.listarTodasTecnologias(pageable)
                .map(TecnologiaMapper::fromEntity), HttpStatus.OK);

    }


    @GetMapping("{id}")
    @ApiOperation(value = "Retorna uma tecnologia")
    public ResponseEntity<ConsultaTecnologiaDTO> buscaTecnologiaPorId(@PathVariable Long id) {

        Tecnologia tecnologia = tecnologiaService.listarUmaTecnologia(id);

        return new ResponseEntity<>(TecnologiaMapper.fromEntity(tecnologia), HttpStatus.OK);

    }


    @PutMapping("{id}")
    @ApiOperation(value = "Atualiza uma tecnologia ")
    public ResponseEntity<ConsultaTecnologiaDTO> atualizaTecnologia(@RequestBody @Valid RegistroTecnologiaDTO dto,
                                                                    @PathVariable Long id) {

        Tecnologia tecnologia = tecnologiaService.alterarTecnologia(TecnologiaMapper.fromDTO(dto), id);

        return new ResponseEntity<>(TecnologiaMapper.fromEntity(tecnologia), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Apaga uma tecnologia")
    public ResponseEntity<?> excluiTecnologia(@PathVariable Long id) {


        tecnologiaService.excluirTecnologia(id);

        return new ResponseEntity<>(HttpStatus.OK);


    }
}
