package br.com.fiap.greenenergy.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.greenenergy.dtos.OnibusRequestCreateDto;
import br.com.fiap.greenenergy.dtos.OnibusRequestUpdateDto;
import br.com.fiap.greenenergy.dtos.OnibusResponseDto;
import br.com.fiap.greenenergy.model.Onibus;

@Component
public class OnibusMapper {
    @Autowired
    private ModelMapper modelMapper;

    public OnibusResponseDto toDto(Onibus onibus) {
        return modelMapper.map(onibus, OnibusResponseDto.class);
    }

    public Onibus toModel(OnibusRequestCreateDto dto) {
        return modelMapper.map(dto, Onibus.class);
    }

    public Onibus toModel(OnibusRequestUpdateDto dto, Long id) {
        return modelMapper.map(dto, Onibus.class);
    }
}
