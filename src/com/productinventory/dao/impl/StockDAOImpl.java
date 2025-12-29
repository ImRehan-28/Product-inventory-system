package com.productinventory.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import com.productinventory.dao.StockDAO;
import com.productinventory.model.Stock;
import com.productinventory.util.DBConnection;

public class StockDAOImpl implements StockDAO {

    private static final String INSERT_STOCK =
        "INSERT INTO stock (stock_id, product_id, quantity, status) VALUES (?, ?, ?, ?)";

    private static final String UPDATE_STOCK =
        "UPDATE stock SET product_id=?, quantity=?, status=? WHERE stock_id=?";

    private static final String DELETE_STOCK =
        "DELETE FROM stock WHERE stock_id=?";

    private static final String SELECT_BY_ID =
        "SELECT * FROM stock WHERE stock_id=?";

    private static final String SELECT_ALL =
        "SELECT * FROM stock";

    @Override
    public boolean addStock(Stock stock) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_STOCK)) {

        	ps.setInt(1, stock.getStockId());
        	ps.setInt(2, stock.getProductId());
        	ps.setDouble(3, stock.getAvailableQuantity());
        	ps.setDouble(4, stock.getReservedQuantity());
        	ps.setTimestamp(5, Timestamp.valueOf(stock.getLastUpdated()));


            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStock(Stock stock) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_STOCK)) {

        	ps.setInt(1, stock.getProductId());
        	ps.setDouble(2, stock.getAvailableQuantity());
        	ps.setDouble(3, stock.getReservedQuantity());
        	ps.setTimestamp(4, Timestamp.valueOf(stock.getLastUpdated()));
        	ps.setInt(5, stock.getStockId());


            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStock(int stockId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_STOCK)) {

            ps.setInt(1, stockId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Stock getStockById(int stockId) {
        Stock stock = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, stockId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                stock = new Stock();
                stock.setStockId(rs.getInt("stock_id"));
                stock.setProductId(rs.getInt("product_id"));
                stock.setAvailableQuantity(rs.getDouble("available_quantity"));
                stock.setReservedQuantity(rs.getDouble("reserved_quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Stock stock = new Stock();
                stock.setStockId(rs.getInt("stock_id"));
                stock.setProductId(rs.getInt("product_id"));
                stock.setAvailableQuantity(rs.getDouble("available_quantity"));
                stock.setReservedQuantity(rs.getDouble("reserved_quantity"));
                stock.setLastUpdated(
                    rs.getTimestamp("last_updated").toLocalDateTime()
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }
}