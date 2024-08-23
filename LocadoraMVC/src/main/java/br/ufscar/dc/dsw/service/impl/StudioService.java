package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IStudioDAO;
import br.ufscar.dc.dsw.domain.Studio;
import br.ufscar.dc.dsw.service.spec.IStudioService;

@Service
@Transactional(readOnly = false)
public class StudioService implements IStudioService {

	@Autowired
	IStudioDAO dao;
	
	public void salvar(Studio studio) {
		dao.save(studio);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Studio buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Studio> buscarTodos() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public boolean studioTemFilmes(Long id) {
		return !dao.findById(id.longValue()).getFilmes().isEmpty(); 
	}
}
