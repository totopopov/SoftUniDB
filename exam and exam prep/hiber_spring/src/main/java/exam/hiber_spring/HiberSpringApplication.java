package exam.hiber_spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HiberSpringApplication {

	public static void main(String[] args) {
		//Creator.create(StrategyType.REPOSITORIES_AND_SERVICES,HiberSpringApplication.class); // credits to Hristo;
		SpringApplication.run(HiberSpringApplication.class, args);
	}
}
