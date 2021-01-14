package PSProjects.RentalVehiclesTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SpringBootApplication
public class RentalVehiclesTestApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(RentalVehiclesTestApplication.class, args);
	}

}
