package br.ufscar.dc.dsw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.service.spec.ILojaService;

@RestController
@RequestMapping("/lojas")
public class LojaRestController {
    
    @Autowired
    private ILojaService service;

    @GetMapping
    public ResponseEntity<List<Loja>> lista() {
        List<Loja> lista = service.buscarTodos();
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loja> lista(@PathVariable("id") long id) {
        Loja loja = service.buscarPorId(id);
        if (loja == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(loja);
    }

    @PostMapping
	@ResponseBody
    public ResponseEntity<Loja> cria(@Valid @RequestBody Loja loja, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		service.salvar(loja);
		return ResponseEntity.ok(loja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loja> atualiza(@PathVariable("id") long id, @Valid @RequestBody Loja loja, BindingResult result) {
        if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
        loja.setId(id);
		service.salvar(loja);
        return ResponseEntity.ok(loja);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {
        Loja loja = service.buscarPorId(id);
        if (loja == null) {
            return ResponseEntity.notFound().build();
        }
        service.excluir(id);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}

