package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Studio;

public interface IStudioService {

	Studio buscarPorId(Long id);

	List<Studio> buscarTodos();

	void salvar(Studio studio);

	void excluir(Long id);
	
	boolean studioTemFilmes(Long id);
}
