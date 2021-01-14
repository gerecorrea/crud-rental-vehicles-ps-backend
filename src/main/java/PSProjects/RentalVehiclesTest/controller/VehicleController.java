package PSProjects.RentalVehiclesTest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import PSProjects.RentalVehiclesTest.repository.Vehicle;

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
		v1.setDescription("Motor 3.8, alto consumo, baixo conforto, estilo");
		v1.setYear(1973);
		v1.setLicense_plate("MHG0001");
		v1.setColor("Amarelo");
		v1.setFipe(45000);
		v1.setInsurance(2800);
		v1.setPhoto("randomlink");
		
		var v2 = new Vehicle();
		v2.setId(2);
		v2.setName("Edge");
		v2.setBrand("Ford");
		v2.setDescription("Motor 1.6, médio consumo, alto conforto, muita manutenção");
		v2.setYear(2013);
		v2.setLicense_plate("MHG0002");
		v2.setColor("Prata");
		v2.setFipe(52000);
		v2.setInsurance(1900);
		v2.setPhoto("randomlink");
		
		var v3 = new Vehicle();
		v3.setId(3);
		v3.setName("Corsa");
		v3.setBrand("Chevrolet");
		v2.setDescription("Motor 1.0, baixoconsumo, baixo conforto, sem estilo.");
		v2.setYear(2003);
		v2.setLicense_plate("MHG0003");
		v2.setColor("Azul");
		v2.setFipe(6500);
		v2.setInsurance(1300);
		v2.setPhoto("randomlink");
		
		return Arrays.asList(v1, v2, v3);
	}

}

