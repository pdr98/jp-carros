package br.com.triersistemas.j.pcarros.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

public abstract class VeiculoModel {
	
	public static Long contador = 0L;
	
	private Long id;
	private String placa;
	private String cor;
	private BigDecimal precoPorDia;
	private LocalDateTime dataRegistrado;
	private String marca;
	
	public VeiculoModel(String cor, BigDecimal precoPorDia, String marca) {
		this.id = ++contador;
		this.cor = cor;
		this.placa = gerarPlaca();
		this.precoPorDia = precoPorDia;
		this.dataRegistrado = LocalDateTime.now();
		this.marca = marca;
	}
	
	public String getCor() {
		return cor;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public Long getId() {
		return id;
	}
	
	public BigDecimal getPreco() {
		return precoPorDia;
	}
	
	public LocalDateTime getDataRegistro() {
		return dataRegistrado;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String gerarPlaca() {
		Random r = new Random();
		StringBuilder string = new StringBuilder();

	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    for (int i = 0; i < 3; i++) {
	       char random = (alphabet.charAt(r.nextInt(alphabet.length())));
	       string.append(random);
	    }
	    int numero = r.nextInt(10);
	    string.append(numero);
	    
	    char random = (alphabet.charAt(r.nextInt(alphabet.length())));
	    string.append(random);
	    
	    int numero2 = r.nextInt(10);
	    int numero3 = r.nextInt(10);
	    
	    string.append(numero2);
	    string.append(numero3);
	    
	    String placa = string.toString();
	   
	    return placa;
	}
	
	public void alterar(String cor, BigDecimal valor, String marca) {
		this.cor = cor;
		this.precoPorDia = valor;
		this.marca = marca;
		this.placa = gerarPlaca();
	}
}
