package br.com.triersistemas.j.pcarros.model;

import java.math.BigDecimal;

public class AluguelModel {

	private static Long contador = 0L;
	
	private ClienteModel cliente;
	private VeiculoModel veiculo;
	private Integer qtdDias;
	private BigDecimal valorTotal;
	private EnumStatusAluguel status;
	private Long id;
	
	
	public AluguelModel(ClienteModel cliente, VeiculoModel veiculo, Integer qtdDias) {
		this.id = ++contador;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.qtdDias = qtdDias;
		this.valorTotal = veiculo.getPreco().multiply(BigDecimal.valueOf(qtdDias));
		this.status = EnumStatusAluguel.PROCESSANDO;
	}
	
	public ClienteModel getCliente() {
		return cliente;
	}
	
	public VeiculoModel getVeiculo() {
		return veiculo;
	}
	
	public Integer qtdDias() {
		return qtdDias;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	public void pagar() {
		this.status = EnumStatusAluguel.FINALIZADO;
	}
	public Long getId() {
		return id;
	}
	
}
