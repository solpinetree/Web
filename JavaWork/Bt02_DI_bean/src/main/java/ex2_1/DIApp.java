package ex2_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DIApp implements CommandLineRunner{
	
	@Autowired
	OperatorBean operator;
	
	public static void main(String[] args) {
		System.out.println("Main 시작");
		SpringApplication.run(DIApp.class, args);
		System.out.println("Main 종료");
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------------------------");
		System.out.println("run()..");
		int value = operator.doOperate();
		System.out.println("결과:" + value);
	}

}
