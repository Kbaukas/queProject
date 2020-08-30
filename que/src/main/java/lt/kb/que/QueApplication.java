package lt.kb.que;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class QueApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueApplication.class, args);

	}

}
