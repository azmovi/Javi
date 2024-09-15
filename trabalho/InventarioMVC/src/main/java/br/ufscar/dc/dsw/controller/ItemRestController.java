package br.ufscar.dc.dsw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;


import br.ufscar.dc.dsw.domain.Item;
import br.ufscar.dc.dsw.service.spec.IItemService;

@RestController
@RequestMapping("/itens")
public class ItemRestController {

    @Autowired
    private IItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> lista() {
        List<Item> lista = itemService.buscarTodos();
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> lista(@PathVariable("id") long id) {
        Item item = itemService.buscarPorId(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    @PostMapping
	@ResponseBody
	public ResponseEntity<Item> cria(@Valid @RequestBody Item item, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		itemService.salvar(item);
		return ResponseEntity.ok(item);
	}

    @PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Item> atualizar(@PathVariable("id") long id, @Valid @RequestBody Item item, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
			return ResponseEntity.badRequest().build();
		}
        item.setId(id);
		itemService.salvar(item);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable("id") long id) {
        Item item = itemService.buscarPorId(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        itemService.excluir(id);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}

