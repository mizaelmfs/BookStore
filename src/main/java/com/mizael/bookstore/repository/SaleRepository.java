package com.mizael.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mizael.bookstore.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
