package com.webmall.warehouse;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.HttpResource;

import feign.Response;

@RepositoryRestController
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired
	private StockRepository repository;

	@PostMapping
	@RequestMapping("{stockId}/add")
	@ResponseBody
	public ResponseEntity addStock(@PathVariable(value = "stockId") Long stockId, @PathParam(value = "quantity") Long quantity) {
		Optional<Stock> stock = repository.findById(stockId);
		
		if(stock.isPresent()) {
			stock.get().setQuantity(stock.get().getQuantity() + quantity);
			repository.save(stock.get());
			return new ResponseEntity(HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}


}