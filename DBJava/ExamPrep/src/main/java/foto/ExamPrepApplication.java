package foto;

import app.enums.StrategyType;
import app.utilities.Creator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamPrepApplication {

	public static void main(String[] args) {
//		Creator.create(StrategyType.REPOSITORIES_AND_SERVICES,ExamPrepApplication.class);
		SpringApplication.run(ExamPrepApplication.class, args);
	}
}
