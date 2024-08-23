package br.ufscar.dc.dsw.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.dao.IStudioDAO;
import br.ufscar.dc.dsw.domain.Studio;

@Component
public class UniqueCnpjValidator implements ConstraintValidator<UniqueCnpj, String> {

	@Autowired
	private IStudioDAO dao;

	@Override
	public boolean isValid(String cnpj, ConstraintValidatorContext context) {
		if (dao != null) {
			Studio studio = dao.findByCnpj(cnpj);
			return studio == null;
		} else {
			return true;
		}

	}
}
