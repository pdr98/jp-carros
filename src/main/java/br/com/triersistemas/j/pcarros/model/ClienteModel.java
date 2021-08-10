package br.com.triersistemas.j.pcarros.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel {
	
	private static Long gerador = 0L;
	
	private Long id;
	private String nome;
	private String documento;
	
	public ClienteModel(String nome, String documento) {
		this.nome = nome;
		this.documento = documento;
	}

	public static Long getGerador() {
		return gerador;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void addDigito(List<BigDecimal> list) {
		BigDecimal soma = BigDecimal.ZERO;

		for (Integer i = 0; i < list.size(); i++) {
			soma = soma.add(list.get(i).multiply(BigDecimal.valueOf(i + 1)));
		}

		BigDecimal resto = soma.remainder(BigDecimal.valueOf(11));

		if (resto.equals(BigDecimal.valueOf(10))) {
			list.add(BigDecimal.valueOf(0));
		} else {
			list.add(resto);
		}

		soma = BigDecimal.ZERO;

		for (Integer i = 0; i < list.size(); i++) {
			soma = soma.add(list.get(i).multiply(BigDecimal.valueOf(i)));
		}

		resto = soma.remainder(BigDecimal.valueOf(11));

		if (resto.equals(BigDecimal.valueOf(10))) {
			list.add(BigDecimal.ZERO);
		} else {
			list.add(resto);
		}
	}

	public Boolean isDocumentoValido() {

		if (documento.toCharArray().length != 11) {
			return false;
		}

		List<BigDecimal> listDoc = new ArrayList<>();

		for (int i = 0; i <= 8; i++) {
			String numero = String.valueOf(documento.toCharArray()[i]);

			listDoc.add(new BigDecimal(numero));
		}

		addDigito(listDoc);

		String ultimoDigito = String.valueOf(documento.toCharArray()[10]);

		return listDoc.get(10).compareTo(new BigDecimal(ultimoDigito)) == 0;

	}

	public String getDocumento() {
		String cpf = documento;
		StringBuilder cpfFormatado = new StringBuilder();

		StringBuilder cpfP1 = new StringBuilder();
		;
		StringBuilder cpfP2 = new StringBuilder();
		;
		StringBuilder cpfP3 = new StringBuilder();
		;
		StringBuilder cpfP4 = new StringBuilder();
		;

		for (int i = 0; i < 3; i++) {
			cpfP1.append(cpf.toCharArray()[i]);
		}
		for (int i = 3; i < 6; i++) {
			cpfP2.append(cpf.toCharArray()[i]);
		}
		for (int i = 6; i < 9; i++) {
			cpfP3.append(cpf.toCharArray()[i]);
		}
		for (int i = 9; i < 11; i++) {
			cpfP4.append(cpf.toCharArray()[i]);
		}

		cpfFormatado.append(cpfP1).append(".").append(cpfP2).append(".").append(cpfP3).append("-").append(cpfP4);

		return cpfFormatado.toString();
	}
	
	public void geraId() {
		this.id = ++gerador;		
	}
}
