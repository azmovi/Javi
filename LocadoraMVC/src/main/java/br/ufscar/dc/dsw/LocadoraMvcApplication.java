package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.dao.IStudioDAO;
import br.ufscar.dc.dsw.dao.IFilmeDAO;
import br.ufscar.dc.dsw.domain.Studio;
import br.ufscar.dc.dsw.domain.Filme;

@SpringBootApplication
public class LocadoraMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IStudioDAO studioDAO, IFilmeDAO filmeDAO) {
		return (args) -> {
						
			Studio s1 = new Studio();
			s1.setCNPJ("92.910.189/0001-78");
			s1.setNome("Dreamworks");
			s1.setAno(2001);
			studioDAO.save(s1);
			
			Studio s2 = new Studio();
			s2.setCNPJ("07.827.649/0001-20");
			s2.setNome("Lionsgate");
            s2.setAno(1997);
			studioDAO.save(s2);
			
			Studio s3 = new Studio();
			s3.setCNPJ("87.762.101/0001-88");
			s3.setNome("Paramount");
            s3.setAno(1912);
			studioDAO.save(s3);
			
			Filme f1 = new Filme();
			f1.setTitulo("Shrek");
			f1.setDiretor("Andrew Adamson");
			f1.setAno(2001);
			f1.setOrcamento(BigDecimal.valueOf(60));
            f1.setNota(8);
            f1.setGenero("Animação");
			f1.setStudio(s1);
			filmeDAO.save(f1);
			
			Filme f2 = new Filme();
			f2.setTitulo("Psicopata Americano");
			f2.setDiretor("Mary Harron");
			f2.setAno(2000);
			f2.setOrcamento(BigDecimal.valueOf(7));
            f2.setGenero("Suspense");
            f2.setNota(7);
			f2.setStudio(s2);
			filmeDAO.save(f2);
			
			Filme f3 = new Filme();
			f3.setTitulo("Top Gun");
			f3.setDiretor("Tony Scott");
			f3.setAno(1986);
			f3.setOrcamento(BigDecimal.valueOf(15));
            f3.setGenero("Ação");
            f3.setNota(5);
			f3.setStudio(s3);
			filmeDAO.save(f3);
		};
	}
}
