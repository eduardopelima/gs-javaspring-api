package br.com.fiap.greenenergy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Onibus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String marca;
	String tipoEnergiaVerde;
	int potenciaCavalos;
	int lotacaoMaxima;
	
	
}
