package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Item;

public interface IRestClientService {
	
	Long create(Item item);	
	
	List<Item> get();

	Item get(Long id);
	
	boolean update(Item item);
	
	boolean delete(Long id);
}
