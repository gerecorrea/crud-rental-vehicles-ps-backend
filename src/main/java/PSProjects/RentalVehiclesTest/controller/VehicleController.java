package PSProjects.RentalVehiclesTest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import PSProjects.RentalVehiclesTest.entity.Vehicle;
import PSProjects.RentalVehiclesTest.repository.VehicleRepository;

@RestController
public class VehicleController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private VehicleRepository vehicleRepository;
	// Acima eu busco uma instância de VehicleRepository

	/*
	 * Para conseguir acesso via url aqui - localhost:8080/vehicles: Foi adicionado
	 * o @GetMapping com o endpoint da url, assim como o @RestController
	 * 
	 * @RestController é adicionado sempre que deseja realizar requisições, O
	 * GetMapping o mapeamento da url desta requisição Quanto é de post, então
	 * é @PostMapping("url")
	 */

	@GetMapping("/vehicles")
	public List<Vehicle> list_from_repository() {
		// Função que, ao ter instanciando um VehicleRepostory advindo de sua interface,
		// usa o método findAll() para retornar uma lista contendo todos os dados lá
		// contidos. FUNÇÃO DE USO MAIS VÁLIDO PARA BUSCA DOS DADOS.
		return vehicleRepository.findAll();
	}

	@GetMapping("/vehicles/{vehicleId}")
	public Vehicle search(@PathVariable Long vehicleId) {
		// Busca um veículo pelo ID em /vehicles/id:
		// Com o {var}, lê o dado da url informada
		Optional<Vehicle> vehicle1 = vehicleRepository.findById(vehicleId);

		// Retorna o cliente, se não tiver, retorna null:
		return vehicle1.orElse(null);
	}

	// Abaixo daqui são métodos teste antigos:

	@GetMapping("/vehicles_search_by_name")
	public List<Vehicle> buscar_por_parte_nome_from_repository(String search) {
		// Função que usa método implementando na interface;
		return vehicleRepository.findByNameContaining("e");
	}

	@GetMapping("/vehicles_search")
	public List<Vehicle> listar_por_nome_from_repository(String search) {
		// Função que usa método implementando na interface;
		return vehicleRepository.findByName("Edge");
	}

	@GetMapping("/vehicles_basicBD")
	public List<Vehicle> listar_basicBD() {
		// Aqui uma consulta de LISTAGEM com estilo do jpa hibernate, com ligação com o
		// Postgres:
		return manager.createQuery("from Vehicle", Vehicle.class).getResultList();
	}

//	@GetMapping("/vehicles_old")
//	public List<Vehicle> listar_old() {
//		// Consulta básica, instanciando manualmente, sem ligação com banco.
//
//		// Import list do java.util (interface List), assim como classe Cliente
//		// var v1 = new Vehicle("Corsa","Motor
//		// 1.0","Chevrolet",2003,"MHE8777","Carro","preto",4550.0,334.5,"linkfoto",2);
//		var v1 = new Vehicle();
//		v1.setId(1);
//		v1.setName("Maverick");
//		v1.setDescription("Motor 3.8, alto consumo, baixo conforto, estilo");
//		v1.setBrand("Ford");
//		v1.setYear(1973);
//		v1.setLicense_plate("MHG0001");
//		v1.setType("Carro");
//		v1.setColor("Amarelo");
//		v1.setFipe(45000);
//		v1.setInsurance(2800);
//		v1.setPhoto("randomlink");
//		v1.setQuantity(3);
//
//		var v2 = new Vehicle();
//		v2.setId(2);
//		v2.setName("Edge");
//		v2.setDescription("Motor 1.6, médio consumo, alto conforto, muita manutenção");
//		v2.setBrand("Ford");
//		v2.setYear(2013);
//		v2.setLicense_plate("MHG0002");
//		v2.setType("Carro");
//		v2.setColor("Prata");
//		v2.setFipe(52000);
//		v2.setInsurance(1900);
//		v2.setPhoto("randomlink");
//		v2.setQuantity(3);
//
//		var v3 = new Vehicle();
//		v3.setId(3);
//		v3.setName("Corsa");
//		v3.setDescription("Motor 1.0, baixoconsumo, baixo conforto, sem estilo.");
//		v3.setBrand("Chevrolet");
//		v3.setYear(2003);
//		v3.setLicense_plate("MHG0003");
//		v3.setType("Carro");
//		v3.setColor("Azul");
//		v3.setFipe(6500);
//		v3.setInsurance(1300);
//		v3.setPhoto("randomlink");
//		v3.setQuantity(3);
//
//		return Arrays.asList(v1, v2, v3);
//	}

}
