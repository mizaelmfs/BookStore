
package com.mizael.bookstore.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizael.bookstore.entity.ItemSale;
import com.mizael.bookstore.entity.Sale;
import com.mizael.bookstore.entity.User;
import com.mizael.bookstore.repository.ItemSaleRepository;
import com.mizael.bookstore.repository.SaleRepository;
import com.mizael.bookstore.security.CurrentUser;

@Service
public class SaleService {

	@Autowired
	SaleRepository saleRepository;

	@Autowired
	ItemSaleRepository itemSaleRepository;

	@Autowired
	UserService userService;

	@Autowired
	private CurrentUser currentUser;

	public Sale save(Sale sale) {
		User user = this.userService.findByEmail(currentUser.getActiveUser().getEmail());

		sale.setUser(user);
		sale.setDate(new Date());

		Sale saleReturn = saleRepository.save(sale);
		
		for(ItemSale item: sale.getItensSale()){
			item.setSale(saleReturn);
			itemSaleRepository.save(item);
		}
		
		return saleReturn;
	}
	
	public Iterable<Sale> getSales() {
		return saleRepository.findAll();
	}

}
