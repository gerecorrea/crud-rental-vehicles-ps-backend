package PSProjects.RentalVehiclesTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PSProjects.RentalVehiclesTest.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	// O "Long" é o tipo da variável de identificação/primária, que é o id
	// Eu declarei o id como int, porém não aceita, como Long é apenas um int grande
	// e aceitou, deixei assim.
	// Com Long funcionou, já testado

	// Criando métodos para uso na instanciação do VehicleRepository:
	// OBS: O JPA implementa isso pra gente (como?), apenas passamos as variáveis 

	// Função que busca um veículo pelo seu nome completo:
	List<Vehicle> findByName(String name);

	// Função que busca um veículo que possua ao menos dada parte da string:
	List<Vehicle> findByNameContaining(String name);
	
	
	
}
