package com.productinventory.dao;

import java.util.List;
import com.productinventory.model.Stock;

public interface StockDAO
{
	boolean addStock(Stock stock);
	boolean updateStock(Stock stock);
	boolean deleteStock(int stockId);
	Stock getStockById(int stockId);
	List<Stock> getAllStocks();
}