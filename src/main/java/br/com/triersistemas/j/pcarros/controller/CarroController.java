package br.com.triersistemas.j.pcarros.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.j.pcarros.armazenamento.SalvaDados;
import br.com.triersistemas.j.pcarros.model.CarroModel;
import br.com.triersistemas.j.pcarros.model.MotoModel;
import br.com.triersistemas.j.pcarros.model.VeiculoModel;

@RestController
@RequestMapping("/veiculo")
public class CarroController {
	
	@GetMapping("/cadastrar-carro")
	public CarroModel CadastrarVeiculo (@RequestParam String cor,
										  @RequestParam BigDecimal preco,
										  @RequestParam String marca,
										  @RequestParam String modelo) {
		
		CarroModel carro = new CarroModel(cor, preco, marca, modelo);
		
		SalvaDados.listaVeiculos.add(carro);
		
		return carro;
	}
	
	@GetMapping("/cadastrar-moto")
	public MotoModel CadastrarMoto (@RequestParam String cor,
								    @RequestParam BigDecimal preco,
								    @RequestParam String marca,
								    @RequestParam String modelo) {
		
		MotoModel moto = new MotoModel(cor, preco, marca, modelo);
		
		SalvaDados.listaVeiculos.add(moto);
		
		return moto;
	}
	
	@GetMapping("/excluir")
	public VeiculoModel ExcluirVeiculo(@RequestParam Long id) {
		for(VeiculoModel v : SalvaDados.listaVeiculos) {
			if(id.equals(v.getId())) {
				SalvaDados.listaVeiculos.remove(v);
				return v;
			}
		}
		return null;
	}
	
	@GetMapping("/listar")
	public List<VeiculoModel> ListarVeiculos() {
		return SalvaDados.listaVeiculos;
	}
	
	
}
