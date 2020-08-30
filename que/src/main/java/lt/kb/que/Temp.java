package lt.kb.que;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp  {
    public static void main(String[] args) {
        SpringApplication.run(QueApplication.class, args);
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String rawPassword="inga";
        String encodedPassword=encoder.encode(rawPassword);
        System.out.println( "pass "+ encodedPassword);
    }
}
