package esprit.candidat;

import esprit.candidat.condidatRepo.CondidatRepo;
import esprit.candidat.entity.Condidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CandidatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatApplication.class, args);
	}
	@Autowired
	private CondidatRepo condidatRepo;
	@Bean
	public ApplicationRunner init(){
		return (args)->{
		condidatRepo.save(new Condidat("rayen","farahni","rayen@esprit.tn"));
	};
}}
