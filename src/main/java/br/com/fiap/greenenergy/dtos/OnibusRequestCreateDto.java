package br.com.fiap.greenenergy.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnibusRequestCreateDto {
    String marca;
	String tipoEnergiaVerde;
	int potenciaCavalos;
	int lotacaoMaxima;
}
