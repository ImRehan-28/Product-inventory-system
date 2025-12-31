package com.productinventory.test;

import com.productinventory.dao.ProductDAO;
import com.productinventory.dao.impl.ProductDAOImpl;
import com.productinventory.model.Product;

public class ProductTest {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAOImpl();

        // 1️⃣ ADD PRODUCT
        Product product = new Product();
        product.setProductName("Laptop");
        product.setPrice(55000);
        product.setQuantity(10);
        product.setProductId(1);   // must exist in DB
        product.setSupplierId(1);   // must exist in DB
        product.setStatus("ACTIVE");

        boolean added = productDAO.addProduct(product);
        System.out.println("Product Added: " + added);

        // 2️⃣ GET PRODUCT BY ID
        Product fetchedProduct = productDAO.getProductById(1);
        if (fetchedProduct != null) {
            System.out.println("Product Name: " + fetchedProduct.getProductName());
            System.out.println("Price: " + fetchedProduct.getPrice());
        } else {
            System.out.println("Product not found");
        }

        // 3️⃣ UPDATE PRODUCT
        fetchedProduct.setPrice(52000);
        boolean updated = productDAO.updateProduct(fetchedProduct);
        System.out.println("Product Updated: " + updated);

        // 4️⃣ DELETE PRODUCT
        boolean deleted = productDAO.deleteProduct(1);
        System.out.println("Product Deleted: " + deleted);
    }
}
