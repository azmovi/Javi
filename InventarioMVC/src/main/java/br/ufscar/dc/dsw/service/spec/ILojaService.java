package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Loja;

public interface ILojaService {

	Loja buscarPorId(Long id);

	List<Loja> buscarTodos();

	void salvar(Loja Loja);

	void excluir(Long id);
	
	boolean lojaTemItens(Long id);
}
