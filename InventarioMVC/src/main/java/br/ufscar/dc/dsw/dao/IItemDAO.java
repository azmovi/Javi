package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Item;

@SuppressWarnings("unchecked")
public interface IItemDAO extends CrudRepository<Item, Long>{

	Item findById(long id);

	List<Item> findAll();
	
	Item save(Item Item);

	void deleteById(Long id);
}