package br.ufscar.dc.dsw.controller;

import java.math.BigDecimal;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import br.ufscar.dc.dsw.domain.Item;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.service.spec.IItemService;
import br.ufscar.dc.dsw.service.spec.ILojaService;

@RestController
@RequestMapping("/itens")
public class ItemRestController {

    @Autowired
    private IItemService itemService;

    @Autowired
    private ILojaService lojaService;

    private boolean isJSONValid(String jsonInString) {
        try {
            new ObjectMapper().readTree(jsonInString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void parse(Item item, JSONObject json) {
        item.setTitulo((String) json.get("titulo"));
        item.setDescricao((String) json.get("descricao"));
        item.setAno((Integer) json.get("ano"));

        Object preco = json.get("preco");
        if (preco instanceof String) {
            item.setPreco(BigDecimal.valueOf(Double.parseDouble((String) preco)));
        } else if (preco instanceof Number) {
            item.setPreco(BigDecimal.valueOf(((Number) preco).doubleValue()));
        }

        Object lojaId = json.get("lojaId");
        if (lojaId instanceof Integer) {
            Loja loja = lojaService.buscarPorId(((Integer) lojaId).longValue());
            item.setLoja(loja);
        }
    }

    @GetMapping
    public ResponseEntity<List<Item>> lista() {
        List<Item> lista = itemService.buscarTodos();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
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
    public ResponseEntity<Item> cria(@RequestBody JSONObject json) {
        try {
            if (isJSONValid(json.toString())) {
                Item item = new Item();
                parse(item, json);
                if (item.getLoja() == null) {
                    return ResponseEntity.badRequest().body(null);
                }
                itemService.salvar(item);
                return ResponseEntity.status(HttpStatus.CREATED).body(item);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualiza(@PathVariable("id") long id, @RequestBody JSONObject json) {
        try {
            if (isJSONValid(json.toString())) {
                Item itemExistente = itemService.buscarPorId(id);
                if (itemExistente == null) {
                    return ResponseEntity.notFound().build();
                }
                parse(itemExistente, json);
                if (itemExistente.getLoja() == null) {
                    return ResponseEntity.badRequest().body(null);
                }
                itemService.salvar(itemExistente);
                return ResponseEntity.ok(itemExistente);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") long id) {
        Item item = itemService.buscarPorId(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        itemService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

