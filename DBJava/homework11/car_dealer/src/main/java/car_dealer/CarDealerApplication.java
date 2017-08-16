package car_dealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDealerApplication {
	public static void main(String[] args) {
		//Creator.create(StrategyType.REPOSITORIES_AND_SERVICES,CarDealerApplication.class);
		SpringApplication.run(CarDealerApplication.class, args);
	}
}
