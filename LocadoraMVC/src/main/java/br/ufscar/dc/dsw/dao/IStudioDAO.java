package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Studio;

@SuppressWarnings("unchecked")
public interface IStudioDAO extends CrudRepository<Studio, Long>{

	Studio findById(long id);
	
	Studio findByCnpj (String cnpj);

	List<Studio> findAll();
	
	Studio save(Studio studio);

	void deleteById(Long id);
}
