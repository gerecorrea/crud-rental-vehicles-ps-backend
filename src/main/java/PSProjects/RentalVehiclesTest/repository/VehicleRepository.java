package PSProjects.RentalVehiclesTest.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PSProjects.RentalVehiclesTest.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
	// O "Long" é o tipo da variável de identificação/primária padrão
	// Aqui foi utilizado o UUID, para geração automática do Id dos veículos

	// Criando métodos para uso na instanciação do VehicleRepository:
	// OBS: O JPA implementa isso pra gente em boa parte

	// Método que busca um veículo pelo seu nome completo:
	List<Vehicle> findByName(String name);

	// Método que busca um veículo que possua ao menos dada parte da string:
	List<Vehicle> findByNameContaining(String name);

}
