package com.productinventory.dao;

import java.util.List;
import com.productinventory.model.Supplier;

public interface SuppilerDAO 
{
	boolean addSupplier(Supplier supplier);
	boolean updateSupplier(Supplier supplier);
	boolean deleteSupplier(int supplierId);
	Supplier getSupplierById(int supplierId);
	List<Supplier> getAllSuppliers();
}
