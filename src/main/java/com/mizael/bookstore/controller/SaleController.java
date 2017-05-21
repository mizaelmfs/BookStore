package com.mizael.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mizael.bookstore.entity.Sale;
import com.mizael.bookstore.service.SaleService;
import com.mizael.bookstore.utils.Path;

@Controller
@RequestMapping(value = Path.SALE_PATH)
public class SaleController {

	@Autowired SaleService saleService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Sale sale){
		
			saleService.save(sale);
	
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
