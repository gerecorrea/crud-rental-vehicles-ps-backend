package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.Vehicle;

@RestController
public class VehicleController {

	/*
	 * Para conseguir acesso via url aqui - localhost:9090/clientes: Foi adicionado
	 * o @GetMapping com o endpoint da url, assim como o @RestController
	 * 
	 * @RestController é adicionado sempre que deseja realizar requisições, O
	 * GetMapping o mapeamento da url desta requisição Quanto é de post, então
	 * é @PostMapping("url")
	 */
	@GetMapping("/vehicles")
	public List<Vehicle> listar() {
		// Import list do java.util (interface List), assim como classe Cliente
		//var v1 = new Vehicle("Corsa","Motor 1.0","Chevrolet",2003,"MHE8777","Carro","preto",4550.0,334.5,"linkfoto",2);
		var v1 = new Vehicle();
		v1.setId(1);
		v1.setName("Maverick");
		v1.setBrand("Ford");
		
		var v2 = new Vehicle();
		v2.setId(2);
		v2.setName("Edge");
		v2.setBrand("Ford");
		
		return Arrays.asList(v1, v2);
	}

}
