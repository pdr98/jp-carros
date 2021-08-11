package br.com.triersistemas.j.pcarros.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.j.pcarros.armazenamento.SalvaDados;
import br.com.triersistemas.j.pcarros.model.ClienteModel;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@GetMapping("/cadastrar")
	public ClienteModel CadastrarCliente(@RequestParam String nome,
										 @RequestParam String documento) {
		
		ClienteModel c = new ClienteModel(nome, documento);
		
		if (c.isDocumentoValido()) {
			c.geraId();
			SalvaDados.listaClientes.add(c);		
		} else {
			c.isDocumentoValido();			
			return null;
		}	
		return c;
	}
	
	@GetMapping("/listar")
	public List<ClienteModel> ListarCliente(){
		return SalvaDados.listaClientes;
	}
	
	@GetMapping("excluir")
	public ClienteModel ExcluirCliente(@RequestParam Long id) {
		ClienteModel cliente = SalvaDados.listaClientes.stream()
				.filter(c -> id.equals(c.getId()))
				.findFirst()
				.orElse(null);
		
		if(Objects.nonNull(cliente)) {
			SalvaDados.listaClientes.remove(cliente);
			return cliente;
		}	
		return null;		
	}
	
}
