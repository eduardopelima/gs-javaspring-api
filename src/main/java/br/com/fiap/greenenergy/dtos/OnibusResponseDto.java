package br.com.fiap.greenenergy.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnibusResponseDto {
    
    private Long id;
    private String marca;
    private String tipoEnergiaVerde;
    private int potenciaCavalos;
    private int lotacaoMaxima;

}