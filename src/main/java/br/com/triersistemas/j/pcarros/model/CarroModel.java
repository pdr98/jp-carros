package br.com.triersistemas.j.pcarros.model;

import java.math.BigDecimal;

public class CarroModel extends VeiculoModel{

	private String modelo;
	
	public CarroModel(String cor, BigDecimal precoPorDia, String marca, String modelo) {
		super(cor, precoPorDia, marca);
		this.modelo = modelo;
	}
	
	public String getModelo() {
		return modelo;
	}
	

}
