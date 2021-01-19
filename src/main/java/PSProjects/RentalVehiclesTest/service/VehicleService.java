package PSProjects.RentalVehiclesTest.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PSProjects.RentalVehiclesTest.entity.Vehicle;
import PSProjects.RentalVehiclesTest.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> listAll(){
		return vehicleRepository.findAll();
	}
	
	public Optional<Vehicle> findById(UUID vehicleId) {
		return vehicleRepository.findById(vehicleId);
	}
	
	public Vehicle create(Vehicle vehicle) {
		// Salva veículo no BD, através da função built-in do JPA no repository
		return vehicleRepository.save(vehicle);
	}
	
	public Vehicle updateById(UUID vehicleId, Vehicle vehicle){
		//return vehicleRepository.existsById(vehicleId);
		
		if (!vehicleRepository.existsById(vehicleId)) {
			// Caso Id do veículo não exista:
			//return ResponseEntity.notFound().build();
			return null;
		}

		vehicle.setId(vehicleId);
		vehicle = vehicleRepository.save(vehicle);
		return vehicle;
		//return ResponseEntity.ok(vehicle); // Retorna 200 (OK)
	}
	
	public Void deleteById(UUID vehicleId) {

		if (!vehicleRepository.existsById(vehicleId)) {
			// Se não existe, retorna 404
			//return ResponseEntity.notFound().build();
			return null;
		}
		
		vehicleRepository.deleteById(vehicleId);
		return null;
		//return ResponseEntity.noContent().build(); // Retorna 204, sucesso.
	}
}
