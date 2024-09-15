package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Item;

public interface IItemService {

	Item buscarPorId(Long id);
	
	List<Item> buscarTodos();
	
	void salvar(Item Item);
	
	void excluir(Long id);
	
}
