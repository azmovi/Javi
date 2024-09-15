package br.ufscar.dc.dsw;

import java.util.List;
import java.math.BigDecimal;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.domain.Item;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.service.spec.IRestClientService;

@SpringBootApplication
public class ClientInventarioApplication{

	private static final Logger log = LoggerFactory.getLogger(ClientInventarioApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClientInventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(IRestClientService service) throws Exception {
		return args -> {
			
            Loja e1 = new Loja();
            e1.setId(1L);
			e1.setCNPJ("55.321.390/0008-99");
			e1.setNome("test loja ");
			e1.setCategoria("Loja de brinquedos xptoj");
			e1.setEndereco("Avenida São Carlos, 2356");
			e1.setCidade("São Carlos");

            Item item = new Item();
            item.setTitulo("Carrinho");
            item.setDescricao("Carrinho de controle remoto");
            item.setAno(1995);
            item.setPreco(BigDecimal.valueOf(54.9));
            item.setLoja(e1);


			log.info("-----------------------------------");
			log.info("save()");
			log.info("-----------------------------------");
			Long id = service.create(item);
			log.info("Salvo Item [" + id + "] " + item.toString());
			log.info("-----------------------------------");
			log.info("getItems()");
			log.info("-----------------------------------");
			List<Item> items = service.get();
			for (Item c : items) {
				log.info(c.toString());
			}
			log.info("-----------------------------------");
			log.info("Numero de Items: " + items.size());
			log.info("-----------------------------------");
			log.info("getItem (" + id + ")");
			log.info("-----------------------------------");
			item = service.get(id);
			log.info(item.toString());

			log.info("-----------------------------------");
			log.info("Numero de Items: " + items.size());
			log.info("-----------------------------------");

			item.setTitulo("Teste Item atualizada");
            item.setLoja(e1);
            System.out.println("AAAAAAAAAAAAAa" +   item);
			boolean ok = service.update(item);
			log.info("update (" + id + ") " + ok);
			log.info("-----------------------------------");
			log.info("getItem (" + id + ")");
			log.info("-----------------------------------");
			item = service.get(id);
			log.info(item.toString());
			log.info("-----------------------------------");
			ok = service.delete(id);
			log.info("remove (" + id + ") " + ok);
			log.info("-----------------------------------");
			items = service.get();
			log.info("Numero de Items: " + items.size());
			log.info("-----------------------------------");
		};
	}
}
