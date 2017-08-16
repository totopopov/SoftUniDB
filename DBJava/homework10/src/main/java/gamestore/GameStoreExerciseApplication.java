package gamestore;


import app.utilities.Creator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameStoreExerciseApplication {

	public static void main(String[] args) {
		//Creator.create(StrategyType.REPOSITORIES_AND_SERVICES,GameStoreExerciseApplication.class);
		SpringApplication.run(GameStoreExerciseApplication.class, args);
	}
}
