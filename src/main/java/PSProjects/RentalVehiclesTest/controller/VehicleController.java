package PSProjects.RentalVehiclesTest.controller;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
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

import PSProjects.RentalVehiclesTest.entity.Vehicle;
import PSProjects.RentalVehiclesTest.repository.VehicleRepository;
import PSProjects.RentalVehiclesTest.service.VehicleService;

@RestController
@RequestMapping("/vehicles") // Assim padroniza os acessos internos na url.
public class VehicleController {
	// Aqui é o controlador, chamamos o service (regra de negócio) como
	// intermediário quando queremos fazer alguma requisição no banco.

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private VehicleRepository vehicleRepository;
	// Acima eu busco uma instância de VehicleRepository

	/*
	 * Para conseguir acesso via url aqui - localhost:8080/vehicles: Foi adicionado
	 * o @GetMapping com o endpoint da url, assim como o @RestController
	 * 
	 * @RestController é adicionado sempre que deseja realizar requisições, O
	 * GetMapping o mapeamento da url desta requisição. Quanto é de post, então
	 * é @PostMapping("url"), etc
	 */

	@GetMapping // Ou: @GetMapping("")
	public List<Vehicle> listAll() {
		// Função para listagem de todos os dados

		return vehicleService.listAll();
	}

	@GetMapping("/{vehicleId}")
	public Vehicle listById(@PathVariable UUID vehicleId) {
		// Busca um veículo pelo ID em /vehicles/id:
		// Com o {var}, lê o dado da url informada e pega pelo @PathVariable

		// ResponseEntity é um tipo que retorna a resposta retornada da requisição.
		// Bom para manipular melhor a resposta a ser dada.

		return vehicleService.findById(vehicleId).orElse(null);

		// if (vehicle.isPresent())
		// return ResponseEntity.ok(vehicle.get()); // Retorna o objeto com 200
		// }
		// return ResponseEntity.notFound().build(); // Não achou, retorna 404
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vehicle create(@RequestBody Vehicle vehicle) {
		// Função para cadastro de veículo, repare que usa anotação @PostMapping

		// Com @RequestBody faz com que o corpo da requisição seja transformada no
		// objeto Vehicle para utilizarmos no Java

		return vehicleService.create(vehicle);
	}

	@PutMapping("/{vehicleId}")
	public Vehicle updateById(@PathVariable UUID vehicleId, @RequestBody Vehicle vehicle) {
		// Lanço para o update do service, ele efetua tudo.
		return vehicleService.updateById(vehicleId, vehicle);
	}

	// @CrossOrigin(origins = "http://localhost:8080") //Teste pois estava dando
	// status 405
	@DeleteMapping("/{vehicleId}")
	public Void deleteById(@PathVariable UUID vehicleId) {
		return vehicleService.deleteById(vehicleId);
	}

	// ABAIXO DAQUI SÃO MÉTODO ANTIGOS (POR SER UM PROJETO DE TESTE MANTIVE) :

	@GetMapping("/search-by-slice-name")
	public List<Vehicle> searchBySliceName(String search) {
		// Função que usa método implementando na interface;
		return vehicleRepository.findByNameContaining("e");
	}

	@GetMapping("/search-by-name")
	public List<Vehicle> searchByName(String search) {
		// Função que usa método implementando na interface;
		return vehicleRepository.findByName("Edge");
	}

	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/list-all-basic-bd")
	public List<Vehicle> listAllBasicBD() {
		// Aqui uma consulta de LISTAGEM com estilo do jpa hibernate, com ligação com o
		// Postgres:
		return manager.createQuery("from Vehicle", Vehicle.class).getResultList();
	}

//	@GetMapping("/list-all-old")
//	public List<Vehicle> listAllOld() {
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
