package br.com.triersistemas.j.pcarros.model;

import java.math.BigDecimal;

public class MotoModel extends VeiculoModel {
	
	
	private String modelo;

	
	public MotoModel(String cor, BigDecimal precoPorDia, String marca, String modelo) {
		super(cor, precoPorDia, marca);
		this.modelo = modelo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	
}
