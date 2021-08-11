package br.com.triersistemas.j.pcarros.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.j.pcarros.armazenamento.SalvaDados;
import br.com.triersistemas.j.pcarros.model.AluguelModel;
import br.com.triersistemas.j.pcarros.model.ClienteModel;
import br.com.triersistemas.j.pcarros.model.VeiculoModel;

@RestController
@RequestMapping("/alugar")
public class AlguelController {

	
	@GetMapping("/veiculo")
	public AluguelModel AlugarVeiculo(@RequestParam (value = "id-cliente") Long idCliente,
							  @RequestParam (value = "id-veiculo") Long idVeiculo,
							  @RequestParam Integer dias) {
		
		ClienteModel cliente = SalvaDados.listaClientes.stream().filter(c -> idCliente.equals(c.getId())).findFirst().orElse(null);
		VeiculoModel veiculo = SalvaDados.listaVeiculos.stream().filter(v -> idCliente.equals(v.getId())).findFirst().orElse(null);
		
		if(Objects.nonNull(veiculo) && Objects.nonNull(cliente)) {
			
			AluguelModel aluguel = new AluguelModel(cliente, veiculo, dias);
			
			SalvaDados.listaAluguel.add(aluguel);
			
			return aluguel;
		}
		return null;
	}
	
	@GetMapping("/remover")
	public AluguelModel RemoverPedido(@RequestParam Long id) {
		for(AluguelModel a : SalvaDados.listaAluguel) {
			if(id.equals(a.getId())) {
				SalvaDados.listaAluguel.remove(a);
				return a;
			}
		}
		return null;
	}
	
	@GetMapping("/alterar")
	public AluguelModel AlterarPedido(@RequestParam Long id,
									 @RequestParam String cor,
									 @RequestParam BigDecimal valor,
									 @RequestParam String marca) {
		for(AluguelModel a : SalvaDados.listaAluguel) {
			if(id.equals(a.getId())) {
				a.getVeiculo().alterar(cor, valor, marca);
				return a;
			}
		}
		return null;
	}
	
	@GetMapping("/listar")
	public List<AluguelModel> ListarVeiculos() {
		return SalvaDados.listaAluguel;
	}
	
	@GetMapping("/finalizar")
	public AluguelModel FinalizarAluguel(@RequestParam Long id) {
		for(AluguelModel a : SalvaDados.listaAluguel) {
			if(id.equals(a.getId())) {
				a.pagar();
				return a;
			}
		}
		return null;
	}
}

