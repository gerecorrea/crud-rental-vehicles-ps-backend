package PSProjects.RentalVehiclesTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SpringBootApplication
public class RentalVehiclesTestApplication {

	@RequestMapping("/")
    public String home(){
        return "Hello Everybody";
    }

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Olaa %s!", name);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RentalVehiclesTestApplication.class, args);
	}

}
