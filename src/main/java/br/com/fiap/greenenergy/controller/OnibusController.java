package br.com.fiap.greenenergy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.greenenergy.dtos.OnibusRequestCreateDto;
import br.com.fiap.greenenergy.dtos.OnibusRequestUpdateDto;
import br.com.fiap.greenenergy.dtos.OnibusResponseDto;
import br.com.fiap.greenenergy.mapper.OnibusMapper;
import br.com.fiap.greenenergy.service.OnibusService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("onibus")
public class OnibusController {
    private final OnibusService onibusService;
    private final OnibusMapper onibusMapper;

    @GetMapping
    public ResponseEntity<List<OnibusResponseDto>> list() {
        List<OnibusResponseDto> dtos = onibusService.list()
                                            .stream()
                                            .map(e -> onibusMapper.toDto(e))
                                            .toList();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<OnibusResponseDto> create(@RequestBody OnibusRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    onibusMapper.toDto(
                        onibusService.save(onibusMapper.toModel(dto))
                    )
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!onibusService.existsById(id)) {
            throw new RuntimeException("Id inexistente");
        }
        onibusService.delete(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<OnibusResponseDto> update(
        @PathVariable Long id,
        @RequestBody OnibusRequestUpdateDto dto
    ) {
        if (!onibusService.existsById(id)) {
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity
                .ok()
                .body(
                    onibusMapper.toDto(
                        onibusService.save(onibusMapper.toModel(dto, id))
                    )
                );
    }

    @GetMapping("{id}")
    public ResponseEntity<OnibusResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(
                    onibusService
                        .findById(id)
                        .map(e -> onibusMapper.toDto(e))
                        .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );
                
    }

}
