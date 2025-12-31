package com.productinventory.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.productinventory.dao.ProductDAO;
import com.productinventory.model.Product;
import com.productinventory.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {

    private static final String INSERT_PRODUCT =
        "INSERT INTO product (product_id, product_name, price,quantity, status) VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_BY_ID =
        "SELECT * FROM product WHERE product_id = ?";

    private static final String SELECT_ALL =
        "SELECT * FROM product";

    private static final String UPDATE_PRODUCT =
    	    "UPDATE product SET product_name=?, price=?, status=? WHERE product_id=?";


    private static final String DELETE_PRODUCT =
        "DELETE FROM product WHERE product_id=?";

    @Override
    public boolean addProduct(Product product) 
    {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_PRODUCT)) {

            ps.setInt(1, product.getProductId());
            ps.setString(2, product.getProductName());
            ps.setDouble(3, product.getPrice());
            ps.setDouble(4, product.getQuantity());
            ps.setString(5, product.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_PRODUCT)) {

            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getStatus());
            ps.setInt(4, product.getProductId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int productId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_PRODUCT)) {

            ps.setInt(1, productId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product getProductById(int productId) {
        Product product = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_Name"));
                product.setPrice(rs.getDouble("price"));
                product.setStatus(rs.getString("status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setStatus(rs.getString("status"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
