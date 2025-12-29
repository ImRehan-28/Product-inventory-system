package com.productinventory.dao;

import java.util.List;
import com.productinventory.model.Stock;

public interface StockDAO 
{
	boolean addSupplier(Stock stock);
	boolean updateSupplier(Stock stock);
	boolean deleteSupplier(int stockId);
	Stock getSupplierById(int stockId);
	List<Stock> getAllStocks();
}