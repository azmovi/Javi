package br.ufscar.dc.dsw;

import java.math.BigDecimal;
import java.time.LocalDate;

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
            s1.setCnpj("14.144.588/0001-61");
            s1.setNome("Dreamworks");
            s1.setAno(1994);
            studioDAO.save(s1);

            Studio s2 = new Studio();
            s2.setCnpj("35.409.101/0001-03");
            s2.setNome("Lionsgate");
            s2.setAno(1997);
            studioDAO.save(s2);

            Studio s3 = new Studio();
            s3.setCnpj("25.264.263/0001-39");
            s3.setNome("Paramount");
            s3.setAno(1912);
            studioDAO.save(s3);

            Filme f1 = new Filme();
            f1.setTitulo("Shrek");
            f1.setDiretor("Andrew Adamson");
            f1.setData(LocalDate.of(2001, 4, 22));
            f1.setNota(BigDecimal.valueOf(4.1));
            f1.setGenero("Comédia");
            f1.setStudio(s1);
            filmeDAO.save(f1);

            Filme f2 = new Filme();
            f2.setTitulo("American Psycho");
            f2.setDiretor("Mary Harron");
            f2.setData(LocalDate.of(2000, 1, 21));
            f2.setNota(BigDecimal.valueOf(7.6));
            f2.setGenero("Suspense");
            f2.setStudio(s2);
            filmeDAO.save(f2);

            Filme f3 = new Filme();
            f3.setTitulo("Top Gun");
            f3.setDiretor("Tony Scott");
            f3.setData(LocalDate.of(1986, 5, 12));
            f3.setNota(BigDecimal.valueOf(6.9));
            f3.setGenero("Ação");
            f3.setStudio(s3);
            filmeDAO.save(f3);
        };
    }
}

