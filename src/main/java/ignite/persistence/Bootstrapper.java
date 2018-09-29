package ignite.persistence;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("applicationContext.xml")
@MapperScan("ignite.persistence.mapper")
public class Bootstrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Bootstrapper.class, args);
	}

}
