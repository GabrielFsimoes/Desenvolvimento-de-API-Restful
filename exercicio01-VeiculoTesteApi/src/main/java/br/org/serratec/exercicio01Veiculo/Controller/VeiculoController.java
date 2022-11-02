package br.org.serratec.exercicio01Veiculo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.exercicio01Veiculo.domain.Veiculo;


@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	public static List<Veiculo> veiculos = new ArrayList<Veiculo>();
	static {
		veiculos.add(new Veiculo(1,"Fiat","Palio"));
		veiculos.add(new Veiculo(2,"Fiat","Uno"));
		veiculos.add(new Veiculo(3,"Fiat","Mobi"));
		veiculos.add(new Veiculo(4,"Honda","Civic"));
	}
	
	@GetMapping
	public List<Veiculo> listaVeiculos() {
		return veiculos;
	} 
	
	@GetMapping("/{id}")
	public Veiculo buscarVeiculo(@PathVariable int id) {
		for (int i = 0; i < veiculos.size(); i++) {
			Veiculo veiculo = veiculos.get(i);
			if (veiculo.getId().equals(id)) {
				return veiculo;
			}
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
	veiculos.add(veiculo);
	return veiculo;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
	for (int i = 0; i< veiculos.size(); i++) {
	if (veiculos.get(i).getId().equals(id)) {
		veiculos.remove(i);
	break;
	}
	}
	}
	
	@PutMapping("/{id}")
	public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable Integer id) {
	for (int i = 0; i< veiculos.size(); i++) {
	if (veiculos.get(i).getId().equals(id)) {
		Veiculo v = new Veiculo(id, veiculo.getMarca(),veiculo.getModelo());
		veiculos.set(i, v);
	return v;
	}
	}
	return null;
	}
}
