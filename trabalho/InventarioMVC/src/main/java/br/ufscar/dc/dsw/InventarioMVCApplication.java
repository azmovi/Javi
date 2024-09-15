package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.dao.ILojaDAO;
import br.ufscar.dc.dsw.dao.IItemDAO;
import br.ufscar.dc.dsw.domain.Item;
import br.ufscar.dc.dsw.domain.Loja;

@SpringBootApplication
public class InventarioMVCApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioMVCApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ILojaDAO lojaDAO, IItemDAO itemDAO) {
		return (args) -> {
						
			Loja e1 = new Loja();
			e1.setCNPJ("55.789.390/0008-99");
			e1.setNome("Brinquedolandia");
			e1.setCategoria("Loja de brinquedos");
			e1.setEndereco("Avenida São Carlos, 2356");
			e1.setCidade("São Carlos");
			lojaDAO.save(e1);
			
			Loja e2 = new Loja();
			e2.setCNPJ("71.150.470/0001-40");
			e2.setNome("milCoisas");
			e2.setCategoria("Loja de ferramentas e variedades");
			e2.setEndereco("Avenida Brasil, 1355");
			e2.setCidade("Rio de Janeiro");
			lojaDAO.save(e2);
			
			Loja e3 = new Loja();
			e3.setCNPJ("32.106.536/0001-82");
			e3.setNome("roupalandia");
			e3.setCategoria("Loja de roupas e sapatos");
			e3.setEndereco("Avenida Rio Branco, 2300");
			e3.setCidade("São Paulo");
			lojaDAO.save(e3);
			
			Item l1 = new Item();
			l1.setTitulo("Carrinho");
			l1.setDescricao("Carrinho de controle remoto");
			l1.setAno(1995);
			l1.setPreco(BigDecimal.valueOf(54.9));
			l1.setLoja(e1);
			itemDAO.save(l1);
			
			Item l2 = new Item();
			l2.setTitulo("Dobradiça");
			l2.setDescricao("Dobradiça 5mm");
			l2.setAno(1977);
			l2.setPreco(BigDecimal.valueOf(59.9));
			l2.setLoja(e2);
			itemDAO.save(l2);
			
			Item l3 = new Item();
			l3.setTitulo("Camiseta");
			l3.setDescricao("Camiseta Masculina tamanho M");
			l3.setAno(2012);
			l3.setPreco(BigDecimal.valueOf(22.9));
			l3.setLoja(e3);
			itemDAO.save(l3);
		};
	}
}
