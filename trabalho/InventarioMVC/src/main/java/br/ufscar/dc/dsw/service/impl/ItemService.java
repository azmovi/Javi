package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IItemDAO;
import br.ufscar.dc.dsw.domain.Item;
import br.ufscar.dc.dsw.service.spec.IItemService;

@Service
@Transactional(readOnly = false)
public class ItemService implements IItemService {

	@Autowired
	IItemDAO dao;
	
	public void salvar(Item Item) {
		dao.save(Item);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Item buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Item> buscarTodos() {
		return dao.findAll();
	}
}
