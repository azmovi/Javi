package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.ufscar.dc.dsw.domain.Item;
import br.ufscar.dc.dsw.service.spec.IRestClientService;

@Service
public class RestClientService implements IRestClientService {

    RestClient restClient = RestClient.create("http://localhost:8081");

    @Override
    public Long create(Item item) {
    	ResponseEntity<Item> res = restClient.post()
    		    .uri("/itens")
    		    .contentType(MediaType.APPLICATION_JSON)
    		    .body(item)
    		    .retrieve()
    		    .toEntity(Item.class);
    	
    	Item i = res.getBody();

		return i.getId();
    }

    @Override
    public List<Item> get() {
        List<Item> list = restClient.get()
                .uri("/itens")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
        System.out.println("AAAAAAAAAAAAAAAAA" + list);
        return list;
    }

    @Override
    public Item get(Long id) {
        Item itens = restClient.get()
                .uri("/itens/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Item.class);
        return itens;
    }

    @Override
    public boolean update(Item item) {
    	ResponseEntity<Void> res = restClient.put()
    	  .uri("/itens/" + item.getId())
    	  .contentType(MediaType.APPLICATION_JSON)
    	  .body(item)
    	  .retrieve()
    	  .toBodilessEntity();
    	
    	return res.getStatusCode() == HttpStatus.OK;
    }

    @Override
    public boolean delete(Long id) {
    	ResponseEntity<Void> res = restClient.delete()
    			  .uri("/itens/" + id)
    			  .retrieve()
    			  .toBodilessEntity();
    	return res.getStatusCode() == HttpStatus.NO_CONTENT;
    }
}
