package br.ufscar.dc.dsw.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.domain.Studio;
import br.ufscar.dc.dsw.service.spec.IStudioService;

@Component
public class StudioConversor implements Converter<String, Studio>{

	@Autowired
	private IStudioService service;
	
	@Override
	public Studio convert(String text) {
		
		if (text.isEmpty()) {
		 return null;	
		}
		
		Long id = Long.valueOf(text);	
		return service.buscarPorId(id);
	}
}
