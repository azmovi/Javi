package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.dao.ILivroDAO;
import br.ufscar.dc.dsw.dao.IEditoraDAO;
import br.ufscar.dc.dsw.domain.Editora;
import br.ufscar.dc.dsw.domain.Livro;

@SpringBootApplication
public class LivrariaJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(LivrariaJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LivrariaJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ILivroDAO livroDAO, IEditoraDAO editoraDAO) {
		return (args) -> {

            Editora e1 = new Editora();
            e1.setCNPJ("87.557.922/0001-82");
            e1.setNome("Seguinte");
            editoraDAO.save(e1);

            Livro l1 = new Livro();
            l1.setTitulo("O dia do Curinga");
            l1.setAutor("Jostein Gaarder");
            l1.setAno(1996);
            l1.setPreco(new BigDecimal(29.99));
            l1.setEditora(e1);
            livroDAO.save(l1);


            Livro l2 = new Livro();
            l2.setTitulo("A Revolução dos Bichos");
            l2.setAutor("George Orwell");
            l2.setAno(2007);
            l2.setPreco(new BigDecimal(23.90));
            Editora e2 = editoraDAO.findByNome("Companhia das Letras");
            if (e2 != null)
            {
                l2.setEditora(e2);
                livroDAO.save(l2);
            }
            
			// Recupere todos livros

			log.info("Livros recuperados -- findAllByPreco():");
			log.info("--------------------------------");
			for (Livro livro : livroDAO.findByOrderByPreco()) {
				log.info(livro.toString());
			}
			log.info("");

			// Recupere um livro por seu ID

		};
	}

}
