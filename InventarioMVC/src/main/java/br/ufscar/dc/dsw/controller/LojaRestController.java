package br.ufscar.dc.dsw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
            return ResponseEntity.noContent().build();
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
    public ResponseEntity<Loja> cria(@RequestBody Loja loja) {
        try {
            service.salvar(loja);
            return ResponseEntity.status(HttpStatus.CREATED).body(loja);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loja> atualiza(@PathVariable("id") long id, @RequestBody Loja loja) {
        try {
            Loja lojaExistente = service.buscarPorId(id);
            if (lojaExistente == null) {
                return ResponseEntity.notFound().build();
            }
            loja.setId(id);
            service.salvar(loja);
            return ResponseEntity.ok(loja);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") long id) {
        Loja loja = service.buscarPorId(id);
        if (loja == null) {
            return ResponseEntity.notFound().build();
        }
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

